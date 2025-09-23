package com.spring.dto.lol;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ViewMatchTeam {
	private Integer teamId;
	private ArrayList<ViewBan> bans = new ArrayList<ViewBan>();
	private ArrayList<ViewFeats> feats = new ArrayList<ViewFeats>();
	private ArrayList<ViewObjectives> objectives = new ArrayList<ViewObjectives>();

	public ViewMatchTeam(Team team) {
		this.teamId = team.teamId;
		for(Ban ban : team.bans) {
			this.bans.add(new ViewBan(ban));
		}
		//todo
	}
	
	public ViewMatchTeam() {
	}
}
