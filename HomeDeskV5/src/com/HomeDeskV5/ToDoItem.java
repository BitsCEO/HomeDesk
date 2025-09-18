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
	public String getSuffix() {
		// TODO ToDoItem.getSuffix()
		return null;
	}

	public String getDesc() {
		return desc;
	}

	public PRIORITY getPriority() {
		return priority;
	}

	public boolean isCompleted() {
		return completed;
	}

	public List<ToDoItem> getPreReqs() {
		return preReqs;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setPriority(PRIORITY priority) {
		this.priority = priority;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public void setPreReqs(List<ToDoItem> preReqs) {
		this.preReqs = preReqs;
	}

}
