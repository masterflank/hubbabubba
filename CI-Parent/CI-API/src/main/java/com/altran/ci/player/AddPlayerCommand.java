package com.altran.ci.player;

import com.altran.ci.command.Command;

public class AddPlayerCommand implements Command {
	private String name;

	public AddPlayerCommand(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
