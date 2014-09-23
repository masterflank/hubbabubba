package com.altran.ci.fitnesse.fixtures;

import java.util.Collection;
import java.util.List;

import org.json.JSONObject;

import com.altran.ci.fitnesse.init.Context;
import com.altran.ci.fitnesse.util.JSONToQueryResult;
import com.altran.ci.player.PlayerQuery;

public class ShowAllPlayers {
	public List<Object> query() {
		PlayerQuery playerQuery = Context.dIContainer().getBeanByClass(PlayerQuery.class);
		Collection<JSONObject> allPlayers = playerQuery.getAllPlayers();
		return JSONToQueryResult.convert(allPlayers);
	}
}
