package com.HomeDeskV5.CLI;

import com.HomeDeskV5.Entity;
import com.HomeDeskV5.HDPath;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "go", description = "Navigate the directory")
public class NavigateCMD implements Runnable {
	
	@Parameters(index = "0", paramLabel = "<target>")
	private HDPath target;

	@Override
	public void run() {
		
		// if no target passed, 
		if (navTarget == null) {
			// TODO Implement NavigateCMD.run()
		}
		
	}

}
