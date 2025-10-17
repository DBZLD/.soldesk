package com.spring.dto.lol;

import lombok.Data;

@Data
public class TimeLineDamageLogDto { // 피해 로그 세부 내역
    private boolean basic;
    private int magicDamage;
    private String name;
    private int participantId;
    private int physicalDamage;
    private String spellName;
    private int spellSlot;
    private int trueDamage;
    private String type;
}