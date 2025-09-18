package com.spring.dto.lol;

import lombok.Data;

@Data
public class TimeLineParticipantFrameDto {
    private TimeLineChampionStatsDto championStats;
    private int currentGold;
    private TimeLineDamageStatsDto damageStats;
    private int goldPerSecond;
    private int jungleMinionsKilled;
    private int level;
    private int minionsKilled;
    private int participantId;
    private TimeLinePositionDto position;
    private int timeEnemySpentControlled;
    private int totalGold;
    private int xp;
}