package com.HomeDeskV5;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.HomeDeskV5.taskDirectory.HDPath;

public class Task extends ToDoItem {
	private static final String SUFFIX = "TASK";
	
	private ArrayList<ToDoItem> preReqs;
	private ArrayList<Task> subTasks;
	private LocalDate dateDue;
	private LocalTime timeDue;
	
	public Task(String title, HDPath path) {
		super(title, path, SUFFIX);
		
		this.preReqs = new ArrayList<>();
		this.subTasks = new ArrayList<>();
		this.dateDue = null;
		this.timeDue = null;
	}

	public static String getSuffix() {
		return SUFFIX;
	}

	public ArrayList<ToDoItem> getPreReqs() {
		return preReqs;
	}

	public ArrayList<Task> getSubTasks() {
		return subTasks;
	}

	public LocalDate getDateDue() {
		return dateDue;
	}

	public LocalTime getTimeDue() {
		return timeDue;
	}

	public void setPreReqs(ArrayList<ToDoItem> preReqs) {
		this.preReqs = preReqs;
	}

	public void setSubTasks(ArrayList<Task> subTasks) {
		this.subTasks = subTasks;
	}

	public void setDateDue(LocalDate dateDue) {
		this.dateDue = dateDue;
	}

	public void setTimeDue(LocalTime timeDue) {
		this.timeDue = timeDue;
	}

	@Override
	public String toString(boolean bannerOnly) {
		// TODO implement Task.toString()
		return null;
	}

}
