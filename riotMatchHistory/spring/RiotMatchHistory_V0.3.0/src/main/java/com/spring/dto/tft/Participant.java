package com.spring.dto.tft; 
import java.util.ArrayList;
public class Participant{
    public Companion companion;			//�÷��̾� ������ ����
    public int gold_left;				//���� ���
    public int last_round;				//���� ����
    public int level;					//����
    public Missions missions;			//�̼� ����
    public int placement;				//���
    public int players_eliminated;		//óġ�� �÷��̾� ��
    public String puuid;				//�÷��̾� puuid
    public String riotIdGameName;		//�÷��̾� ���̵�
    public String riotIdTagline;		//�÷��̾� �±�
    public double time_eliminated;		//���� �ð�
    public int total_damage_to_players;	//���� ������
    public ArrayList<Trait> traits;		//Ȱ��ȭ�� Ư��
    public ArrayList<Unit> units;		//Ȱ��ȭ�� ����
    public boolean win;					//�¸� ����
}
