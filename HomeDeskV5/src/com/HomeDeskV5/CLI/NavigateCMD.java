package com.HomeDeskV5.CLI;

import com.HomeDeskV5.Entity;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "nav", description = "Navigate the directory")
public class NavigateCMD implements Runnable {
	
	/**
	 * if this parameter is null, attempt to navigate up one level
	 */
	@Parameters(index = "0")
	private Entity navTarget;
	
	@Option(names = {"-d", "--deep"}, description = "When attempting to navigate, "
			+ "search sub-directories")
	private boolean deepSearch;

	@Override
	public void run() {
		
		// if no target passed, 
		if (navTarget == null) {
			// TODO Implement NavigateCMD.run()
		}
		
	}

}
