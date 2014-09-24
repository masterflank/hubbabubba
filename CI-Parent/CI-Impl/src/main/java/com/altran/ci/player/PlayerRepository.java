package com.altran.ci.player;

import java.util.Collection;

public interface PlayerRepository {
	public Collection<Player> getAllPlayers();

	public Collection<Player> getAvailablePlayers();

	public Player findPlayer(String name);
}
