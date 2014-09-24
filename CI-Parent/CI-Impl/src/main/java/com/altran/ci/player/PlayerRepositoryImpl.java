package com.altran.ci.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlayerRepositoryImpl implements PlayerRepository {
	private Set<PlayerImpl> players = new HashSet<PlayerImpl>();
	
	public PlayerRepositoryImpl() {
	}
	
	@PostConstruct
	public void init() {
		players.add(new PlayerImpl("Messi"));
		players.add(new PlayerImpl("Ronaldo"));
	}

	boolean addPlayer(PlayerImpl player) {
		if (player != null) {
			return players.add(player);
		}
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		Collection<Player> allPlayers = new ArrayList<Player>();
		for (PlayerImpl player : this.players) {
			allPlayers.add(player);
		}
		return allPlayers;
	}

	@Override
	public Collection<Player> getAvailablePlayers() {
		Collection<Player> availablePlayers = new ArrayList<Player>();
		for (PlayerImpl player : this.players) {
			if (player.isAvailable()) {
				availablePlayers.add(player);
			}
		}
		return availablePlayers;
	}

	@Override
	public Player findPlayer(String name) {
		for (PlayerImpl player : this.players) {
			if (player.name().equals(name)) {
				return player;
			}
		}
		return null;
	}

}
