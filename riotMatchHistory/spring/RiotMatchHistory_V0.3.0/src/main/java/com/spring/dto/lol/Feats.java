package com.spring.dto.lol;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feats { // ������� ����
    @JsonProperty("EPIC_MONSTER_KILL") 
    public FeatState ePIC_MONSTER_KILL; // ���� ���� óġ
    @JsonProperty("FIRST_BLOOD") 
    public FeatState fIRST_BLOOD;		// ������
    @JsonProperty("FIRST_TURRET") 
    public FeatState fIRST_TURRET;		// ù ��ž �ı�
}
