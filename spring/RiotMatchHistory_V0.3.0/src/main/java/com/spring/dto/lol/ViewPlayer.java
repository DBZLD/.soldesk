package com.spring.dto.lol;

import com.spring.util.ProfileDto;
import com.spring.util.PuuidDto;

import lombok.Data;

@Data
public class ViewPlayer {
	private String id;
	private String tag;
	private String puuid;
	private String profileIcon;
	private String level;
	private ViewRank soloRank;
	private ViewRank flexRank;
	
	public ViewPlayer(PuuidDto puuid, ProfileDto profile, RankDto solo, RankDto flex) {
		this.puuid = puuid.puuid;
		this.id = puuid.gameName;
		this.tag = puuid.tagLine;
		this.profileIcon = profile.profileIconId;
		this.level = profile.summonerLevel;
		this.soloRank = new ViewRank(solo);
		this.flexRank = new ViewRank(flex);
	}
	public ViewPlayer() {
	}
}
