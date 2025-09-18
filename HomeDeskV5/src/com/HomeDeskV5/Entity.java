package com.HomeDeskV5;

import java.util.Comparator;

public abstract class Entity implements Comparable<Entity>{
	private static int nextEntityId;
	
	private final int id;
	private String title;
	private HDPath path;
	
	public Entity(String title, HDPath parent) {
		this.id = nextEntityId++;
		this.title = title;
		this.path = new HDPath(parent, this);
	}
	
	public void makePathHere(Container whereToMakePath) {
		this.setPath(new HDPath(whereToMakePath.getPath(), this));
	}
	
	public abstract String getSuffix();
	
	public int compareTo(Entity thatEnt) {
		
		// Extract title
		String thisTitle = getTitle();
		String thatTitle = thatEnt.getTitle();
		
		// Compare titles
		return thisTitle.compareTo(thatTitle);
	}
	
	public Comparator<Entity> comparator() {
		return new EntityComparator();
	}
	
	protected class EntityComparator implements Comparator<Entity> {

		@Override
		public int compare(Entity thisEnt, Entity thatEnt) {
			return thisEnt.compareTo(thatEnt);
		}
		
	}

	public static int getNextEntityId() {
		return nextEntityId;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public HDPath getPath() {
		return path;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPath(HDPath path) {
		this.path = path;
	}

}
