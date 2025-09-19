package com.spring.dto.lol;

import java.util.List;

import lombok.Data;

@Data
public class LOLMatchInfo {
	private Integer queueId;
	private Long gameCreation;
	private Integer gameDuration;
	private String gameVersion;
	private Integer playerIndex;
	private List<LOLMatchParticipant> matchParticipants;
	private List<LOLMatchTeam> teams;
	
	
	public LOLMatchInfo(MatchDto match, MatchTimeLineDto timeLine, String puuid) {
		this.queueId = match.info.queueId;
		this.gameCreation = match.info.gameCreation;
		this.gameDuration = match.info.gameDuration;
		this.gameVersion = match.info.gameVersion;
		for(int i = 0; i < match.metadata.participants.size(); i++) {
			if(match.metadata.participants.get(i).equals(puuid)) {
				this.playerIndex = i;
			}
		}
	}
	
	public LOLMatchInfo() {
	}
}
