package com.spring.dto.lol;

import java.util.ArrayList;

public class Team{
    public ArrayList<Ban> bans; 	// 팀의 밴 정보
    public Feats feats;				// 무력행사
    public Objectives objectives;	// 팀 오브젝트 정보
    public int teamId;				// 팀 아이디
    public boolean win;				// 승리 여부
}
