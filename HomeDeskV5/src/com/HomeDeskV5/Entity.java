package com.HomeDeskV5;

public abstract class Entity {
	private static int nextEntityId;
	
	private final int id;
	private String title;
	private HDPath path;
	
	public Entity(String title, HDPath parent) {
		this.id = nextEntityId++;
		this.title = title;
		this.path = new HDPath(parent, this);
	}
	
	public abstract void delete();
	
	public abstract String getSuffix();

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
