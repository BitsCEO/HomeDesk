package com.HomeDeskV5.taskDirectory;

import java.util.ArrayList;

import com.HomeDeskV5.Entity;

public class Section {
	private String title;
	private ArrayList<Entity> contents;
	
	public Section(String title) {
		this.title = title;
		this.contents = new ArrayList<>();
	}
	
	public boolean addEntity(Entity entToAdd) {
		if (contents.contains(entToAdd)) {
			return false;
		} else {
			contents.add(entToAdd);
			return true;
		}
	}
	
	public boolean removeEntity(Entity entToRmv) {
		if (contents.contains(entToRmv)) {
			contents.remove(entToRmv);
			return true;
		}
		return false;
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<Entity> getContents() {
		return contents;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
