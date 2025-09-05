package com.HomeDeskV5.CLI;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;
import com.HomeDeskV5.taskDirectory.HDPath;

/**
 * A create entity command will create whatever entity is requested and pass the constructor
 * 	whatever command line arguments it finds
 */
@Command(name = "create", description = "Create new entity")
public class CreateEntityCMD implements Callable<Integer> {
	
	@Parameters(index = "0", arity = "1")
	HDPath target;
	
	@Command(name = "folder", description = "Create new folder")
	void folder(String[] args) {
		// TODO Implement CreateEntityCMD -> folder
	}
	
	@Command(name = "list", description = "Create new list")
	void list(String[] args) {
		// TODO Implement CreateEntityCMD -> list
	}
	
	@Command(name = "page", description = "Create new page")
	void page(String[] args) {
		// TODO Implement CreateEntityCMD -> page
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
	public Integer call() throws Exception {
		// TODO implement CreateEntityCMD.call()
		return null;
	}

}
