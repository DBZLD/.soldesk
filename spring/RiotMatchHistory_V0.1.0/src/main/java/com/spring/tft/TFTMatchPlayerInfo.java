package com.spring.tft;

import java.util.ArrayList;

import com.spring.dto.tft.Participant;

public class TFTMatchPlayerInfo {
	public Integer tatician_ID;
	public Integer gold_Left;
	public Integer last_round;
	public Integer level;
	public Integer placement;
	public Integer time_elemented;
	public Integer total_damage;
	public ArrayList<TFTTraitInfo> traitList;
	public ArrayList<TFTChampionInfo> championList;
	public String queueType;

	public TFTMatchPlayerInfo(ArrayList<Participant> participant) {

	}
}
