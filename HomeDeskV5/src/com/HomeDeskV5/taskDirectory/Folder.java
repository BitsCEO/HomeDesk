package com.HomeDeskV5.taskDirectory;

import java.util.ArrayList;

import com.HomeDeskV5.Entity;

public class Folder extends Container {
	private static String SUFFIX = "FLDR";
	
	/**
	 * This specialized constructor that creates a taskDirectory's root folder. It can only be accessed by the
	 *  HomeDeskService constructor
	 */
	public Folder() {
		super(SUFFIX, new HDPath());
		this.setTitle("root");
		this.getPath().extend(this);
	}

	public Folder(String title, HDPath path) {
		super(SUFFIX, path);
		this.setTitle(title);
		this.getPath().extend(this);
	}

	@Override
	public boolean isEmpty() {
		// TODO implement Folder.isEmpty()
		return false;
	}

	@Override
	public ArrayList<Entity> getContents() {
		// TODO implement Folder.getContents()
		return null;
	}

	@Override
	public String toString(boolean bannerOnly) {
		
		
		
		return null;
	}

}
