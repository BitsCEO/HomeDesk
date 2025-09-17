package com.HomeDeskV5;

import java.util.List;

public abstract class ToDoItem extends Entity {
	
	public static enum PRIORITY {
		NONE,
		LOW,
		MEDIUM,
		HIGH
	}
	
	private String desc;
	private PRIORITY priority;
	private boolean completed;
	
	private List<ToDoItem> preReqs;

	public ToDoItem(String title, HDPath parent) {
		super(title, parent);
		
		this.desc = "";
		this.priority = PRIORITY.NONE;
		this.completed = false;
	}

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
