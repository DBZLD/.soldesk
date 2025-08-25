package com.spring.dto.tft; 
import java.util.ArrayList; 
public class Info{
    public String endOfGameResult;				//���� ���� ����
    public long gameCreation;					//���� ���� �ð�
    public long gameId;							//���� ���̵�(matchId)
    public long game_datetime;					//���� ���� �ð�
    public double game_length;					//���� ����
    public String game_version;					//���� ����
    public int mapId;							//�� ���̵�
    public ArrayList<Participant> participants;	//�÷��̾� ����
    public int queueId;							//��ġ Ÿ�� ���̵�
    public int queue_id;						//��ġ Ÿ�� ���̵�
    public String tft_game_type;				//TFT ���� Ÿ��
    public String tft_set_core_name;			//TFT ��Ʈ �̸�
    public int tft_set_number;					//��Ʈ ����
}
