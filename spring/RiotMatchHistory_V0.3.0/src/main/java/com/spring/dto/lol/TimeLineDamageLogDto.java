package com.spring.dto.lol;

import lombok.Data;

@Data
public class TimeLineDamageLogDto { // ���� �α� ���� ����
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