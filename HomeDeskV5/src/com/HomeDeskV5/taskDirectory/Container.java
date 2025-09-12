package com.HomeDeskV5.taskDirectory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.HomeDeskV5.Entity;
import com.HomeDeskV5.ToDoItem;

public abstract class Container extends Entity implements Iterable<Entity> {
	private Map<String, Container> containers;
	private Map<String, ToDoItem> items;
	
	public Container(String typeSuffix, String title, HDPath path) {
		super(typeSuffix, title, path);
		
		this.containers = new HashMap<>();
		this.items = new HashMap<>();
	}
	
	public boolean isEmpty() {
		return (this.getContainers().size() == 0 && this.getItems().size() == 0);
	}
	
	public ArrayList<Entity> getContents() {
		ArrayList<Entity> contents = new ArrayList<>();
		
		for (String k:containers.keySet()) {
			contents.add(containers.get(k));
		}
		
		for (String k:items.keySet()) {
			contents.add(items.get(k));
		}
		
		return contents;
	}

	public Map<String, Container> getContainers() {
		return containers;
	}

	public Map<String, ToDoItem> getItems() {
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
