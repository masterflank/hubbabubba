package com.altran.ci.player;

import java.util.Date;


public interface Player {

	String name();
	
	public boolean suspend(Date until);
}
