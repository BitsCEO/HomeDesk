package com.HomeDeskV5;

import java.time.LocalDateTime;

import com.HomeDeskV5.taskDirectory.HDPath;

public abstract class ToDoItem extends Entity{
	
	public static enum PRIORITY {
			NONE,
			LOW,
			MEDIUM,
			HIGH,
			EMERGENT
	}
	
	private String desc;
	private PRIORITY priority;
	private boolean completed;
	private LocalDateTime schedStart;
	private LocalDateTime schedEnd;
	
	public ToDoItem(String title, HDPath path, String typeSuffix) {
		super(typeSuffix, title, path);
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


	public LocalDateTime getScheduledStart() {
		return schedStart;
	}


	public LocalDateTime getScheduledEnd() {
		return schedEnd;
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


	public void setScheduledStart(LocalDateTime scheduledStart) {
		this.schedStart = scheduledStart;
	}


	public void setScheduledEnd(LocalDateTime scheduledEnd) {
		this.schedEnd = scheduledEnd;
	}
	
	

}
