package com.HomeDeskV5.controllers;

import com.HomeDeskV5.User;
import com.HomeDeskV5.taskDirectory.Folder;

/**
 * Controller for HomeDesk client
 */
public class HDClient {
	private User owner;
	private Folder directory;
	
	public HDClient(User user) {
		this.owner = user;
		
		this.directory = new Folder();
		this.initialize(); 
	}
	
	/**
	 * On application start, access server and load relevant data
	 */
	public void initialize() {
		// TODO implement HDService.initialize()
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
