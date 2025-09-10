package com.spring.dto.lol;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeLineEventsDto {
	public long timestamp;      // 이벤트 발생 시간 (ms)
    public long realTimestamp;  // 실제 서버 시간 (ms)
    public String type;         // 이벤트 타입 (LEVEL_UP, ITEM_PURCHASED, CHAMPION_KILL 등)

    // 공통적으로 들어올 수 있는 값들
    public Integer participantId;
    public Integer level;
    public Integer skillSlot;
    public Integer itemId;
    public Integer creatorId;
    public String wardType;

    // 킬 관련
    public Integer killerId;
    public Integer victimId;
    public List<Integer> assistingParticipantIds;
    public List<TimeLineDamageLogDto> victimDamageDealt;
    public List<TimeLineDamageLogDto> victimDamageReceived;
    public Integer killStreakLength;
    public Integer bounty;
    public Integer shutdownBounty;
    public String killType;
    public Integer multiKillLength;

    // 피트(업적) 관련
    public Integer featType;
    public Integer featValue;
    public Integer teamId;
}