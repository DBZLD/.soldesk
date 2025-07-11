package com.spring.tft;

import java.util.ArrayList;
import java.util.Comparator;

import com.spring.dto.tft.MatchDto;
import com.spring.dto.tft.Participant;
import com.spring.service.TFTApiProcessor;

public class TFTMatchInfo {
	public String matchId;
	public String gameDatetime;
	public String queueType;
	public Integer myIndex;
	public ArrayList<TFTMatchPlayerInfo> playerInfos = new ArrayList<>();

	public TFTMatchInfo(MatchDto matchDto, String myPuuid, TFTApiProcessor tap) {
		matchId = matchDto.metadata.match_id;
		gameDatetime = tap.transGameDatetime(matchDto.info.game_datetime);
		queueType = tap.transQueueType(matchDto.info.queue_id);
		for (Participant part : matchDto.info.participants) {
			playerInfos.add(new TFTMatchPlayerInfo(part, queueType, tap));
		}
		playerInfos.sort(Comparator.comparingInt(pIfno -> pIfno.placement));
		for(int i = 0; i < playerInfos.size(); i++) {
			if(playerInfos.get(i).playerPuuid.equals(myPuuid)) {
				myIndex = i;
				break;
			}
		}
	}
}
