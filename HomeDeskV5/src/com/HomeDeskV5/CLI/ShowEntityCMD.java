package com.HomeDeskV5.CLI;

import java.util.concurrent.Callable;

import com.HomeDeskV5.Entity;

import picocli.CommandLine.Parameters;

public class ShowEntityCMD implements Callable<Integer> {
	
	@Parameters(index = "0", paramLabel = "<entity to show>")
	private Entity entityToShow;

	@Override
	public Integer call() throws Exception {
		// TODO implement ShowEntityCMD.call()
		
		return null;
	}

	
}
