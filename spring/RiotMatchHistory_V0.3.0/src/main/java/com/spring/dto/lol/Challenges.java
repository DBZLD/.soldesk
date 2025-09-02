package com.spring.dto.lol;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Challenges {
	@JsonProperty("12AssistStreakCount") 
    public int _12AssistStreakCount;
    @JsonProperty("HealFromMapSources") 
    public double healFromMapSources;
    @JsonProperty("InfernalScalePickup") 
    public int infernalScalePickup;
    @JsonProperty("SWARM_DefeatAatrox") 
    public int sWARM_DefeatAatrox;
    @JsonProperty("SWARM_DefeatBriar") 
    public int sWARM_DefeatBriar;
    @JsonProperty("SWARM_DefeatMiniBosses") 
    public int sWARM_DefeatMiniBosses;
    @JsonProperty("SWARM_EvolveWeapon") 
    public int sWARM_EvolveWeapon;
    @JsonProperty("SWARM_Have3Passives") 
    public int sWARM_Have3Passives;
    @JsonProperty("SWARM_KillEnemy") 
    public int sWARM_KillEnemy;
    @JsonProperty("SWARM_PickupGold") 
    public int sWARM_PickupGold;
    @JsonProperty("SWARM_ReachLevel50") 
    public int sWARM_ReachLevel50;
    @JsonProperty("SWARM_Survive15Min") 
    public int sWARM_Survive15Min;
    @JsonProperty("SWARM_WinWith5EvolvedWeapons") 
    public int sWARM_WinWith5EvolvedWeapons;
    public int abilityUses;
    public int acesBefore15Minutes;
    public int alliedJungleMonsterKills;
    public int baronTakedowns;
    public int blastConeOppositeOpponentCount;
    public double bountyGold;
    public int buffsStolen;
    public int completeSupportQuestInTime;
    public int controlWardsPlaced;
    public double damagePerMinute;
    public double damageTakenOnTeamPercentage;
    public int dancedWithRiftHerald;
    public int deathsByEnemyChamps;
    public int dodgeSkillShotsSmallWindow;
    public int doubleAces;
    public int dragonTakedowns;
    public int earlyLaningPhaseGoldExpAdvantage;
    public double effectiveHealAndShielding;
    public int elderDragonKillsWithOpposingSoul;
    public int elderDragonMultikills;
    public int enemyChampionImmobilizations;
    public int enemyJungleMonsterKills;
    public int epicMonsterKillsNearEnemyJungler;
    public int epicMonsterKillsWithin30SecondsOfSpawn;
    public int epicMonsterSteals;
    public int epicMonsterStolenWithoutSmite;
    public int firstTurretKilled;
    public double firstTurretKilledTime;
    public int fistBumpParticipation;
    public int flawlessAces;
    public int fullTeamTakedown;
    public double gameLength;
    public int getTakedownsInAllLanesEarlyJungleAsLaner;
    public double goldPerMinute;
    public int hadOpenNexus;
    public int highestWardKills;
    public int immobilizeAndKillWithAlly;
    public int initialBuffCount;
    public int initialCrabCount;
    public double jungleCsBefore10Minutes;
    public int junglerTakedownsNearDamagedEpicMonster;
    public int kTurretsDestroyedBeforePlatesFall;
    public double kda;
    public int killAfterHiddenWithAlly;
    public double killParticipation;
    public int killedChampTookFullTeamDamageSurvived;
    public int killingSprees;
    public int killsNearEnemyTurret;
    public int killsOnOtherLanesEarlyJungleAsLaner;
    public int killsOnRecentlyHealedByAramPack;
    public int killsUnderOwnTurret;
    public int killsWithHelpFromEpicMonster;
    public int knockEnemyIntoTeamAndKill;
    public int landSkillShotsEarlyGame;
    public int laneMinionsFirst10Minutes;
    public int laningPhaseGoldExpAdvantage;
    public int legendaryCount;
    public ArrayList<Integer> legendaryItemUsed;
    public int lostAnInhibitor;
    public double maxCsAdvantageOnLaneOpponent;
    public int maxKillDeficit;
    public int maxLevelLeadLaneOpponent;
    public int mejaisFullStackInTime;
    public double moreEnemyJungleThanOpponent;
    public int multiKillOneSpell;
    public int multiTurretRiftHeraldCount;
    public int multikills;
    public int multikillsAfterAggressiveFlash;
    public int outerTurretExecutesBefore10Minutes;
    public int outnumberedKills;
    public int outnumberedNexusKill;
    public int perfectDragonSoulsTaken;
    public int perfectGame;
    public int pickKillWithAlly;
    public int playedChampSelectPosition;
    public int poroExplosions;
    public int quickCleanse;
    public int quickFirstTurret;
    public int quickSoloKills;
    public int riftHeraldTakedowns;
    public int saveAllyFromDeath;
    public int scuttleCrabKills;
    public int skillshotsDodged;
    public int skillshotsHit;
    public int snowballsHit;
    public int soloBaronKills;
    public int soloKills;
    public int stealthWardsPlaced;
    public int survivedSingleDigitHpCount;
    public int survivedThreeImmobilizesInFight;
    public int takedownOnFirstTurret;
    public int takedowns;
    public int takedownsAfterGainingLevelAdvantage;
    public int takedownsBeforeJungleMinionSpawn;
    public int takedownsFirstXMinutes;
    public int takedownsInAlcove;
    public int takedownsInEnemyFountain;
    public int teamBaronKills;
    public double teamDamagePercentage;
    public int teamElderDragonKills;
    public int teamRiftHeraldKills;
    public int tookLargeDamageSurvived;
    public int turretPlatesTaken;
    public int turretTakedowns;
    public int turretsTakenWithRiftHerald;
    public int twentyMinionsIn3SecondsCount;
    public int twoWardsOneSweeperCount;
    public int unseenRecalls;
    public double visionScoreAdvantageLaneOpponent;
    public double visionScorePerMinute;
    public int voidMonsterKill;
    public int wardTakedowns;
    public int wardTakedownsBefore20M;
    public int wardsGuarded;
    public double earliestDragonTakedown;
    public int junglerKillsEarlyJungle;
    public int killsOnLanersEarlyJungleAsJungler;
    public double controlWardTimeCoverageInRiverOrEnemyHalf;
    public int soloTurretsLategame;
    public int baronBuffGoldAdvantageOverThreshold;
    public double earliestBaron;
    public double shortestTimeToAceFromFirstTakedown;
    public int teleportTakedowns;
    public double fastestLegendary;
    public int highestChampionDamage;
    public int highestCrowdControlScore;

}
