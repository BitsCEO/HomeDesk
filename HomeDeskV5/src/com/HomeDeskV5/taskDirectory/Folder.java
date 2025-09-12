package com.HomeDeskV5.taskDirectory;

public class Folder extends Container {
	private static String SUFFIX = "FLDR";
	
	/**
	 * This specialized constructor that creates a taskDirectory's root folder. It can only be accessed by the
	 *  HomeDeskService constructor
	 */
	public Folder() {
		super(SUFFIX, "rootFolder", new HDPath());
	}
	
	/**
	 * Create a named root folder
	 * 
	 * @param title
	 */
	public Folder(String title) {
		super(SUFFIX, title, new HDPath());
	}

	/**
	 * Create a folder at a specific path
	 * 
	 * @param title
	 * @param path
	 */
	public Folder(String title, HDPath path) {
		super(SUFFIX, title, path);
	}

	@Override
	public String toString(boolean bannerOnly) {
		// ToDo implement Folder.toString()
		
		
		return null;
	}

}
