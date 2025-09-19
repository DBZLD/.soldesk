package com.spring.dto.lol;

import lombok.Data;

@Data
public class LOLRankInfo {
	private String queueType;
	private String tier;
	private String rank;
	private Integer leaguePoint;
	private Integer wins;
	private Integer losses;
	
	public LOLRankInfo(RankDto rank) {
		this.queueType = rank.queueType;
		this.tier = rank.tier;
		this.rank = rank.rank;
		this.leaguePoint = rank.leaguePoints;
		this.wins = rank.wins;
		this.losses = rank.losses;
	}
	public LOLRankInfo() {
	}
}
