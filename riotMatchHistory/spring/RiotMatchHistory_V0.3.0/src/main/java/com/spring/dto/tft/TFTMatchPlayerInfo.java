package com.spring.dto.tft;

import java.util.ArrayList;

import com.spring.service.TFTApiProcessor;

public class TFTMatchPlayerInfo {
	public String playerId;			//플레이어 아이디
	public String playerTag;		//플레이어 태그
	public String playerPuuid;		//플레이어 puuid
	public String tacticianId;		//전설이(플레이어 캐릭터)아이디
	public String tacticianName;	//전설이 이름
	public String tacticianFull;	//전설이 이미지
	public String tacticianGroup;	//전설이 이미지 종류
	public String tacticianImgURL;	//전설이 이미지 링크
	public Integer goldLeft;		//남은 골드
	public String lastRound;		//생존 라운드
	public Integer level;			//레벨
	public Integer placement;		//등수
	public String timeElemented;	//생존 시간
	public Integer totalDamage;		//입힌 데미지
	public ArrayList<TFTTraitInfo> traitList = new ArrayList<>();	//특성 배열
	public ArrayList<TFTUnitInfo> unitList = new ArrayList<>();		//유닛 배열

	//partitipant, queueType, tap을 받아서 번역, 정리 후 저장하는 생성자 함수
	public TFTMatchPlayerInfo(Participant participant, String queueType, TFTApiProcessor tap) {
		//playerId에 participant.riotIdGameName 할당
		playerId = participant.riotIdGameName;
		//playerTag에 participant.riotIdTagline 할당
		playerTag = participant.riotIdTagline;
		//playerPuuid에 participant.puuid 할당
		playerPuuid = participant.puuid;
		//goldLeft에 participant.gold_left 할당
		goldLeft = participant.gold_left;
		//lastRound에 tap에서 변환한 lastRound 할당
		lastRound = tap.transLastRound(participant.last_round);
		//level에 participant.level 할당
		level = participant.level;
		//queueType이 더블 업 일때는 등수 조정(1,1,2,2,3,3,4,4)등으로
		if(queueType.equals("더블 업")) {
			placement = (int)Math.floor(((double)participant.placement+1)/2);
		}else {
			//아니면 placement에 participant.placement 할당
			placement = participant.placement;			
		}
		//timeElemented에 tap에서 변환한 timeEliminated 할당
		timeElemented = tap.transTimeElemented(participant.time_eliminated);
		//totalDamage에 participant.total_damage_to_players 할당
		totalDamage = participant.total_damage_to_players;
		
		//tacticianId에 int형으로 변환한 item_ID 할당
		tacticianId = Integer.toString(participant.companion.item_ID);
		//tacticianName에 tap에서 tacticianId와 일치하는 value.name 할당
		tacticianName = tap.tactician.data.get(tacticianId).name;
		//tacticianFull에 tap에서 tacticianId와 일치하는 value.image.full 할당
		tacticianFull = tap.tactician.data.get(tacticianId).image.full;
		//tacticianGroup에 tap에서 tacticianId와 일치하는 value.image.group 할당
		tacticianGroup = tap.tactician.data.get(tacticianId).image.group;
		//tacticianName에 tap에서 변환한 이미지URL 할당
		tacticianImgURL = tap.getImgURL(tacticianGroup, tacticianFull);

		//traitList 배열에 값 넣기
		for (Trait trait : participant.traits) {
			//tier_current값이 0이 아닌 trait만 처리함
			if (!(trait.tier_current == 0)) {
				traitList.add(new TFTTraitInfo(trait, tap));
			}
		}
		//unitList 배열에 값 넣기
		for (Unit unit : participant.units) {
			unitList.add(new TFTUnitInfo(unit, tap));
		}
		//traitList 값 정렬(style=3(고유특성)은 전방에, style 내림차순, style값이 같으면 가나다 순 오름차순)
		traitList.sort((a, b) -> {
		    if (a.style == 3 && b.style != 3) return -1;
		    if (a.style != 3 && b.style == 3) return 1;
		    if (a.style != b.style) {
		        return Integer.compare(b.style, a.style);
		    }
		    
		    return a.name.compareTo(b.name);
		});
		//traitList 값 정렬(rarity값 오름차순, rarity값이 같으면 가나다 순 오름차순)
		unitList.sort((a, b) -> {
			if(a.rarity != b.rarity) {
				return Integer.compare(a.rarity, b.rarity);
			}
			return a.name.compareTo(b.name);
		});
	}
}
