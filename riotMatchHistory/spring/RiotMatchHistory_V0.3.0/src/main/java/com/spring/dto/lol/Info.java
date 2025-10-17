package com.spring.dto.lol;

import java.util.ArrayList;

public class Info { // 매치 상세 정보를 저장하는 클래스
    public String endOfGameResult;               // 게임 종료 상태 ("GameComplete" 등)
    public long gameCreation;                    // 게임 생성 시간 (Unix 타임스탬프)
    public int gameDuration;                     // 게임 길이 (초 단위)
    public long gameEndTimestamp;                // 게임 종료 시간 (Unix 타임스탬프)
    public long gameId;                          // 게임 고유 ID
    public String gameMode;                      // 게임 모드 (CLASSIC, ARAM 등)
    public String gameName;                      // 게임 이름
    public long gameStartTimestamp;              // 게임 시작 시간 (Unix 타임스탬프)
    public String gameType;                      // 게임 타입 (MATCHED_GAME 등)
    public String gameVersion;                   // 게임 버전 (예: 15.17.708.5788)
    public int mapId;                            // 맵 ID (예: Summoner’s Rift = 11)
    public ArrayList<Participant> participants; // 플레이어 정보 리스트
    public String platformId;                    // 플랫폼 ID (KR 등)
    public int queueId;                          // 큐 타입 ID (예: 440 = 랭크 )
    public ArrayList<Team> teams;                // 팀 정보 리스트
    public String tournamentCode;                // 토너먼트 코드 (존재 시)
}
