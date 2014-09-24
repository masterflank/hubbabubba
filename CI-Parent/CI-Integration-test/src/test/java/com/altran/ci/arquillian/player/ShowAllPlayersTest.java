package com.altran.ci.arquillian.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.altran.ci.command.CommandDispatcher;
import com.altran.ci.command.CommandDispatcherImpl;
import com.altran.ci.player.AddPlayerCommand;
import com.altran.ci.player.AddPlayerCommandHandler;
import com.altran.ci.player.PlayerBean;
import com.altran.ci.player.PlayerQuery;
import com.altran.ci.player.PlayerQueryImpl;
import com.altran.ci.player.PlayerRepositoryImpl;

@RunWith(Arquillian.class)
public class ShowAllPlayersTest {
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap
				.create(JavaArchive.class)
				.addClasses(PlayerQueryImpl.class, PlayerRepositoryImpl.class,
						CommandDispatcherImpl.class,
						AddPlayerCommandHandler.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Inject
	PlayerQuery query;

	@Inject
	CommandDispatcher dispatcher;

	@Test
	public void showAllPlayers() {
		List<PlayerBean> allPlayers = query.getAllPlayers();
		assertEquals(2, allPlayers.size());

		AddPlayerCommand cmd = new AddPlayerCommand("Zlatan");
		assertTrue(dispatcher.dispatch(cmd));

		allPlayers = query.getAllPlayers();
		assertEquals(3, allPlayers.size());
	}
}
