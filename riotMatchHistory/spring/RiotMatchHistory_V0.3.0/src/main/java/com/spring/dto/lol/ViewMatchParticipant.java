package com.spring.dto.lol;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ViewMatchParticipant {

	private String id;						// �÷��̾� �ƾƵ�
	private String tag;						// �÷��̾� �±�
	private Integer summonerLevel;			// �÷��̾� ����
	private Integer profileIcon;			// �÷��̾� ������
	
	private String position;				// ������(����, �̵�)
	private Integer champId;				// è�Ǿ� ���̵�
	private String champName;				// è�Ǿ� �̸�
	private Integer champLevel;				// è�Ǿ� ����
	private ArrayList<ViewItem> items = new ArrayList<ViewItem>();	// ������ ���(0~6, 6���� ��ű�)
	private ViewPerks perks;				// ��
	private Integer summoner1Id;			// �÷��̾� ����(D)
	private Integer summoner2Id;			// �÷��̾� ����(F)

	private Integer kills;					// ų
	private Integer deaths;					// ����
	private Integer assists;				// ��ý�Ʈ
	private Integer Cs;						// CS
	private Integer goldEarned;				// ȹ���� ���
	private Integer visionScore;			// �þ� ����
	private Integer totalDamage;			// ���� ���ط�
	private Integer totalDamageTaken;		// ���� ���ط�
	private Integer damageSelfMitigated;	// ������ ���ط�
	private Integer physicDamage;			// ���� ���� ���ط�
	private Integer magicDamage;			// ���� ���� ���ط�
	private Integer trueDamage;				// ���� ���� ���ط�
	private Integer totalDamageObject;		// ������Ʈ���� ���� ���ط�
	private Integer teamId;					// �� ���̵�
	
	public ViewMatchParticipant(Participant part) {
		this.id = part.riotIdGameName;
		this.tag = part.riotIdTagline;
		this.summonerLevel = part.summonerLevel;
		this.profileIcon = part.profileIcon;
		
		this.position = part.individualPosition;
		this.champId = part.championId;
		this.champName = part.championName;
		this.champLevel = part.champLevel;
		items.add(new ViewItem(part.item0));
		items.add(new ViewItem(part.item1));
		items.add(new ViewItem(part.item2));
		items.add(new ViewItem(part.item3));
		items.add(new ViewItem(part.item4));
		items.add(new ViewItem(part.item5));
		items.add(new ViewItem(part.item6));
		this.summoner1Id = part.summoner1Id;
		this.summoner2Id = part.summoner2Id;
		this.perks = new ViewPerks(part.perks);
		this.kills = part.kills;
		this.deaths = part.deaths;
		this.assists = part.assists;
		this.Cs = part.totalMinionsKilled + part.neutralMinionsKilled;
		this.goldEarned = part.goldEarned;
		this.visionScore = part.visionScore;
		this.totalDamage = part.totalDamageDealtToChampions;
		this.totalDamageTaken = part.totalDamageTaken;
		this.damageSelfMitigated = part.damageSelfMitigated;
		this.physicDamage = part.physicalDamageDealtToChampions;
		this.magicDamage = part.magicDamageDealtToChampions;
		this.trueDamage = part.trueDamageDealtToChampions;
		this.totalDamageObject = part.damageDealtToObjectives;
		this.teamId = part.teamId;
	}
}
