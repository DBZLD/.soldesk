package com.spring.dto.lol;

import java.util.ArrayList;

public class Info { // ��ġ �� ������ �����ϴ� Ŭ����
    public String endOfGameResult;               // ���� ���� ���� ("GameComplete" ��)
    public long gameCreation;                    // ���� ���� �ð� (Unix Ÿ�ӽ�����)
    public int gameDuration;                     // ���� ���� (�� ����)
    public long gameEndTimestamp;                // ���� ���� �ð� (Unix Ÿ�ӽ�����)
    public long gameId;                          // ���� ���� ID
    public String gameMode;                      // ���� ��� (CLASSIC, ARAM ��)
    public String gameName;                      // ���� �̸�
    public long gameStartTimestamp;              // ���� ���� �ð� (Unix Ÿ�ӽ�����)
    public String gameType;                      // ���� Ÿ�� (MATCHED_GAME ��)
    public String gameVersion;                   // ���� ���� (��: 15.17.708.5788)
    public int mapId;                            // �� ID (��: Summoner��s Rift = 11)
    public ArrayList<Participant> participants; // �÷��̾� ���� ����Ʈ
    public String platformId;                    // �÷��� ID (KR ��)
    public int queueId;                          // ť Ÿ�� ID (��: 440 = ��ũ )
    public ArrayList<Team> teams;                // �� ���� ����Ʈ
    public String tournamentCode;                // ��ʸ�Ʈ �ڵ� (���� ��)
}
