package com.altran.ci.player;

import java.util.List;

public interface PlayerQuery {

	public abstract List<PlayerBean> getAllPlayers();

	public abstract List<PlayerBean> getAvailablePlayers();

}