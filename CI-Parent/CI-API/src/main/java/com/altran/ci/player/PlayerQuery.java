package com.altran.ci.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.json.JSONObject;

public class PlayerQuery {
	@Inject private PlayerRepository repo;
	
	public Collection<JSONObject> getAllPlayers() {
		List<JSONObject> result = new ArrayList<JSONObject>();
		for (Player player : repo.getAllPlayers()) {
			result.add(new JSONObject().put("Name", player.name()));
		}
		return result;
	}
}
