package com.altran.ci.player;

import java.util.Calendar;

import com.altran.ci.command.Command;

public class SuspendPlayerCommand implements Command {

	private String name;
	private Calendar suspendedUntil;

	public SuspendPlayerCommand(String name, Calendar suspendedUntil) {
		this.name = name;
		this.suspendedUntil = suspendedUntil;
	}
	
	public String getName() {
		return name;
	}
	
	public Calendar getSuspendedUntil() {
		return suspendedUntil;
	}
}
