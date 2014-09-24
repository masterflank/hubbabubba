package com.altran.ci.player;

import javax.inject.Inject;

import com.altran.ci.command.Command;
import com.altran.ci.command.CommandHandler;

public class AddPlayerCommandHandler implements CommandHandler {
	@Inject PlayerRepositoryImpl repo;

	@Override
	public boolean handle(Command command) {
		AddPlayerCommand cmd = (AddPlayerCommand) command;
		
		PlayerImpl player = new PlayerImpl(cmd.getName());
		return repo.addPlayer(player);
	}

	@Override
	public boolean canHandle(Class<? extends Command> commandClass) {
		return AddPlayerCommand.class.equals(commandClass);
	}

}
