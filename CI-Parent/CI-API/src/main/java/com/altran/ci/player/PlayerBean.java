package com.altran.ci.player;

import com.altran.ci.query.QueryResultRow;

public class PlayerBean extends QueryResultRow {
	private String name;
	
	public PlayerBean(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
