package com.altran.ci.player;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import org.apache.commons.collections.CollectionUtils;

@ApplicationScoped
public class PlayerRepositoryImpl implements PlayerRepository {
	private Set<Player> players = new HashSet<Player>();
	
	@PostConstruct
	public void init() {
		players.add(new PlayerImpl("Messi"));
		players.add(new PlayerImpl("Ronaldo"));
	}

	@Override
	public boolean addPlayer(Player player) {
		if (player != null) {
			return players.add(player);
		}
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return CollectionUtils.unmodifiableCollection(players);
	}

}
