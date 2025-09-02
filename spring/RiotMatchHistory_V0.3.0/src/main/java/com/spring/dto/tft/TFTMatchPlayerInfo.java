package com.spring.dto.tft;

import java.util.ArrayList;

import com.spring.service.TFTApiProcessor;

public class TFTMatchPlayerInfo {
	public String playerId;			//�÷��̾� ���̵�
	public String playerTag;		//�÷��̾� �±�
	public String playerPuuid;		//�÷��̾� puuid
	public String tacticianId;		//������(�÷��̾� ĳ����)���̵�
	public String tacticianName;	//������ �̸�
	public String tacticianFull;	//������ �̹���
	public String tacticianGroup;	//������ �̹��� ����
	public String tacticianImgURL;	//������ �̹��� ��ũ
	public Integer goldLeft;		//���� ���
	public String lastRound;		//���� ����
	public Integer level;			//����
	public Integer placement;		//���
	public String timeElemented;	//���� �ð�
	public Integer totalDamage;		//���� ������
	public ArrayList<TFTTraitInfo> traitList = new ArrayList<>();	//Ư�� �迭
	public ArrayList<TFTUnitInfo> unitList = new ArrayList<>();		//���� �迭

	//partitipant, queueType, tap�� �޾Ƽ� ����, ���� �� �����ϴ� ������ �Լ�
	public TFTMatchPlayerInfo(Participant participant, String queueType, TFTApiProcessor tap) {
		//playerId�� participant.riotIdGameName �Ҵ�
		playerId = participant.riotIdGameName;
		//playerTag�� participant.riotIdTagline �Ҵ�
		playerTag = participant.riotIdTagline;
		//playerPuuid�� participant.puuid �Ҵ�
		playerPuuid = participant.puuid;
		//goldLeft�� participant.gold_left �Ҵ�
		goldLeft = participant.gold_left;
		//lastRound�� tap���� ��ȯ�� lastRound �Ҵ�
		lastRound = tap.transLastRound(participant.last_round);
		//level�� participant.level �Ҵ�
		level = participant.level;
		//queueType�� ���� �� �϶��� ��� ����(1,1,2,2,3,3,4,4)������
		if(queueType.equals("���� ��")) {
			placement = (int)Math.floor(((double)participant.placement+1)/2);
		}else {
			//�ƴϸ� placement�� participant.placement �Ҵ�
			placement = participant.placement;			
		}
		//timeElemented�� tap���� ��ȯ�� timeEliminated �Ҵ�
		timeElemented = tap.transTimeElemented(participant.time_eliminated);
		//totalDamage�� participant.total_damage_to_players �Ҵ�
		totalDamage = participant.total_damage_to_players;
		
		//tacticianId�� int������ ��ȯ�� item_ID �Ҵ�
		tacticianId = Integer.toString(participant.companion.item_ID);
		//tacticianName�� tap���� tacticianId�� ��ġ�ϴ� value.name �Ҵ�
		tacticianName = tap.tactician.data.get(tacticianId).name;
		//tacticianFull�� tap���� tacticianId�� ��ġ�ϴ� value.image.full �Ҵ�
		tacticianFull = tap.tactician.data.get(tacticianId).image.full;
		//tacticianGroup�� tap���� tacticianId�� ��ġ�ϴ� value.image.group �Ҵ�
		tacticianGroup = tap.tactician.data.get(tacticianId).image.group;
		//tacticianName�� tap���� ��ȯ�� �̹���URL �Ҵ�
		tacticianImgURL = tap.getImgURL(tacticianGroup, tacticianFull);

		//traitList �迭�� �� �ֱ�
		for (Trait trait : participant.traits) {
			//tier_current���� 0�� �ƴ� trait�� ó����
			if (!(trait.tier_current == 0)) {
				traitList.add(new TFTTraitInfo(trait, tap));
			}
		}
		//unitList �迭�� �� �ֱ�
		for (Unit unit : participant.units) {
			unitList.add(new TFTUnitInfo(unit, tap));
		}
		//traitList �� ����(style=3(����Ư��)�� ���濡, style ��������, style���� ������ ������ �� ��������)
		traitList.sort((a, b) -> {
		    if (a.style == 3 && b.style != 3) return -1;
		    if (a.style != 3 && b.style == 3) return 1;
		    if (a.style != b.style) {
		        return Integer.compare(b.style, a.style);
		    }
		    
		    return a.name.compareTo(b.name);
		});
		//traitList �� ����(rarity�� ��������, rarity���� ������ ������ �� ��������)
		unitList.sort((a, b) -> {
			if(a.rarity != b.rarity) {
				return Integer.compare(a.rarity, b.rarity);
			}
			return a.name.compareTo(b.name);
		});
	}
}
