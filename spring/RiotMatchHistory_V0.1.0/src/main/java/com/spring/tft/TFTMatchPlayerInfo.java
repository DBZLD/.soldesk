package com.spring.tft;

import java.util.ArrayList;
import java.util.Comparator;

import com.spring.dto.tft.Unit;
import com.spring.dto.tft.Participant;
import com.spring.dto.tft.Trait;
import com.spring.service.TFTApiProcessor;

public class TFTMatchPlayerInfo {
	public String playerId;
	public String playerTag;
	public String playerPuuid;
	public String tacticianId;
	public String tacticianName;
	public String tacticianFull;
	public String tacticianGroup;
	public String tacticianImgURL;
	public Integer goldLeft;
	public String lastRound;
	public Integer level;
	public Integer placement;
	public String timeElemented;
	public Integer totalDamage;
	public ArrayList<TFTTraitInfo> traitList = new ArrayList<>();
	public ArrayList<TFTUnitInfo> unitList = new ArrayList<>();

	public TFTMatchPlayerInfo(Participant participant, String queueType, TFTApiProcessor tap) {
		playerId = participant.riotIdGameName;
		playerTag = participant.riotIdTagline;
		playerPuuid = participant.puuid;
		goldLeft = participant.gold_left;
		lastRound = tap.transLastRound(participant.last_round);
		level = participant.level;
		if(queueType.equals("���� ��")) {
			placement = (int)Math.floor(((double)participant.placement+1)/2);
		}else {
			placement = participant.placement;			
		}
		timeElemented = tap.transTimeElemented(participant.time_eliminated);
		totalDamage = participant.total_damage_to_players;

		tacticianId = Integer.toString(participant.companion.item_ID);
		tacticianName = tap.tactician.data.get(tacticianId).name;
		tacticianFull = tap.tactician.data.get(tacticianId).image.full;
		tacticianGroup = tap.tactician.data.get(tacticianId).image.group;
		tacticianImgURL = tap.getImgURL(tacticianGroup, tacticianFull);

		//traitList �迭�� �� �ֱ�
		for (Trait trait : participant.traits) {
			if (!(trait.tier_current == 0)) {
				traitList.add(new TFTTraitInfo(trait, tap));
			}
		}
		//unitList �迭�� �� �ֱ�
		for (Unit unit : participant.units) {
			unitList.add(new TFTUnitInfo(unit, tap));
		}
		//traitList �� ����(��Ÿ��3(����Ư��)�� ������ �տ�, ��Ÿ�� ��������, ���� ��Ÿ���� ������ �� ��������)
		traitList.sort((a, b) -> {
		    if (a.style == 3 && b.style != 3) return -1;
		    if (a.style != 3 && b.style == 3) return 1;
		    if (a.style != b.style) {
		        return Integer.compare(b.style, a.style);
		    }
		    
		    return a.name.compareTo(b.name);
		});
		//traitList �� ����(��͵��� ��������, ���� ��͵��� ������ �� ��������)
		unitList.sort((a, b) -> {
			if(a.rarity != b.rarity) {
				return Integer.compare(a.rarity, b.rarity);
			}
			return a.name.compareTo(b.name);
		});
	}
}
