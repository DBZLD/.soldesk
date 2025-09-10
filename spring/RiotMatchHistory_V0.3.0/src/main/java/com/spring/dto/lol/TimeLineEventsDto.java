package com.spring.dto.lol;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeLineEventsDto {
	public long timestamp;      // �̺�Ʈ �߻� �ð� (ms)
    public long realTimestamp;  // ���� ���� �ð� (ms)
    public String type;         // �̺�Ʈ Ÿ�� (LEVEL_UP, ITEM_PURCHASED, CHAMPION_KILL ��)

    // ���������� ���� �� �ִ� ����
    public Integer participantId;
    public Integer level;
    public Integer skillSlot;
    public Integer itemId;
    public Integer creatorId;
    public String wardType;

    // ų ����
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

    // ��Ʈ(����) ����
    public Integer featType;
    public Integer featValue;
    public Integer teamId;
}