package com.altran.ci.player;

import java.util.Collection;

public interface PlayerRepository {
	public boolean addPlayer(Player player);
	
	public Collection<Player> getAllPlayers();
}
