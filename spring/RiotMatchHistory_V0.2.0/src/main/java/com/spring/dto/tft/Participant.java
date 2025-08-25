package com.spring.dto.tft; 
import java.util.ArrayList;
public class Participant{
    public Companion companion;			//플레이어 전설이 정보
    public int gold_left;				//남은 골드
    public int last_round;				//생존 라운드
    public int level;					//레벨
    public Missions missions;			//미션 진행
    public int placement;				//등수
    public int players_eliminated;		//처치한 플레이어 수
    public String puuid;				//플레이어 puuid
    public String riotIdGameName;		//플레이어 아이디
    public String riotIdTagline;		//플레이어 태그
    public double time_eliminated;		//생존 시간
    public int total_damage_to_players;	//입힌 데미지
    public ArrayList<Trait> traits;		//활성화된 특성
    public ArrayList<Unit> units;		//활성화된 유닛
    public boolean win;					//승리 여부
}
