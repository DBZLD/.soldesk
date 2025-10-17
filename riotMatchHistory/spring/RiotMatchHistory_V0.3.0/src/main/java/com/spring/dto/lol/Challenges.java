package com.spring.dto.lol;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Challenges {
	//�Ƹ��� ������ȭ ����
    @JsonProperty("SWARM_DefeatAatrox") 
    public int sWARM_DefeatAatrox;                    // ���� Aatrox óġ?
    @JsonProperty("SWARM_DefeatBriar") 
    public int sWARM_DefeatBriar;                     // ���� Briar óġ?
    @JsonProperty("SWARM_DefeatMiniBosses") 
    public int sWARM_DefeatMiniBosses;               // ���� �̴Ϻ��� óġ?
    @JsonProperty("SWARM_EvolveWeapon") 
    public int sWARM_EvolveWeapon;                   // ���� ���� ��ȭ?
    @JsonProperty("SWARM_Have3Passives") 
    public int sWARM_Have3Passives;                  // ���� �нú� 3�� ȹ��?
    @JsonProperty("SWARM_KillEnemy") 
    public int sWARM_KillEnemy;                      // ���� �� óġ?
    @JsonProperty("SWARM_PickupGold") 
    public int sWARM_PickupGold;                     // ���� ��� ȹ��?
    @JsonProperty("SWARM_ReachLevel50") 
    public int sWARM_ReachLevel50;                   // ���� ���� 50 ����?
    @JsonProperty("SWARM_Survive15Min") 
    public int sWARM_Survive15Min;                   // ���� 15�� ����?
    @JsonProperty("SWARM_WinWith5EvolvedWeapons") 
    public int sWARM_WinWith5EvolvedWeapons;        // ���� 5��ȭ ���� �¸�?
    
    @JsonProperty("12AssistStreakCount") 
    public int _12AssistStreakCount;                   // ���� ��ý�Ʈ Ƚ��
    @JsonProperty("HealFromMapSources") 
    public double healFromMapSources;                 // ���� �ҽ����� ȸ���� ��?
    @JsonProperty("InfernalScalePickup") 
    public int infernalScalePickup;                   // ȭ�� ���� ȹ�� ��
    
    public int abilityUses;                           // ��ų ��� Ƚ��
    public int acesBefore15Minutes;                  // 15�� ���� ��ü óġ ��
    public int alliedJungleMonsterKills;             // �Ʊ� ���� ���� óġ
    public int baronTakedowns;                        // �ٷ� ��Ÿ Ƚ��
    public int blastConeOppositeOpponentCount;        // ����� �ֹ��ź ���
    public double bountyGold;                         // ����� ���
    public int buffsStolen;                           // ���� ��ƿ Ƚ��
    public int completeSupportQuestInTime;           // ���� ������ ����Ʈ �Ϸ�
    public int controlWardsPlaced;                    // ���� �͵� ��ġ
    public double damagePerMinute;                    // �д� ���ط�
    public double damageTakenOnTeamPercentage;       // �� ��� ���� ���� ����
    public int dancedWithRiftHerald;                 // ������ ���ɰ� ���� Ƚ��
    public int deathsByEnemyChamps;                   // �� è�Ǿ𿡰� ��� Ƚ��
    public int dodgeSkillShotsSmallWindow;            // ����� �Ÿ����� ȸ���� ��ų�� ��
    public int doubleAces;                             // ���� ���̽� Ƚ��
    public int dragonTakedowns;                        // �巡�� óġ Ƚ��
    public int earlyLaningPhaseGoldExpAdvantage;      // �ʹ� ���� ���/����ġ ����(�κ� �̵�)
    public double effectiveHealAndShielding;          // ȸ��/���差
    public int elderDragonKillsWithOpposingSoul;      // ��� �巡�� ȿ���� ��� óġ
    public int elderDragonMultikills;                 // ��� �巡�� ȿ�� ��Ƽų
    public int enemyChampionImmobilizations;          // �� è�Ǿ𿡰� ����� ���� ���� Ƚ��
    public int enemyJungleMonsterKills;               // �� ���� ���� óġ
    public int epicMonsterKillsNearEnemyJungler;      // �� ���۷� ��ó ���� ���� óġ
    public int epicMonsterKillsWithin30SecondsOfSpawn; // ���� ���� ���� 30�� �̳� óġ
    public int epicMonsterSteals;                      // ���� ���� ��ƿ Ƚ��
    public int epicMonsterStolenWithoutSmite;         // ��Ÿ ���� ���� ���� ��ƿ Ƚ��
    public int firstTurretKilled;                      // ù ��° ��ž �ı� ����
    public double firstTurretKilledTime;              // ù ��° ��ž �ı� �ð�
    public int fistBumpParticipation;                 // �� �ָ��λ� ����
    public int flawlessAces;                           // ������ ���̽�
    public int fullTeamTakedown;                       // ��ü �� óġ ����
    public double gameLength;                          // ���� ����
    public int getTakedownsInAllLanesEarlyJungleAsLaner; // �ʹ� ������ ���� óġ ����?
    public double goldPerMinute;                        // �д� ���
    public int hadOpenNexus;                             // ����� �ؼ��� ����?
    public int highestWardKills;                         // �ִ� �͵� ����
    public int immobilizeAndKillWithAlly;               // �ڽ��� ���� ���� Ȱ�� �� ������ �� óġ Ƚ��
    public int initialBuffCount;                         // ù ����(���� ���) óġ ��
    public int initialCrabCount;                         // ù ���� �� óġ ��
    public double jungleCsBefore10Minutes;              // 10�� �� óġ�� ���� CS
    public int junglerTakedownsNearDamagedEpicMonster;  // ��� ���۷��� �������� ���� ���� óġ
    public int kTurretsDestroyedBeforePlatesFall;       // Ÿ�� �ı� Ƚ�� (��ž ���� �������� ��)
    public double kda;                                   // KDA ��ǥ
    public int killAfterHiddenWithAlly;                 // �Ʊ��� �Բ� ���� �� ų
    public double killParticipation;                    // ų ������
    public int killedChampTookFullTeamDamageSurvived;   // �� ��ü ���� �� ���� ų?
    public int killingSprees;                            // '�л���'��� Ƚ��
    public int killsNearEnemyTurret;                     // �� ��ž ��ó ų
    public int killsOnOtherLanesEarlyJungleAsLaner;      // �ٸ� ���ο��� ���� ���� ų?
    public int killsOnRecentlyHealedByAramPack;          // �� �� ȹ�� �� ų(Į�ٶ�)
    public int killsUnderOwnTurret;                      // �Ʊ� ��ž �������� ų
    public int killsWithHelpFromEpicMonster;            // ���� ������ ������ �ִ� ų
    public int knockEnemyIntoTeamAndKill;                // �׷������� �츮������ ����� �� ų Ƚ��
    public int landSkillShotsEarlyGame;                  // �ʹ� ��ų�� ���� Ƚ��
    public int laneMinionsFirst10Minutes;                // 10�� �� ���� �̴Ͼ� CS
    public int laningPhaseGoldExpAdvantage;              // ���� �ܰ� ���/����ġ ����
    public int legendaryCount;                            // '�����Դϴ�' ��� Ƚ��
    public ArrayList<Integer> legendaryItemUsed;         // ���� ��� ������ ���(�ϼ� ������)
    public int lostAnInhibitor;                           // ���� ������ ��
    public double maxCsAdvantageOnLaneOpponent;          // ���� ��� �ִ� CS ����
    public int maxKillDeficit;                             // �ִ� ų ����
    public int maxLevelLeadLaneOpponent;                  // ���� ��� �ִ� ���� ��
    public int mejaisFullStackInTime;                     // ������ Ǯ ���� �޼� ����
    public double moreEnemyJungleThanOpponent;           // ��� ���� ħ�� �ۼ�Ʈ
    public int multiKillOneSpell;                          // �� ����� �ټ��� ų
    public int multiTurretRiftHeraldCount;                // ������ ���� ��ž �ı� Ƚ��
    public int multikills;                                 // ��Ƽų ��
    public int multikillsAfterAggressiveFlash;            // �������� �÷��� �� ��Ƽų
    public int outerTurretExecutesBefore10Minutes;        // 10�� �� �ܰ� Ÿ�� ����
    public int outnumberedKills;                           // ���� ���� ��Ȳ ų
    public int outnumberedNexusKill;                       // ���� ���� ��Ȳ �ؼ��� ų
    public int perfectDragonSoulsTaken;                    // �Ϻ��� �巡�� ��ȥ ȹ��
    public int perfectGame;                                 // �Ϻ��� ��� ����(�� �뵥��)
    public int pickKillWithAlly;                            // �Ʊ� ���� ų Ƚ��
    public int playedChampSelectPosition;                   // ���� ������?
    public int poroExplosions;                               // ���� ���� Ƚ��(Į�ٶ�)
    public int quickCleanse;                                 // ���� ��ȭ
    public int quickFirstTurret;                            // ���� ù Ÿ��
    public int quickSoloKills;                             // ���� �ַ�ų
    public int riftHeraldTakedowns;                         // ������ ���� óġ����
    public int saveAllyFromDeath;                          // �Ʊ� �츰 Ƚ��
    public int scuttleCrabKills;                            // ���� �� óġ
    public int skillshotsDodged;                            // ȸ�� ��ų Ƚ��
    public int skillshotsHit;                                // ���� ��ų Ƚ��
    public int snowballsHit;                                // ������ ����(Į�ٶ�)
    public int soloBaronKills;                                // �ַ� �ٷ� ų
    public int soloKills;                                    // �ַ�ų
    public int stealthWardsPlaced;                            // ���ڽ� �͵� ��ġ
    public int survivedSingleDigitHpCount;                    // �� �ڸ� HP ���� Ƚ��
    public int survivedThreeImmobilizesInFight;               // 3ȸ �̻� ���� ���� ���� �� ����
    public int takedownOnFirstTurret;                         // ù Ÿ�� ���� �� �� óġ����
    public int takedowns;                                      // �� óġ���� Ƚ��
    public int takedownsAfterGainingLevelAdvantage;            // ������ �̿��ؼ� �� óġ����
    public int takedownsBeforeJungleMinionSpawn;               // ���� ���� ���� �� �� óġ����
    public int takedownsFirstXMinutes;                         // ó�� 10�� �� �� óġ����
    public int takedownsInAlcove;                              // ���� �� ��񿡼� �� óġ����
    public int takedownsInEnemyFountain;                       // �� �칰 �� �� óġ����
    public int teamBaronKills;                                  // �� �ٷ� óġ
    public double teamDamagePercentage;                         // �� ���� ����
    public int teamElderDragonKills;                             // �� ��� �巡�� óġ
    public int teamRiftHeraldKills;                              // �� ������ ���� óġ
    public int tookLargeDamageSurvived;                      // ū ���� ���� �� ����
    public int turretPlatesTaken;                             // ��ž ���� ȹ�� Ƚ��
    public int turretTakedowns;                               // ��ž �ı�����
    public int turretsTakenWithRiftHerald;                  // ������ ���ɰ� �Բ� ��ž �ı�
    public int twentyMinionsIn3SecondsCount;                 // 3�� �� 20�� �̻� �̴Ͼ� óġ
    public int twoWardsOneSweeperCount;                      // 2���� �͵带 1���� ����� �ı�
    public int unseenRecalls;                                  // ������ ���� ��ȯ
    public double visionScoreAdvantageLaneOpponent;           // ���� ������ �þ� ���� ����
    public double visionScorePerMinute;                         // �д� �þ� ����
    public int voidMonsterKill;                                // ���� ���� óġ?
    public int wardTakedowns;                                  // �͵� ���� ����
    public int wardTakedownsBefore20M;                         // 20�� �� �͵� ���� ����
    public int wardsGuarded;                                     // �͵� �ı� ��� Ƚ��
    public double earliestDragonTakedown;                       // ���� ���� �巡�� óġ����
    public int junglerKillsEarlyJungle;                           // ���۷� �ʱ� ų?
    public int killsOnLanersEarlyJungleAsJungler;                  // ���۷��� �ʱ� ���� ų?
    public double controlWardTimeCoverageInRiverOrEnemyHalf;      // �� �Ǵ� �� ������ ���� �͵� ���� �ð�
    public int soloTurretsLategame;                                 // �Ĺ� �ַ� Ÿ�� �ı�
    public int baronBuffGoldAdvantageOverThreshold;                // �ٷ� ���� �� ��� ����
    public double earliestBaron;                                 // ���� ���� �ٷ� óġ �ð�?
    public double shortestTimeToAceFromFirstTakedown;          // ù óġ���� ���̽����� �ּ� �ð�
    public int teleportTakedowns;                                // �ڷ���Ʈ ���� Ƚ��
    public double fastestLegendary;                               // ���� ���� '�����Դϴ�'��� �ð�
    public int highestChampionDamage;                             // �ְ� è�Ǿ� ����
    public int highestCrowdControlScore;                         // �ְ� ���� ���� ����
}
