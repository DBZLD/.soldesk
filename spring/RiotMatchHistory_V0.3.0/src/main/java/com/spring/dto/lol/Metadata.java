package com.spring.dto.lol;

import java.util.ArrayList;

public class Metadata { // 매치 정보를 저장하는 클래스
    public String dataVersion;				//데이터 버전
    public String matchId;					//메치 아이디
    public ArrayList<String> participants;	//플레이어 puuid 리스트
}
