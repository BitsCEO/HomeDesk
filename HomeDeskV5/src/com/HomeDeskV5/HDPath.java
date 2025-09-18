package com.HomeDeskV5;

import java.io.IOException;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Path describing a location within a HomeDesk directory
 */
public class HDPath implements Comparable<HDPath>, Iterable<Entity>, Watchable {
	private ArrayList<Entity> nodes;
	
	/**
	 * Dummy HDPath
	 */
	public HDPath() {
		this.nodes = new ArrayList<>();
	}
	
	/**
	 * Copy an HDPath object. This is used to create cursors
	 */
	public HDPath(HDPath path) {
		nodes = new ArrayList<>();
		for (Entity e:path.getNodes()) {
			nodes.add(e);
		}
	}
	
	public HDPath(HDPath parent, Entity leaf) {
		this.nodes = parent.getNodes();
		this.extend(leaf);
	}
	
	public Container getRoot() {
		if (nodes.size() > 0) {
			return (Container) nodes.get(0);
		} else {
			return null;
		}
	}
	
	public Container getParent() {
		if (nodes.size() > 1) {
			return (Container) nodes.get((nodes.size() - 2));
		}
		else
			return null;
	}
	
	public Iterator<Entity> walker() {
		return new Walker();
	}
	
	/**
	 * Class that describes a Walker object to touch every item in a directory and
	 *  all subdirectories
	 *
	 */
	private class Walker implements Iterator<Entity> {
		private Queue<Container> ctnrQueue;
		private Entity startingPlace = nodes.getLast();
		
		private ArrayList<Entity> theWalk;
		private int currIndex;
		
		public Walker () {
			this.ctnrQueue = new LinkedList<>();
			
			this.theWalk = new ArrayList<>();
			this.currIndex = 0;
			
			if (startingPlace.getClass() != Container.class) {
				// Walker is called on an item rather then a container, and so stops
				
				theWalk.add(startingPlace);
				
			} 
			else {
				
				ctnrQueue.add((Container) startingPlace);
				
				// Iterate all containers that need walking. Add items to the walk, and containers to 
				//  ctnrsToWalk
				for (Container ctnr:ctnrQueue) {
					
					// Iterate all entities in the container
					for (Entity ent:ctnr) {

						if (ent.getClass() == Container.class) {
							// Container is found. Add to queue
							
							ctnrQueue.add((Container) ent);
							
						} else {
							// ToDoItem is found. Add to walk
							
							theWalk.add(ent);
							
						}	
					}	
				}	
			}
		}
		
		@Override
		public boolean hasNext() {
			return currIndex < theWalk.size();
		}

		@Override
		public Entity next() {
			return theWalk.get(currIndex++);
		}
		
	}
	
	public String toString() {
		if (nodes.size() == 0) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(nodes.get(0).getTitle());
		
		for (int i = 1; i < nodes.size();) {
			sb.append(">" + nodes.get(i).getTitle());
		}
		
		return sb.toString();
	}
	
	public void print() {
		String str = this.toString();
		
		if (str.length() == 0) {
			System.out.println("ERROR: Path object has no nodes");
			return;
		} 
		
		System.out.println(str);
		return;
	}
	
	private void extend(Entity newNode) {
		this.nodes.add(newNode);
	}

	/**
	 * This compareTo method compares two HDPath objects and finds the highest level difference and then compares that high level 
	 *  difference alphabetically. Like other compareTo() methods, if this path "comes before" the other path, return -1. 
	 *  If it "comes after", return 1. If the HDPath objects trace the same path, return 0. Both paths refer to the same object. If 
	 *  one path is shorter than the other path, but they match through the end of the shorter path, the shorter path comes before the longer. 
	 */
	@Override
	public int compareTo(HDPath otherPath) {
		
		// Get nodes
		ArrayList<Entity> theseNodes = this.getNodes();
		ArrayList<Entity> thoseNodes = otherPath.getNodes();
		
		// Determine length of shorter path
		int lenOfShortPath = Math.min(theseNodes.size(), thoseNodes.size());
		
		int comp = 0;     // Comparison field
		int index = 0;
		
		// Get title of root node of each path
		String thisTitle = theseNodes.get(index).getTitle();
		String thatTitle = thoseNodes.get(index).getTitle();
		
		// Find first unlike node
		while (comp == 0 && index < lenOfShortPath) {
			
			comp = naturallyCompareNames(thisTitle, thatTitle);
			
			// If the titles of the Entities match, iterate to next level
			if (comp == 0) {
				index++;
			}
		}
		
		// If comp is still 0, all node titles matched through the entire shortest path. If this path is shorter than 
		//  that path, return -1. If it is longer, return 1. Else, the paths are equivalent. Return 0.
		if (comp == 0) {
			return Integer.compare(theseNodes.size(), thoseNodes.size());
		}
		
		// If comp DOES NOT equal zero, we must compare the titles at the index (which now makes the level of node 
		//  where the difference was found)
		else {
			return comp;
		}
	}
	
	public Entity contains() {
		return nodes.getLast();
	}

	public ArrayList<Entity> getNodes() {
		return nodes;
	}
	
	/**
	 * This method compares two object names and orders them in a human-natural way. If names are simply compared
	 *  lexicographically, file10.txt would be ordered before file2.txt. It makes more sense to humans for file2.txt to
	 *  come BEFORE file10.txt, which is what this method accomplishes
	 * 
	 * @param thisName
	 * @param thatName
	 * @return integer indicating comparison
	 */
	private int naturallyCompareNames(String thisName, String thatName) {
		char[] theseChars = thisName.toCharArray();
		char[] thoseChars = thatName.toCharArray();
		char thisChar;
		char thatChar;
		
		int index = 0;           // To track our movement through the array
		int comp = 0;            // The comparison value
		
		// Iterate through chars, comparing them. The loop only exits once a difinitive comparison is made or the 
		//  end of the short name is reached
		while (comp == 0 && (index < theseChars.length && index < thoseChars.length)) {
			thisChar = theseChars[index];
			thatChar = thoseChars[index];
			
			// if chars are the same and not digits, just increment index
			if (Character.compare(thisChar, thatChar) == 0 && !Character.isDigit(thisChar)) {
				index++;
			} 
			
			// if both chars are digits, we must loop to capture however many consecutive characters follow
			else if (Character.isDigit(thisChar) && Character.isDigit(thatChar)) {
				int thisNum = extractNum(theseChars, index);
				int thatNum = extractNum(thoseChars, index);
				
				comp = Integer.compare(thisNum, thatNum);
				
				// if comp is still 0, the found digits matched. Advance the index by the length of those digits
				if (comp == 0) {
					int temp = thisNum;
					
					while (temp > 0) {
						temp /= 10;
						index++;
					}
				}
			}
			
			// At least one of the two compared characters is not a digit and they do not match. 
			//  Compare the chars as normal
			else {
				
				comp = Character.compare(thisChar, thatChar);
				
			}
			
		}
		
		return comp;
	}
	
	/**
	 * This method takes a character array and, starting at a given index, finds as many consecutive digits as possible
	 *  and returns them as a single integer
	 * 
	 * @param charArray
	 * @param index
	 * @return the integer found starting at the given index
	 */
	private int extractNum(char[] charArray, int index) {
		StringBuilder numSB = new StringBuilder();
		
		boolean endOfNum = false;
		
		while (!endOfNum && index < charArray.length) {
			
			if (Character.isDigit(charArray[index])) {
				numSB.append(charArray[index]);
				index++;
				
			} else {
				endOfNum = true;
			}
			
		}
		
		return Integer.parseInt(numSB.toString());
		
	}
	
	@Override
	public WatchKey register(WatchService watcher, Kind<?>[] events, Modifier... modifiers) throws IOException {
		// TODO implement HDPath.register(WatchService, Kind<?>..., Modifier...)
		return null;
	}

	@Override
	public WatchKey register(WatchService watcher, Kind<?>... events) throws IOException {
		// TODO implement HDPath.register(WatchService, Kind<?>...)
		return null;
	}

	@Override
	public Iterator<Entity> iterator() {
		return new PathIterator();
	}
	
	private class PathIterator implements Iterator<Entity> {
		private int currDepth = 0;

		@Override
		public boolean hasNext() {
			return (currDepth < nodes.size());
		}

		@Override
		public Entity next() {
			
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			
			return nodes.get(currDepth++);
		}
		
	}
	
}
