package com.altran.ci.player;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class PlayerImplTest {

	@Test
	public void testSuspend() {
		Player player = new PlayerImpl("Zlatan");
		long now = new Date().getTime();
		long tomorrow = now + 86400 * 1000;
		long yesterday = now - 86400 * 1000;
		assertFalse(player.suspend(new Date(yesterday)));
		assertTrue(player.suspend(new Date(tomorrow)));
	}

	@Test
	public void testName() {
		Player player = new PlayerImpl("Zlatan");
		assertEquals("Zlatan", player.name());
	}

	@Test
	public void testIsAvailable() {
		long now = new Date().getTime();
		long tomorrow = now + 86400 * 1000;
		long yesterday = now - 86400 * 1000;
		PlayerImpl player = new PlayerImpl("Zlatan");
		assertTrue(player.isAvailable());
		player.suspend(new Date(yesterday));
		assertTrue(player.isAvailable());
		assertTrue(player.suspend(new Date(tomorrow)));
		assertFalse(player.isAvailable());
	}

}
