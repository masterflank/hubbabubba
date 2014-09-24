package com.altran.ci.arquillian.player;

import static org.junit.Assert.*;

import java.util.Collection;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.altran.ci.player.PlayerQuery;
import com.altran.ci.player.PlayerRepositoryImpl;

@RunWith(Arquillian.class)
public class ShowAllPlayersTest {
	@Deployment
	public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(PlayerQuery.class, PlayerRepositoryImpl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@Inject
	PlayerQuery query;
	
	@Test
	public void showAllPlayers() {
		Collection<JSONObject> allPlayers = query.getAllPlayers();
		assertEquals(2, allPlayers.size());
	}
}
