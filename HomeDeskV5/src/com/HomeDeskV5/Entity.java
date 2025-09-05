package com.HomeDeskV5;

import com.HomeDeskV5.taskDirectory.HDPath;

/**
 * All HomeDesk objects will be entities with unique identifiers to build a system of links 
 * 	and navigation to make moving through the application absolutely fluidly. 
 */
public abstract class Entity {
	private static int nextEntityId;
	
	private final String id;
	private String title;
	private HDPath path;
	
	public Entity(String typeSuffix, HDPath path) {
		this.id = String.format("%d-%s", nextEntityId++, typeSuffix);
		this.path = path;
	}
	
	public abstract String toString(boolean bannerOnly);
	
	public void print(boolean bannerOnly) {
		System.out.println(this.toString(bannerOnly));
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public HDPath getPath() {
		return path;
	}

	public void setPath(HDPath path) {
		this.path = path;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
