package com.spring.dto.lol;

import java.util.ArrayList;

import lombok.Data;

@Data
public class LOLMatchParticipant {

	private String id;						// 플레이어 아아디
	private String tag;						// 플레이어 태그
	private Integer summonerLevel;			// 플레이어 레벨
	private Integer profileIcon;			// 플레이어 아이콘
		
	private String position;				// 포지션(정글, 미드)
	private Integer champId;				// 챔피언 아이디
	private String champName;				// 챔피언 이름
	private Integer champLevel;				// 챔피언 레벨
	private ArrayList<LOLItemInfo> items;	// 아이템 목록(0~6, 6번은 장신구)
	private LOLPerksInfo perks;				// 룬
	private Integer summoner1Id;			// 플레이어 스펠(D)
	private Integer summoner2Id;			// 플레이어 스펠(F)

	private Integer kills;					// 킬
	private Integer deaths;					// 데스
	private Integer assists;				// 어시스트
	private Integer Cs;						// CS
	private Integer goldEarned;				// 획득한 골드
	private Integer visionScore;			// 시야 점수
	private Integer totalDamage;			// 가한 피해량
	private Integer totalDamageTaken;		// 받은 피해량
	private Integer damageSelfMitigated;	// 감소한 피해량
	private Integer physicDamage;			// 가한 물리 피해량
	private Integer magicDamage;			// 가한 마법 피해량
	private Integer trueDamage;				// 기힌 고정 피해량
	private Integer totalDamageObject;		// 오브젝트에게 가한 피해량

	
	private String teamId;
	public LOLMatchParticipant(Participant part) {
		this.id = part.riotIdGameName;
		this.tag = part.riotIdTagline;
		this.summonerLevel = part.summonerLevel;
		this.profileIcon = part.profileIcon;
		
		this.position = part.individualPosition;
		this.champId = part.championId;
		this.champName = part.championName;
		this.champLevel = part.champLevel;
		items.add(new LOLItemInfo(part.item0));
		items.add(new LOLItemInfo(part.item1));
		items.add(new LOLItemInfo(part.item2));
		items.add(new LOLItemInfo(part.item3));
		items.add(new LOLItemInfo(part.item4));
		items.add(new LOLItemInfo(part.item5));
		items.add(new LOLItemInfo(part.item6));
		this.summoner1Id = part.summoner1Id;
		this.summoner2Id = part.summoner2Id;
		
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
	}
}
