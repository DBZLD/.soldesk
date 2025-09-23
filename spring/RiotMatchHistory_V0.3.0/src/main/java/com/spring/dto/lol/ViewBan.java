package com.spring.dto.lol;

import lombok.Data;

@Data
public class ViewBan {
	private Integer turn;
	private Integer champId;
	
	public ViewBan(Ban bans) {
		this.turn = bans.pickTurn;
		this.champId = bans.championId;
	}
}
