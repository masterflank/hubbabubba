package com.altran.ci.player;

import java.util.Date;

import com.altran.ci.player.Player;


public class PlayerImpl implements Player {
	private String name;
	private Date suspendedUntil;

	public PlayerImpl(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public boolean suspend(Date until) {
		if (new Date().before(until)) {
			this.suspendedUntil = until;
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerImpl other = (PlayerImpl) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String name() {
		return name;
	}

	boolean isAvailable() {
		return this.suspendedUntil == null || new Date().after(suspendedUntil);
	}
}
