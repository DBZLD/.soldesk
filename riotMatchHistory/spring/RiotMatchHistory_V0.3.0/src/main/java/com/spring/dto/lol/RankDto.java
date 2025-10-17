package com.spring.dto.lol;

public class RankDto {
	public String puuid;		// 플레이어 puuid
	public String leagueId;		// 리그 아이디
	public String queueType;	// 매치 타입
	public String tier;			// 티어(다이아몬드)
	public String rank;			// 랭크(1,2)
	public Integer leaguePoints;// 점수
	public Integer wins;		// 승수
	public Integer losses;		// 패수
	public Boolean veteran;		// 오랜기간 활동한 플레이어 여부
	public Boolean inactive;	// 비활성 계정 여부
	public Boolean freshBlood;	// 첫 시즌 여부
	public Boolean hotStreak;	// 연승 여부
}
