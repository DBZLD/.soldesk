package com.spring.tft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.spring.dto.tft.MatchDto;
import com.spring.dto.tft.Participant;
import com.spring.service.TFTApiProcessor;

public class TFTMatchInfo {
	public String gameVersion;
	public String matchId;
	public String gameDatetime;
	public String gamePasstime;
	public String queueType;
	public Integer myIndex;
	public ArrayList<TFTMatchPlayerInfo> playerInfos = new ArrayList<>();
	
	public TFTMatchInfo(MatchDto matchDto, String myPuuid) {
		Pattern pattern = Pattern.compile("Version (\\d+\\.\\d+)");
		Matcher matcher = pattern.matcher(matchDto.info.game_version);
		if(matcher.find()) {
			gameVersion = matcher.group(1) + ".1";
		}
		TFTApiProcessor tap = new TFTApiProcessor(gameVersion);
		
		matchId = matchDto.metadata.match_id;
		gameDatetime = tap.transGameDatetime(matchDto.info.game_datetime);
		gamePasstime = tap.transGamePasstime(matchDto.info.game_datetime);
		queueType = tap.transQueueType(matchDto.info.queue_id);
		//gameVersion 설정
		//playerInfos 설정
		for (Participant part : matchDto.info.participants) {
			playerInfos.add(new TFTMatchPlayerInfo(part, queueType, tap));
		}
		//playerInfos 정렬(등수 순)
		playerInfos.sort(Comparator.comparingInt(pIfno -> pIfno.placement));
		for(int i = 0; i < playerInfos.size(); i++) {
			if(playerInfos.get(i).playerPuuid.equals(myPuuid)) {
				myIndex = i;
				break;
			}
		}
	}
}
