package com.spring.dto.tft; 
import java.util.ArrayList; 
public class Info{
    public String endOfGameResult;				//게임 종료 여부
    public long gameCreation;					//게임 시작 시간
    public long gameId;							//게임 아이디(matchId)
    public long game_datetime;					//게임 종료 시간
    public double game_length;					//게임 길이
    public String game_version;					//게임 버전
    public int mapId;							//맵 아이디
    public ArrayList<Participant> participants;	//플레이어 정보
    public int queueId;							//매치 타입 아이디
    public int queue_id;						//매치 타입 아이디
    public String tft_game_type;				//TFT 게임 타입
    public String tft_set_core_name;			//TFT 세트 이름
    public int tft_set_number;					//세트 버전
}
