package com.HomeDeskV5.CLI;

import java.util.concurrent.Callable;

import com.HomeDeskV5.controllers.HDClient;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

/**
 * A create entity command will create whatever entity is requested and pass the constructor
 * 	whatever command line arguments it finds
 */
@Command(name = "create", description = "Create new entity")
public class CreateEntityCMD implements Callable<Void> {
	
	@Parameters(index = "0", arity = "1", paramLabel = "<target>")
	private String targetPathStr;
	
	@Command(name = "hdclient", description = "create new client")
	void hdclient(String[] args) {
		
	}
	
	@Command(name = "folder", description = "Create new folder")
	void folder(String[] args) {
		// TODO Implement CreateEntityCMD -> folder
	}
	
	@Command(name = "list", description = "Create new list")
	void list(String[] args) {
		// TODO Implement CreateEntityCMD -> list
	}
	
	@Command(name = "section", description = "Create new section")
	void section(String[] args) {
		// TODO Implement CreateEntityCMD -> section
	}
	
	@Command(name = "task", description = "Create new section")
	void task(String[] args) {
		// TODO Implement CreateEntityCMD -> section
	}

	@Override
	public Void call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
