package com.HomeDeskV5.taskDirectory;

import java.util.ArrayList;
import java.util.Iterator;

import com.HomeDeskV5.Entity;
import com.HomeDeskV5.ToDoItem;

public abstract class Container extends Entity implements Iterable<Entity> {
	private ArrayList<Container> containers;
	private ArrayList<ToDoItem> items;
	
	public Container(String typeSuffix, HDPath path) {
		super(typeSuffix, path);
		
		this.containers = new ArrayList<>();
		this.items = new ArrayList<>();
		this.getPath().extend(this);
	}
	
	public boolean isEmpty() {
		return (this.getContainers().size() == 0 && this.getItems().size() == 0);
	}
	
	public ArrayList<Entity> getContents() {
		ArrayList<Entity> contents = new ArrayList<>();
		
		for (Container c:containers) {
			contents.add(c);
		}
		
		for (ToDoItem tdi:items) {
			contents.add(tdi);
		}
		
		return contents;
	}

	public ArrayList<Container> getContainers() {
		return containers;
	}

	public ArrayList<ToDoItem> getItems() {
		return items;
	}
	
	/**
	 * Method returns the number of elements in a container, items and containers, for use with banners to indicate 
	 * 	contents
	 * @return number of containers and items in container
	 */
	public int getNumElements() {
		int numElems = 0;
		numElems += containers.size();
		numElems += items.size();
		return numElems; 
	}
	
	public ContainerIterator iterator() {
		return new ContainerIterator();
	}
	
	private class ContainerIterator implements Iterator<Entity> {
		private ArrayList<Entity> contents = getContents();
		private int currIndex = 0;
		
		@Override
		public boolean hasNext() {
			return currIndex < contents.size();
		}

		@Override
		public Entity next() {
			return contents.get(currIndex++);
		}
		
	}
}
