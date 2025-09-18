package com.HomeDeskV5.CLI;

import java.io.IOException;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.ParsedLine;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import com.HomeDeskV5.Entity;
import com.HomeDeskV5.HDPath;

import picocli.CommandLine;
import picocli.CommandLine.InitializationException;
import picocli.shell.jline3.PicocliCommands;

/**
 * HDShell launcher with static main method. Creates terminal, an environment for the shell
 * 	and interfaces the two with PicocliCommands
 */
public class HDShell {
	
	// CLI fields
	private CommandLine commandLine;
	private Terminal terminal;
	private PicocliCommands picocliCommands;
	private LineReader reader;
	
	// Shell environment
	private HDShellEnv env;
	
	public HDShell() {
		
		if (initializeShell()) {
			startInputLoop();
		} else {
			System.out.println("HDShell initialization failed!");
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		HDShell shell = new HDShell();
		
		
	}
	
	private boolean initializeShell() {
		try {
			
			// Initialize terminal
			terminal = TerminalBuilder.builder().build();
			
			// Initialize Command Line Interface, which are the commands that connect typing input
			//  to programatic behavior. Link this to the top-level command
			env = new HDShellEnv();
			commandLine = new CommandLine(env);
			
			// Prepare the command line, loaded with the cli, to be plugged into JLine terminal
			picocliCommands = new PicocliCommands(commandLine);
			
			// Create a line reader to interface the terminal (input/output) with the commands
			reader = LineReaderBuilder.builder()
					.terminal(terminal)
					.completer(picocliCommands.compileCompleters())
					.build();
			
		} catch (InitializationException ie) {
			commandLine.getErr().println(ie.getMessage());
			
			return false;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			
			return false;
		}
		
		return true;
	}
	
	private void startInputLoop() {
		
		while(true) {
			String input = null;
			
			try {
				input = reader.readLine(prompt());
				ParsedLine parsedLine = reader.getParser().parse(input, 0);
				String[] args = parsedLine.words().toArray(new String[0]);
				
				if (args.length == 0) {
					continue;
				}
				
				commandLine.execute(args);
				
			} catch (UserInterruptException uie) {
				// TODO Handle UserInterruptException in interactive loop
			} catch (EndOfFileException eofe) {
				return;
			} catch (Exception e) {
				commandLine.getErr().println(e.getMessage());
			}
			
		}
		
	}
	
	private String prompt() {
		return String.format("{HD}%s>", env.cursor().toString());
	}
	
	private class entConverter implements CommandLine.ITypeConverter<Entity> {

		@Override
		public Entity convert(String value) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	private class pathConverter implements CommandLine.ITypeConverter<HDPath> {

		@Override
		public HDPath convert(String value) throws Exception {
			
			// TODO pathConverter implementation
			
			return null;
		}
		
	}
	
}
