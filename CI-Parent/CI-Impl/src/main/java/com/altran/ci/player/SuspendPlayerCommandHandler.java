package com.altran.ci.player;

import javax.inject.Inject;

import com.altran.ci.command.Command;
import com.altran.ci.command.CommandHandler;

public class SuspendPlayerCommandHandler implements CommandHandler {

	@Inject private PlayerRepository repo;
	@Override
	public boolean handle(Command command) {
		SuspendPlayerCommand cmd = (SuspendPlayerCommand) command;
		
		Player player = repo.findPlayer(cmd.getName());
		if (player != null) {
			return player.suspend(cmd.getSuspendedUntil().getTime());
		}
		return false;
	}

	@Override
	public boolean canHandle(Class<? extends Command> command) {
		return SuspendPlayerCommand.class.equals(command);
	}

}
