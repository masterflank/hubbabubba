package com.altran.ci.fitnesse.fixtures;

import com.altran.ci.fitnesse.init.Context;
import com.altran.ci.player.Player;
import com.altran.ci.player.PlayerImpl;
import com.altran.ci.player.PlayerRepository;

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
		Player player = new PlayerImpl(name);
		PlayerRepository repo = Context.dIContainer().getBeanByClass(PlayerRepository.class);
		return repo.addPlayer(player);
	}
}
