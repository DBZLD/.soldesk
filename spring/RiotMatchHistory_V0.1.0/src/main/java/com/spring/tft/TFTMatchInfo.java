package com.spring.tft;

import java.util.ArrayList;

import com.spring.dto.tft.MatchDto;

public class TFTMatchInfo {
	public String match_id;
	public Long game_datetime;
	public Double game_length;
	public ArrayList<String> puuidList;
	public ArrayList<TFTMatchPlayerInfo> playerInfos;
	
	public TFTMatchInfo(MatchDto matchDto) {
		match_id = matchDto.metadata.match_id;
		puuidList = matchDto.metadata.participants;
		game_datetime = matchDto.info.game_datetime;
		game_length = matchDto.info.game_length;
		playerInfos = new ArrayList<TFTMatchPlayerInfo>(matchDto.info.participants);
	}
}
