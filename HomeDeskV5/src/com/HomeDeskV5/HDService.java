package com.HomeDeskV5;

import com.HomeDeskV5.taskDirectory.Folder;

/**
 * Controller for HomeDesk client
 */
public class HDService {
	private User owner;
	private Folder directory;
	
	public HDService(User user) {
		this.owner = user;
		
		this.directory = new Folder();
	}

	public User getOwner() {
		return owner;
	}

	public Folder getDirectory() {
		return directory;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

}
