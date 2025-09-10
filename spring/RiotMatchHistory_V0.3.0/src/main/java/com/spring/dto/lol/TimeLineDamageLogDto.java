package com.spring.dto.lol;

public class TimeLineDamageLogDto { // 피해 로그 세부 내역
    public boolean basic;       // 평타 여부
    public String name;			// 챔피언 이름
    public int participantId;   // 가해자/피해자 ID
    public String spellName;	// 스킬 이름
    public int spellSlot;       // 스킬 슬롯
    public int magicDamage;		// 마법 데미지
    public int physicalDamage;	// 물리 데미지
    public int trueDamage;		// 고정 데미지
    public String type;			// 타입
}