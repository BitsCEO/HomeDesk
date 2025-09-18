package com.HomeDeskV5.CLI;

import com.HomeDeskV5.Folder;
import com.HomeDeskV5.HDPath;

import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Option;
import picocli.CommandLine.Spec;

@Command(name = "",
description = "Top-level shell command",
mixinStandardHelpOptions = true, 
subcommands = {
		CreateEntityCMD.class,
		NavigateCMD.class,
		ShowEntityCMD.class
})
class HDShellEnv implements Runnable {
	
	// ENV fields
	private Folder directory;
	private HDPath cursor;
	
	// Constructor for shell environment
	public HDShellEnv() {
		this.directory = new Folder();
		this.cursor = directory.getPath();
	}
	
	@Spec
	CommandSpec spec;
	
	@Option(names = {"-h", "--help"}, usageHelp = true, description = "Display help")
	boolean helpRequested; 

	@Override
	public void run() {
		
		if (spec.commandLine().getSubcommands().isEmpty() || helpRequested) {
			spec.commandLine().usage(System.out);
		} else {
			System.out.println();
		}
		
	}
	
	public HDPath cursor() {
		return cursor;
	}
	
}
