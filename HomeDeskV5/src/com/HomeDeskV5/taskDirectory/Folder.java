package com.HomeDeskV5.taskDirectory;

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
	public String toString(boolean bannerOnly) {
		// ToDo implement Folder.toString()
		
		
		return null;
	}

}
