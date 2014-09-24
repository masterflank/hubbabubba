package com.altran.ci.fitnesse.fixtures;

import java.util.List;

import com.altran.ci.fitnesse.init.Context;
import com.altran.ci.fitnesse.util.BeanToQueryResult;
import com.altran.ci.player.PlayerBean;
import com.altran.ci.player.PlayerQuery;

public class ShowAvailablePlayers {
	public List<Object> query() {
		PlayerQuery query = Context.dIContainer().getBeanByClass(PlayerQuery.class);
		List<PlayerBean> availablePlayers = query.getAvailablePlayers();
		return BeanToQueryResult.convert(availablePlayers);
	}
}
