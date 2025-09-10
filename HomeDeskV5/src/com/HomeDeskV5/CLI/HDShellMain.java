package com.HomeDeskV5.CLI;

import java.io.IOException;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.ParsedLine;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import com.HomeDeskV5.taskDirectory.Folder;
import com.HomeDeskV5.taskDirectory.HDPath;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.shell.jline3.PicocliCommands;

@Command(name = "", description = "Shell for use by HomeDesk Developers", mixinStandardHelpOptions=true,
subcommands = {
		CreateEntityCMD.class,
		NavigateCMD.class,
		ShowEntityCMD.class
})
class HDShell implements Runnable {

	@Override
	public void run() {
		
		System.out.println("type help for available commands");
		
	}
	
}

public class HDShellMain {
	
	public static void main(String[] args) throws IOException {
		Folder rootDir = new Folder();
		HDPath cursor = rootDir.getPath();
		
		// Initialize Command Line Interface, which are the commands that connect typing input
		//  to programatic behavior. Link this to the top-level command
		CommandLine commandLine = new CommandLine(new HDShell());
		
		// Initialize terminal
		try (Terminal terminal = TerminalBuilder.builder().build()) {
			
			// Setup picocli commands for use with jline
			PicocliCommands picocliCommands = new PicocliCommands(commandLine);
			
			// Create linereader for loop
			LineReader reader = LineReaderBuilder.builder()
					.terminal(terminal)
					.completer(picocliCommands.compileCompleters())
					.build();
			
			// Interactive shell loop
			while(true) {
				String input = null;
				String prompt = String.format("HD$/%s", cursor);
				
				try {
					input = reader.readLine(prompt);
					ParsedLine parsedLine = reader.getParser().parse(input, 0);
					String[] arguments = parsedLine.words().toArray(new String[0]);
					
					if (arguments.length == 0) {
						continue;
					}
					
					// Execute command
					commandLine.execute(arguments);
					
				} catch (UserInterruptException e) {
					
					// TODO handle user interrupt exception
					
				} catch (EndOfFileException e) {
					return;
				} catch (Exception e) {
					commandLine.getErr().println(e.getMessage());
				}
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
