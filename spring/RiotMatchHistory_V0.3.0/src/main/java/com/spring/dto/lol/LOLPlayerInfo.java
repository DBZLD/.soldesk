package com.spring.dto.lol;

import com.spring.util.ProfileDto;
import com.spring.util.PuuidDto;

import lombok.Data;

@Data
public class LOLPlayerInfo {
	private String id;
	private String tag;
	private String puuid;
	private String profileIcon;
	private String level;
	private LOLRankInfo soloRank;
	private LOLRankInfo flexRank;
	
	public LOLPlayerInfo(PuuidDto puuid, ProfileDto profile, RankDto solo, RankDto flex) {
		this.puuid = puuid.puuid;
		this.id = puuid.gameName;
		this.tag = puuid.tagLine;
		this.profileIcon = profile.profileIconId;
		this.level = profile.summonerLevel;
		this.soloRank = new LOLRankInfo(solo);
		this.flexRank = new LOLRankInfo(flex);
	}
	public LOLPlayerInfo() {
	}
}
