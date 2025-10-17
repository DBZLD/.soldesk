package com.spring.dto.lol;

import java.util.List;

import lombok.Data;

@Data
public class TimeLineEventsDto {
	private String type;
    private long timestamp;
    private Long realTimestamp;

    private Integer participantId;
    private Integer level;
    private String levelUpType;
    private Integer skillSlot;

    private Integer itemId;
    private Integer creatorId;
    private String wardType;

    private Integer killerId;
    private Integer victimId;
    private List<Integer> assistingParticipantIds;
    private Integer bounty;
    private Integer killStreakLength;
    private Integer shutdownBounty;
    private TimeLinePositionDto position;

    private List<TimeLineDamageLogDto> victimDamageDealt;
    private List<TimeLineDamageLogDto> victimDamageReceived;
}