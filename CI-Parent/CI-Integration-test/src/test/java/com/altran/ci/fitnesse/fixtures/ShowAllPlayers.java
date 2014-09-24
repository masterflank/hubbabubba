package com.altran.ci.fitnesse.fixtures;

import java.util.List;

import com.altran.ci.fitnesse.init.Context;
import com.altran.ci.fitnesse.util.BeanToQueryResult;
import com.altran.ci.player.PlayerBean;
import com.altran.ci.player.PlayerQuery;
import com.altran.ci.player.PlayerQueryImpl;

public class ShowAllPlayers {
	public List<Object> query() {
		PlayerQuery playerQuery = Context.dIContainer().getBeanByClass(PlayerQueryImpl.class);
		List<PlayerBean> allPlayers = playerQuery.getAllPlayers();
		return BeanToQueryResult.convert(allPlayers);
	}
}
