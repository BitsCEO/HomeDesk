package com.HomeDeskV5.CLI;

import java.util.concurrent.Callable;

import com.HomeDeskV5.Folder;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

/**
 * A create entity command will create whatever entity is requested and pass the constructor
 * 	whatever command line arguments it finds
 */
@Command(name = "create", description = "Create new entity")
public class CreateEntityCMD implements Callable<Void> {
	
	@Parameters(index = "0", defaultValue = "null", paramLabel = "<title>")
	private String title;
	
	@ParentCommand
	HDShellEnv parentCommand;
	
	@Command(name = "folder")
	public Folder folder() {
		Folder newFolder; 
		
		if (title == "null") {
			newFolder = new Folder();
		} else {
			newFolder = new Folder(title, parentCommand.cursor());
		}
		
		return newFolder; 
	}

	@Override
	public Void call() throws Exception {
		System.out.println("Invalid command: command requires entity type. No action taken");
		return null;
	}

}
