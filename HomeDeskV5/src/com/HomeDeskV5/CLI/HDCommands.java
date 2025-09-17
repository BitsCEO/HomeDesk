package com.HomeDeskV5.CLI;

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
class HDCommands implements Runnable {
	
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
	
}
