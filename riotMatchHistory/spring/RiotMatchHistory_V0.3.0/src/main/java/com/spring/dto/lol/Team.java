package com.spring.dto.lol;

import java.util.ArrayList;
import java.util.Map;

public class Team{
    public ArrayList<Ban> bans; 	// ���� �� ����
    public Map<String, FeatState> feats;				// �������
    public Map<String, Objective> objectives;	// �� ������Ʈ ����
    public int teamId;				// �� ���̵�
    public boolean win;				// �¸� ����
}
