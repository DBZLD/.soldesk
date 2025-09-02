package com.spring.dto.lol;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feats {
    @JsonProperty("EPIC_MONSTER_KILL") 
    public EPICMONSTERKILL ePIC_MONSTER_KILL;
    @JsonProperty("FIRST_BLOOD") 
    public FIRSTBLOOD fIRST_BLOOD;
    @JsonProperty("FIRST_TURRET") 
    public FIRSTTURRET fIRST_TURRET;
}
