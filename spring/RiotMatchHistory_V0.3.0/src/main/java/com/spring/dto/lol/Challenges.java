package com.spring.dto.lol;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Challenges {
	//아마도 집중포화 관련
    @JsonProperty("SWARM_DefeatAatrox") 
    public int sWARM_DefeatAatrox;                    // 스웜 Aatrox 처치?
    @JsonProperty("SWARM_DefeatBriar") 
    public int sWARM_DefeatBriar;                     // 스웜 Briar 처치?
    @JsonProperty("SWARM_DefeatMiniBosses") 
    public int sWARM_DefeatMiniBosses;               // 스웜 미니보스 처치?
    @JsonProperty("SWARM_EvolveWeapon") 
    public int sWARM_EvolveWeapon;                   // 스웜 무기 진화?
    @JsonProperty("SWARM_Have3Passives") 
    public int sWARM_Have3Passives;                  // 스웜 패시브 3개 획득?
    @JsonProperty("SWARM_KillEnemy") 
    public int sWARM_KillEnemy;                      // 스웜 적 처치?
    @JsonProperty("SWARM_PickupGold") 
    public int sWARM_PickupGold;                     // 스웜 골드 획득?
    @JsonProperty("SWARM_ReachLevel50") 
    public int sWARM_ReachLevel50;                   // 스웜 레벨 50 도달?
    @JsonProperty("SWARM_Survive15Min") 
    public int sWARM_Survive15Min;                   // 스웜 15분 생존?
    @JsonProperty("SWARM_WinWith5EvolvedWeapons") 
    public int sWARM_WinWith5EvolvedWeapons;        // 스웜 5진화 무기 승리?
    
    @JsonProperty("12AssistStreakCount") 
    public int _12AssistStreakCount;                   // 연속 어시스트 횟수
    @JsonProperty("HealFromMapSources") 
    public double healFromMapSources;                 // 지도 소스에서 회복한 양?
    @JsonProperty("InfernalScalePickup") 
    public int infernalScalePickup;                   // 화염 조각 획득 수
    
    public int abilityUses;                           // 스킬 사용 횟수
    public int acesBefore15Minutes;                  // 15분 이전 전체 처치 수
    public int alliedJungleMonsterKills;             // 아군 정글 몬스터 처치
    public int baronTakedowns;                        // 바론 막타 횟수
    public int blastConeOppositeOpponentCount;        // 상대편 솔방울탄 사용
    public double bountyGold;                         // 현상금 골드
    public int buffsStolen;                           // 버프 스틸 횟수
    public int completeSupportQuestInTime;           // 서폿 아이템 퀘스트 완료
    public int controlWardsPlaced;                    // 제어 와드 설치
    public double damagePerMinute;                    // 분당 피해량
    public double damageTakenOnTeamPercentage;       // 팀 대비 받은 피해 비율
    public int dancedWithRiftHerald;                 // 협곡의 전령과 춤춘 횟수
    public int deathsByEnemyChamps;                   // 적 챔피언에게 사망 횟수
    public int dodgeSkillShotsSmallWindow;            // 가까운 거리에서 회피한 스킬샷 수
    public int doubleAces;                             // 연속 에이스 횟수
    public int dragonTakedowns;                        // 드래곤 처치 횟수
    public int earlyLaningPhaseGoldExpAdvantage;      // 초반 라인 골드/경험치 우위(인베 이득)
    public double effectiveHealAndShielding;          // 회복/쉴드량
    public int elderDragonKillsWithOpposingSoul;      // 장로 드래곤 효과로 상대 처치
    public int elderDragonMultikills;                 // 장로 드래곤 효과 멀티킬
    public int enemyChampionImmobilizations;          // 적 챔피언에게 사용한 군중 제어 횟수
    public int enemyJungleMonsterKills;               // 적 정글 몬스터 처치
    public int epicMonsterKillsNearEnemyJungler;      // 적 정글러 근처 에픽 몬스터 처치
    public int epicMonsterKillsWithin30SecondsOfSpawn; // 에픽 몬스터 생성 30초 이내 처치
    public int epicMonsterSteals;                      // 에픽 몬스터 스틸 횟수
    public int epicMonsterStolenWithoutSmite;         // 강타 없이 에픽 몬스터 스틸 횟수
    public int firstTurretKilled;                      // 첫 번째 포탑 파괴 여부
    public double firstTurretKilledTime;              // 첫 번째 포탑 파괴 시간
    public int fistBumpParticipation;                 // 팀 주먹인사 참여
    public int flawlessAces;                           // 무결점 에이스
    public int fullTeamTakedown;                       // 전체 팀 처치 관여
    public double gameLength;                          // 게임 길이
    public int getTakedownsInAllLanesEarlyJungleAsLaner; // 초반 정글이 라인 처치 관여?
    public double goldPerMinute;                        // 분당 골드
    public int hadOpenNexus;                             // 개방된 넥서스 여부?
    public int highestWardKills;                         // 최다 와드 제거
    public int immobilizeAndKillWithAlly;               // 자신의 군중 제어 활용 후 팀원과 적 처치 횟수
    public int initialBuffCount;                         // 첫 버프(레드 블루) 처치 수
    public int initialCrabCount;                         // 첫 바위 게 처치 수
    public double jungleCsBefore10Minutes;              // 10분 전 처치한 정글 CS
    public int junglerTakedownsNearDamagedEpicMonster;  // 상대 정글러가 피해입힌 에픽 몬스터 처치
    public int kTurretsDestroyedBeforePlatesFall;       // 타워 파괴 횟수 (포탑 방패 떨어지기 전)
    public double kda;                                   // KDA 지표
    public int killAfterHiddenWithAlly;                 // 아군과 함께 숨은 후 킬
    public double killParticipation;                    // 킬 관여율
    public int killedChampTookFullTeamDamageSurvived;   // 팀 전체 피해 후 생존 킬?
    public int killingSprees;                            // '학살중'띄운 횟수
    public int killsNearEnemyTurret;                     // 적 포탑 근처 킬
    public int killsOnOtherLanesEarlyJungleAsLaner;      // 다른 라인에서 조기 정글 킬?
    public int killsOnRecentlyHealedByAramPack;          // 힐 팩 획득 후 킬(칼바람)
    public int killsUnderOwnTurret;                      // 아군 포탑 범위에서 킬
    public int killsWithHelpFromEpicMonster;            // 에픽 몬스터의 도움이 있는 킬
    public int knockEnemyIntoTeamAndKill;                // 그랩등으로 우리팀에게 끌어온 후 킬 횟수
    public int landSkillShotsEarlyGame;                  // 초반 스킬샷 명중 횟수
    public int laneMinionsFirst10Minutes;                // 10분 내 라인 미니언 CS
    public int laningPhaseGoldExpAdvantage;              // 라인 단계 골드/경험치 우위
    public int legendaryCount;                            // '전설입니다' 띄운 횟수
    public ArrayList<Integer> legendaryItemUsed;         // 전설 등급 아이템 목록(완성 아이템)
    public int lostAnInhibitor;                           // 잃은 억제기 수
    public double maxCsAdvantageOnLaneOpponent;          // 라인 상대 최대 CS 우위
    public int maxKillDeficit;                             // 최대 킬 차이
    public int maxLevelLeadLaneOpponent;                  // 라인 상대 최대 레벨 차
    public int mejaisFullStackInTime;                     // 메자이 풀 스택 달성 여부
    public double moreEnemyJungleThanOpponent;           // 상대 정글 침법 퍼센트
    public int multiKillOneSpell;                          // 한 스펠로 다수의 킬
    public int multiTurretRiftHeraldCount;                // 협곡의 전령 포탑 파괴 횟수
    public int multikills;                                 // 멀티킬 수
    public int multikillsAfterAggressiveFlash;            // 공격적인 플래시 후 멀티킬
    public int outerTurretExecutesBefore10Minutes;        // 10분 전 외곽 타워 제거
    public int outnumberedKills;                           // 수적 열세 상황 킬
    public int outnumberedNexusKill;                       // 수적 열세 상황 넥서스 킬
    public int perfectDragonSoulsTaken;                    // 완벽한 드래곤 영혼 획득
    public int perfectGame;                                 // 완벽한 경기 여부(팀 노데스)
    public int pickKillWithAlly;                            // 아군 협력 킬 횟수
    public int playedChampSelectPosition;                   // 선택 포지션?
    public int poroExplosions;                               // 포로 폭발 횟수(칼바람)
    public int quickCleanse;                                 // 빠른 정화
    public int quickFirstTurret;                            // 빠른 첫 타워
    public int quickSoloKills;                             // 빠른 솔로킬
    public int riftHeraldTakedowns;                         // 협곡의 전령 처치관여
    public int saveAllyFromDeath;                          // 아군 살린 횟수
    public int scuttleCrabKills;                            // 바위 게 처치
    public int skillshotsDodged;                            // 회피 스킬 횟수
    public int skillshotsHit;                                // 적중 스킬 횟수
    public int snowballsHit;                                // 눈덩이 명중(칼바람)
    public int soloBaronKills;                                // 솔로 바론 킬
    public int soloKills;                                    // 솔로킬
    public int stealthWardsPlaced;                            // 스텔스 와드 설치
    public int survivedSingleDigitHpCount;                    // 한 자리 HP 생존 횟수
    public int survivedThreeImmobilizesInFight;               // 3회 이상 군중 제어 맞은 후 생존
    public int takedownOnFirstTurret;                         // 첫 타워 제거 중 적 처치관여
    public int takedowns;                                      // 총 처치관여 횟수
    public int takedownsAfterGainingLevelAdvantage;            // 레벨업 이용해서 적 처치관여
    public int takedownsBeforeJungleMinionSpawn;               // 정글 몬스터 스폰 전 적 처치관여
    public int takedownsFirstXMinutes;                         // 처음 10분 내 적 처치관여
    public int takedownsInAlcove;                              // 라인 뒷 골목에서 적 처치관여
    public int takedownsInEnemyFountain;                       // 적 우물 내 적 처치관여
    public int teamBaronKills;                                  // 팀 바론 처치
    public double teamDamagePercentage;                         // 팀 피해 비율
    public int teamElderDragonKills;                             // 팀 장로 드래곤 처치
    public int teamRiftHeraldKills;                              // 팀 협곡의 전령 처치
    public int tookLargeDamageSurvived;                      // 큰 피해 받은 후 생존
    public int turretPlatesTaken;                             // 포탑 방패 획득 횟수
    public int turretTakedowns;                               // 포탑 파괴관여
    public int turretsTakenWithRiftHerald;                  // 협곡의 전령과 함께 포탑 파괴
    public int twentyMinionsIn3SecondsCount;                 // 3초 내 20개 이상 미니언 처치
    public int twoWardsOneSweeperCount;                      // 2개의 와드를 1개의 렌즈로 파괴
    public int unseenRecalls;                                  // 보이지 않은 귀환
    public double visionScoreAdvantageLaneOpponent;           // 라인 상대와의 시야 점수 이점
    public double visionScorePerMinute;                         // 분당 시야 점수
    public int voidMonsterKill;                                // 공허 몬스터 처치?
    public int wardTakedowns;                                  // 와드 제거 관여
    public int wardTakedownsBefore20M;                         // 20분 전 와드 제거 관여
    public int wardsGuarded;                                     // 와드 파괴 방어 횟수
    public double earliestDragonTakedown;                       // 가장 빠른 드래곤 처치관여
    public int junglerKillsEarlyJungle;                           // 정글러 초기 킬?
    public int killsOnLanersEarlyJungleAsJungler;                  // 정글러로 초기 라인 킬?
    public double controlWardTimeCoverageInRiverOrEnemyHalf;      // 강 또는 적 영역의 제어 와드 생존 시간
    public int soloTurretsLategame;                                 // 후반 솔로 타워 파괴
    public int baronBuffGoldAdvantageOverThreshold;                // 바론 버프 중 골드 우위
    public double earliestBaron;                                 // 가장 빠른 바론 처치 시간?
    public double shortestTimeToAceFromFirstTakedown;          // 첫 처치부터 에이스까지 최소 시간
    public int teleportTakedowns;                                // 텔레포트 끊은 횟수
    public double fastestLegendary;                               // 가장 빠른 '전설입니다'띄운 시간
    public int highestChampionDamage;                             // 최고 챔피언 피해
    public int highestCrowdControlScore;                         // 최고 군중 제어 점수
}
