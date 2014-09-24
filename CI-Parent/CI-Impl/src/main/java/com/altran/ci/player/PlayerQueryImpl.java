package com.altran.ci.player;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PlayerQueryImpl implements PlayerQuery {
	
	public PlayerQueryImpl() {
	}
	
	@Inject private PlayerRepository repo;
	
	/* (non-Javadoc)
	 * @see com.altran.ci.player.PlayerQuery#getAllPlayers()
	 */
	@Override
	public List<PlayerBean> getAllPlayers() {
		List<PlayerBean> result = new ArrayList<PlayerBean>();
		for (Player player : repo.getAllPlayers()) {
			result.add(new PlayerBean(player.name()));
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.altran.ci.player.PlayerQuery#getAvailablePlayers()
	 */
	@Override
	public List<PlayerBean> getAvailablePlayers() {
		List<PlayerBean> result = new ArrayList<PlayerBean>();
		for (Player player : repo.getAvailablePlayers()) {
			result.add(new PlayerBean(player.name()));
		}
		return result;
	}
	
}
