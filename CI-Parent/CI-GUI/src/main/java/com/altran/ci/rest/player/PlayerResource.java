package com.altran.ci.rest.player;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.altran.ci.player.PlayerBean;
import com.altran.ci.player.PlayerQuery;

@Path("player")
public class PlayerResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerResource.class);
    
    @Inject private PlayerQuery query;
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PlayerBean> players() {
    	List<PlayerBean> players = query.getAllPlayers();
    	LOGGER.debug("Number of players: " + players.size());
    	return players;
    }
}
