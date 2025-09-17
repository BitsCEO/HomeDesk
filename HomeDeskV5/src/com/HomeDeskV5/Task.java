package com.HomeDeskV5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Task extends ToDoItem {
	public static final String SUFFIX = "task";
	
	private LocalDate dateDue;
	private LocalTime timeDue;
	
	private List<Task> subTasks;

	public Task(String title, HDPath parent) {
		super(title, parent);
		
		this.dateDue = null;
		this.timeDue = null;
		
		this.subTasks = new ArrayList<>();
	}
	
	public void addSubtask(Task subtask) {
		// TODO implement Task.addSubtask()
	}
	
	public boolean convertToProject() {
		// TODO implement Task.convertToProject()
		return false;
	}
	
	public boolean convertToAppt(LocalDateTime start, LocalDateTime end, Location location) {
		// TODO implement Task.convertToAppt()
		return false;
	}

}
