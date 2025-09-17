package com.HomeDeskV5;

import java.io.IOException;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Path describing a location within a HomeDesk directory
 */
public class HDPath implements Comparable<HDPath>, Iterable<Entity>, Watchable {
	private ArrayList<Entity> nodes;
	
	public HDPath() {
		this.nodes = new ArrayList<>();
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
	
	public String toString() {
		if (nodes.size() == 0) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(nodes.get(0).getTitle());
		
		for (int i = 1; i < nodes.size();) {
			sb.append("/" + nodes.get(i).getTitle());
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
		// TODO implement HDPath.iterator()
		return null;
	}
	
}
