package com.HomeDeskV5;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Container extends Entity implements Iterable<Entity> {
	
	private HashMap<String, ToDoItem> toDoItems;
	
	public Container() {
		super("root", new HDPath());
		
		this.toDoItems = new HashMap<>();
	}
	
	public Container(String title, HDPath parent) {
		super(title, parent);
		
		this.toDoItems = new HashMap<>();
	}
	
	public boolean acceptItem(ToDoItem itemToAdd) {
		String key = itemToAdd.getTitle();
		
		// If that key already exists, handle collision
		if (toDoItems.containsKey(key)) {
			System.out.println("Object with that name already exists here! No action taken");
			return false;
		} else {
			itemToAdd.makePathHere(this);
			toDoItems.put(key, itemToAdd);
			return true;
		}
	}
	
	public abstract boolean isEmpty();
	
	public abstract int getNumItems();
	
	public abstract ArrayList<Entity> getContentsList();

	@Override
	public abstract String getSuffix();

	public HashMap<String, ToDoItem> getToDoItems() {
		return toDoItems;
	}

}
 