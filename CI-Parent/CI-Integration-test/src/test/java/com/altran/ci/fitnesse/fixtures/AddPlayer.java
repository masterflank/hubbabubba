package com.altran.ci.fitnesse.fixtures;

import com.altran.ci.command.CommandDispatcher;
import com.altran.ci.fitnesse.init.Context;
import com.altran.ci.player.AddPlayerCommand;

public class AddPlayer {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Dummy method to be used when adding descriptive cells for clarification
	 */
	public void set(String dummy) {
	}
	
	public boolean added() {
		AddPlayerCommand command = new AddPlayerCommand(name);
		CommandDispatcher dispatcher = Context.dIContainer().getBeanByClass(CommandDispatcher.class);
		return dispatcher.dispatch(command);
	}
}
