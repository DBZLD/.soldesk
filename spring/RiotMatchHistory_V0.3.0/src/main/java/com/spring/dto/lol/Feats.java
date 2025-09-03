package com.spring.dto.lol;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feats { // 무력행사 정보
    @JsonProperty("EPIC_MONSTER_KILL") 
    public FeatState ePIC_MONSTER_KILL; // 에픽 몬스터 처치
    @JsonProperty("FIRST_BLOOD") 
    public FeatState fIRST_BLOOD;		// 선취점
    @JsonProperty("FIRST_TURRET") 
    public FeatState fIRST_TURRET;		// 첫 포탑 파괴
}
