package com.spring.dto.lol;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ViewMatch {
	private Integer queueId;
	private Long gameCreation;
	private Integer gameDuration;
	private String gameVersion;
	private Integer playerIndex;
	private List<ViewMatchParticipant> matchParticipants = new ArrayList<ViewMatchParticipant>();
	private ArrayList<ViewMatchTeam> teams = new ArrayList<ViewMatchTeam>();
	private ViewTimeLine timeLine;
	private Integer playerTeamId;
	
	public ViewMatch(MatchDto match, MatchTimeLineDto timeLine, String puuid) {
		this.queueId = match.info.queueId;
		this.gameCreation = match.info.gameCreation;
		this.gameDuration = match.info.gameDuration;
		this.gameVersion = match.info.gameVersion;
		for(int i = 0; i < match.metadata.participants.size(); i++) {
			if(match.metadata.participants.get(i).equals(puuid)) {
				this.playerIndex = i;
			}
		}
		this.playerTeamId = match.info.participants.get(playerIndex).teamId;
		for(Participant part : match.info.participants) {
			matchParticipants.add(new ViewMatchParticipant(part));
		}
		for(Team team : match.info.teams) {
			teams.add(new ViewMatchTeam(team));
		}
	}
	
	public ViewMatch() {
	}
}
