package com.spring.dto.lol;

public class Participant { // 매치의 플레이어 상세 정보가 들어있는 클래스
	//플레이어 정보
	public String puuid;                      // 플레이어 puuid
	public String summonerId;                 // 소환사 ID
	public String riotIdGameName;             // 라이엇 게임 닉네임
	public String riotIdTagline;              // 라이엇 태그라인
	public int summonerLevel;                 // 소환사 레벨
    public int profileIcon;                   // 프로필 아이콘 ID
    public int participantId;                 // participant배열 내에서의 순서
    
    //플레이어 매치 통계
    public int championId;                    // 챔피언 ID
    public String championName;               // 챔피언 이름
    public int champLevel;                    // 챔피언 레벨
    public int champExperience;               // 챔피언 경험치
    public int championTransform;             // 챔피언 변신 상태 (케인 용)
    public String individualPosition;         // 포지션 (TOP, MID, BOTTOM, UTILITY)
    public String teamPosition;               // 팀 포지션 (TOP, MID, BOTTOM, UTILITY)
    public String lane;                       // 라인 (TOP, MIDDLE, JUNGLE, BOTTOM)
    public String role;                       // 역할 (SOLO, CARRY, SUP, NONE)
    public int kills;                         // 킬 수
    public int deaths;                        // 사망 횟수
    public int assists;                       // 어시스트 횟수
    public int tripleKills;                   // 트리플킬 수
    public int quadraKills;                   // 쿼드라킬 수
    public int pentaKills;                    // 펜타킬 수
    public int unrealKills;                   // 5연속 킬 이상 수
    public int doubleKills;                   // 더블킬 수
    public int killingSprees;                 // 연속 킬 수
    public int largestKillingSpree;           // 최대 연속 킬
    public int largestMultiKill;              // 최대 멀티킬(더블, 트리플)
    public int totalMinionsKilled;            // 상대 미니언 처치 수
    public int neutralMinionsKilled;          // 중립 미니언(상대 미니언 제외 전부) 처치 수
    public int totalAllyJungleMinionsKilled;  // 아군 정글 몬스터 처치 수
    public int totalEnemyJungleMinionsKilled; // 적 정글 몬스터 처치 수
    public int largestCriticalStrike;         // 최대 치명타
    public int timePlayed;                    // 플레이 시간 (초)
    public int longestTimeSpentLiving;        // 최장 생존 시간
    public int timeCCingOthers;               // 군중 제어 가한 시간
    public int totalTimeCCDealt;              // 군중 제어 당한 시간
    public int totalTimeSpentDead;            // 사망으로 보낸 시간
    public Perks perks;                       // 룬 정보
    public int spell1Casts;                   // q 사용 횟수
    public int spell2Casts;                   // w 사용 횟수
    public int spell3Casts;                   // e 사용 횟수
    public int spell4Casts;                   // r 사용 횟수
    public int summoner1Casts;                // 소환사 주문1 사용 횟수
    public int summoner1Id;                   // 소환사 주문1 ID
    public int summoner2Casts;                // 소환사 주문2 사용 횟수
    public int summoner2Id;                   // 소환사 주문2 ID
    public Challenges challenges;             // 플레이어 업적(상세 통계)
    //골드, 아이템
    public int goldEarned;                    // 획득 골드
    public int goldSpent;                     // 사용 골드
    public int item0;                         // 장비 슬롯 0
    public int item1;                         // 장비 슬롯 1
    public int item2;                         // 장비 슬롯 2
    public int item3;                         // 장비 슬롯 3
    public int item4;                         // 장비 슬롯 4
    public int item5;                         // 장비 슬롯 5
    public int item6;                         // 장비 슬롯 6 (장신구)
    public int itemsPurchased;                // 총 구매 아이템 수
    public int consumablesPurchased;          // 소비 아이템 구매 횟수
    
    // 핑
    public int allInPings;                    // 사용한 총공격 핑 횟수
    public int assistMePings;                 // 사용한 지원 핑 횟수
    public int basicPings;                    // 사용한 기본 핑 횟수
    public int commandPings;                  // 사용한 명령 핑 횟수
    public int dangerPings;                   // 사용한 위험 핑 횟수
    public int enemyMissingPings;             // 사용한 적 실종 핑 횟수
    public int enemyVisionPings;              // 사용한 와드 발견 핑 횟수
    public int getBackPings;                  // 사용한 위험 핑 횟수
    public int holdPings;                     // 사용한 대기 요청 핑 횟수
    public int needVisionPings;               // 사용한 시야 요청 핑 횟수
    public int onMyWayPings;                  // 사용한 이동 핑 횟수
    public int pushPings;                     // 사용한 push 핑 횟수
    public int visionClearedPings;            // 사용한 시야 제거 요청 핑 횟수
    public int retreatPings;                  // 사용한 후퇴 요청 핑 횟수
    
    //피해량, 회복량, 받은 피해량, 경감한 피해량
    public int totalDamageDealt;              // 총 피해량
    public int totalDamageDealtToChampions;   // 챔피언에게 가한 총 피해량
    public int totalDamageTaken;              // 받은 피해량
    public int damageSelfMitigated;           // 경감한 피해량
    public int totalHeal;                     // 총 회복량
    public int totalDamageShieldedOnTeammates;// 아군 보호막 총 흡수량
    public int totalHealsOnTeammates;         // 아군 회복량
    public int totalUnitsHealed;              // 회복한 유닛 수?
    public int physicalDamageDealt;           // 가한 물리 피해량
    public int physicalDamageDealtToChampions;// 챔피언에게 입힌 물리 피해량
    public int physicalDamageTaken;           // 받은 물리 피해량
    public int magicDamageDealt;              // 가한 마법 피해량
    public int magicDamageDealtToChampions;   // 챔피언에게 입힌 마법 피해량
    public int magicDamageTaken;              // 총 받은 마법 피해량
    public int trueDamageDealt;               // 총 고정 피해량
    public int trueDamageDealtToChampions;    // 챔피언에게 입힌 고정 피해량
    public int trueDamageTaken;               // 받은 고정 피해량
    public int damageDealtToBuildings;        // 구조물에 입힌 피해량
    public int damageDealtToTurrets;          // 포탑에 입힌 피해량
    public int damageDealtToObjectives;       // 오브젝트에 입힌 피해량

    //오브젝트, 구조물
    public boolean firstBloodAssist;          // 첫 킬 어시스트 여부
    public boolean firstBloodKill;            // 첫 킬 여부
    public boolean firstTowerAssist;          // 첫 포탑 어시스트 여부
    public boolean firstTowerKill;            // 첫 포탑 파괴 여부
    public int objectivesStolen;              // 오브젝트 스틸 수
    public int objectivesStolenAssists;       // 오브젝트 스틸 어시스트 수
    public int turretKills;                   // 포탑 처치 수
    public int turretTakedowns;               // 포탑 파괴관여
    public int turretsLost;                   // 잃은 포탑 수
    public int baronKills;                    // 바론 처치 횟수
    public int dragonKills;                   // 드래곤 처치 수
    public int inhibitorKills;                // 억제기 파괴 수
    public int inhibitorTakedowns;            // 억제기 파괴관여
    public int inhibitorsLost;                // 잃은 억제기 수
    public int nexusKills;                    // 넥서스 파괴 수
    public int nexusLost;                     // 잃은 넥서스 수
    public int nexusTakedowns;                // 넥서스 파괴관여
    
    //시야
    public int visionScore;                   // 시야 점수
    public int detectorWardsPlaced;           // 제어 와드 설치 수
    public int visionWardsBoughtInGame;       // 제어 와드 구매 수
    public int wardsPlaced;                   // 와드 설치 수
    public int wardsKilled;                   // 와드 제거 수
    public int sightWardsBoughtInGame;        // 시야용 와드 구매 수(과거 와드 말하는 것 같음)
    
    //팀
    public int teamId;                        // 팀 ID(블루:100, 레드:200)
    public boolean gameEndedInEarlySurrender; // 조기 항복으로 종료 여부
    public boolean gameEndedInSurrender;      // 항복으로 종료 여부
    public boolean teamEarlySurrendered;      // 팀 조기 항복 여부
    public boolean win;                       // 승리 여부
    
    //용도 불명
    public int PlayerScore0;                  // 플레이어 점수 0?
    public int PlayerScore1;                  // 플레이어 점수 1?
    public int PlayerScore2;                  // 플레이어 점수 2?
    public int PlayerScore3;                  // 플레이어 점수 3?
    public int PlayerScore4;                  // 플레이어 점수 4?
    public int PlayerScore5;                  // 플레이어 점수 5?
    public int PlayerScore6;                  // 플레이어 점수 6?
    public int PlayerScore7;                  // 플레이어 점수 7?
    public int PlayerScore8;                  // 플레이어 점수 8?
    public int PlayerScore9;                  // 플레이어 점수 9?
    public int PlayerScore10;                 // 플레이어 점수 10?
    public int PlayerScore11;                 // 플레이어 점수 11?
    public boolean eligibleForProgression;    // 프로그레션 진행 가능 여부?
    public int subteamPlacement;              // 서브팀 순위?
    public int placement;                     // 경기 순위?
    public int playerAugment1;                // 플레이어 보조 능력치 1?
    public int playerAugment2;                // 플레이어 보조 능력치 2?
    public int playerAugment3;                // 플레이어 보조 능력치 3?
    public int playerAugment4;                // 플레이어 보조 능력치 4?
    public int playerAugment5;                // 플레이어 보조 능력치 5?
    public int playerAugment6;                // 플레이어 보조 능력치 6?
    public int playerSubteamId;               // 서브 팀 ID?
    public Missions missions;                 // 미션 정보?
    public String summonerName;               // 소환사 이름?
}

