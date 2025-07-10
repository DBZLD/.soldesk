package com.spring.tft;

import java.util.ArrayList;

import com.spring.dto.tft.MatchDto;
import com.spring.dto.tft.Participant;
import com.spring.service.TFTApiProcessor;

public class TFTMatchInfo {
	public String matchId;
	public String gameDatetime;
	public String gameLength;
	public String queueType;
	public Integer playerIndex;
	public ArrayList<TFTMatchPlayerInfo> playerInfos = new ArrayList<>();

	public TFTMatchInfo(MatchDto matchDto, TFTApiProcessor tap) {
		matchId = matchDto.metadata.match_id;
		gameDatetime = tap.transGameDatetime(matchDto.info.game_datetime);
		gameLength = tap.transGameLength(matchDto.info.game_length);
		queueType = tap.transQueueType(matchDto.info.queue_id);
		for (Participant part : matchDto.info.participants) {
			playerInfos.add(new TFTMatchPlayerInfo(part, tap));
		}
	}
}
