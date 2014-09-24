package com.altran.ci.fitnesse.fixtures;

import java.util.Calendar;

import com.altran.ci.command.CommandDispatcher;
import com.altran.ci.fitnesse.init.Context;
import com.altran.ci.player.SuspendPlayerCommand;

public class SuspendPlayer {
	private String name;
	private Calendar suspendedUntil;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDays(Integer days) {
		Calendar suspendedUntil = Calendar.getInstance();
		suspendedUntil.add(Calendar.DATE, days);
		this.suspendedUntil = suspendedUntil;
	}
	
	public boolean suspended() {
		SuspendPlayerCommand command = new SuspendPlayerCommand(name, suspendedUntil);
		CommandDispatcher dispatcher = Context.dIContainer().getBeanByClass(CommandDispatcher.class);
		return dispatcher.dispatch(command);

	}
}
