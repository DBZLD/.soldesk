package com.spring.tft;

import java.util.ArrayList;

import com.spring.dto.tft.Unit;
import com.spring.dto.tft.Participant;
import com.spring.dto.tft.Trait;
import com.spring.service.TFTApiProcessor;

public class TFTMatchPlayerInfo {
	public String playerId;
	public String playerTag;
	public String playerPuuid;
	public String tacticianId;
	public Integer goldLeft;
	public Integer lastRound;
	public Integer level;
	public Integer placement;
	public Double timeElemented;
	public Integer totalDamage;
	public String tacticianFull;
	public String tacticianGroup;
	public String tacticianImgURL;
	public ArrayList<TFTTraitInfo> traitList = new ArrayList<>();
	public ArrayList<TFTUnitInfo> unitList = new ArrayList<>();

	public TFTMatchPlayerInfo(Participant participant, TFTApiProcessor tap) {
		playerId = participant.riotIdGameName;
		playerTag = participant.riotIdTagline;
		playerPuuid = participant.puuid;
		tacticianId = Integer.toString(participant.companion.item_ID);
		goldLeft = participant.gold_left;
		lastRound = participant.last_round;
		level = participant.level;
		placement = participant.placement;
		timeElemented = participant.time_eliminated;
		totalDamage = participant.total_damage_to_players;

		tacticianFull = tap.tactician.data.get(tacticianId).image.full;
		tacticianGroup = tap.tactician.data.get(tacticianId).image.group;
		tacticianImgURL = tap.getImgURL(tacticianGroup, tacticianFull);

		for (Trait trait : participant.traits) {
			if (!(trait.tier_current == 0)) {
				traitList.add(new TFTTraitInfo(trait, tap));
			}
		}
		for (Unit unit : participant.units) {
			unitList.add(new TFTUnitInfo(unit, tap));
		}
	}
}
