package com.altran.ci.command;

public interface CommandHandler {
	public boolean canHandle(Class<? extends Command> command);
	
	public boolean handle(Command command);
}