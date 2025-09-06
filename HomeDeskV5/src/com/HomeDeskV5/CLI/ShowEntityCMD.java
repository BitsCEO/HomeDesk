package com.HomeDeskV5.CLI;

import java.util.concurrent.Callable;

import com.HomeDeskV5.Entity;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "show", description = "print an item to console")
public class ShowEntityCMD implements Callable<Void> {
	
	@Parameters(index = "0", paramLabel = "<path to entity>")
	private Entity entityToShow;
	
	@Option(names = {"-v", "--verbose"}, 
			description = "When set to 'false', only a banner is displayed")
	private boolean verbose;

	@Override
	public Void call() throws Exception {
		// TODO implement ShowEntityCMD.call()
		
		return null;
	}

	
}
