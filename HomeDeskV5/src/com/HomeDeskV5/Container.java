package com.HomeDeskV5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Container extends Entity implements Iterable<ToDoItem> {
	
	private Map<String, ToDoItem> toDoItems;
	
	public Container(String title, HDPath parent) {
		super(title, parent);
		
		this.toDoItems = new HashMap<>();
	}
	
	public abstract boolean isEmpty();
	
	public abstract int getNumItems();
	
	public abstract ArrayList<Entity> getContents();

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getSuffix() {
		// TODO Auto-generated method stub
		return null;
	}

}
