package com.spring.dto.lol;

public class Participant { // ��ġ�� �÷��̾� �� ������ ����ִ� Ŭ����
	//�÷��̾� ����
	public String puuid;                      // �÷��̾� puuid
	public String summonerId;                 // ��ȯ�� ID
	public String riotIdGameName;             // ���̾� ���� �г���
	public String riotIdTagline;              // ���̾� �±׶���
	public int summonerLevel;                 // ��ȯ�� ����
    public int profileIcon;                   // ������ ������ ID
    public int participantId;                 // participant�迭 �������� ����
    
    //�÷��̾� ��ġ ���
    public int championId;                    // è�Ǿ� ID
    public String championName;               // è�Ǿ� �̸�
    public int champLevel;                    // è�Ǿ� ����
    public int champExperience;               // è�Ǿ� ����ġ
    public int championTransform;             // è�Ǿ� ���� ���� (���� ��)
    public String individualPosition;         // ������ (TOP, MID, BOTTOM, UTILITY)
    public String teamPosition;               // �� ������ (TOP, MID, BOTTOM, UTILITY)
    public String lane;                       // ���� (TOP, MIDDLE, JUNGLE, BOTTOM)
    public String role;                       // ���� (SOLO, CARRY, SUP, NONE)
    public int kills;                         // ų ��
    public int deaths;                        // ��� Ƚ��
    public int assists;                       // ��ý�Ʈ Ƚ��
    public int tripleKills;                   // Ʈ����ų ��
    public int quadraKills;                   // �����ų ��
    public int pentaKills;                    // ��Ÿų ��
    public int unrealKills;                   // 5���� ų �̻� ��
    public int doubleKills;                   // ����ų ��
    public int killingSprees;                 // ���� ų ��
    public int largestKillingSpree;           // �ִ� ���� ų
    public int largestMultiKill;              // �ִ� ��Ƽų(����, Ʈ����)
    public int totalMinionsKilled;            // ��� �̴Ͼ� óġ ��
    public int neutralMinionsKilled;          // �߸� �̴Ͼ�(��� �̴Ͼ� ���� ����) óġ ��
    public int totalAllyJungleMinionsKilled;  // �Ʊ� ���� ���� óġ ��
    public int totalEnemyJungleMinionsKilled; // �� ���� ���� óġ ��
    public int largestCriticalStrike;         // �ִ� ġ��Ÿ
    public int timePlayed;                    // �÷��� �ð� (��)
    public int longestTimeSpentLiving;        // ���� ���� �ð�
    public int timeCCingOthers;               // ���� ���� ���� �ð�
    public int totalTimeCCDealt;              // ���� ���� ���� �ð�
    public int totalTimeSpentDead;            // ������� ���� �ð�
    public Perks perks;                       // �� ����
    public int spell1Casts;                   // q ��� Ƚ��
    public int spell2Casts;                   // w ��� Ƚ��
    public int spell3Casts;                   // e ��� Ƚ��
    public int spell4Casts;                   // r ��� Ƚ��
    public int summoner1Casts;                // ��ȯ�� �ֹ�1 ��� Ƚ��
    public int summoner1Id;                   // ��ȯ�� �ֹ�1 ID
    public int summoner2Casts;                // ��ȯ�� �ֹ�2 ��� Ƚ��
    public int summoner2Id;                   // ��ȯ�� �ֹ�2 ID
    public Challenges challenges;             // �÷��̾� ����(�� ���)
    //���, ������
    public int goldEarned;                    // ȹ�� ���
    public int goldSpent;                     // ��� ���
    public int item0;                         // ��� ���� 0
    public int item1;                         // ��� ���� 1
    public int item2;                         // ��� ���� 2
    public int item3;                         // ��� ���� 3
    public int item4;                         // ��� ���� 4
    public int item5;                         // ��� ���� 5
    public int item6;                         // ��� ���� 6 (��ű�)
    public int itemsPurchased;                // �� ���� ������ ��
    public int consumablesPurchased;          // �Һ� ������ ���� Ƚ��
    
    // ��
    public int allInPings;                    // ����� �Ѱ��� �� Ƚ��
    public int assistMePings;                 // ����� ���� �� Ƚ��
    public int basicPings;                    // ����� �⺻ �� Ƚ��
    public int commandPings;                  // ����� ��� �� Ƚ��
    public int dangerPings;                   // ����� ���� �� Ƚ��
    public int enemyMissingPings;             // ����� �� ���� �� Ƚ��
    public int enemyVisionPings;              // ����� �͵� �߰� �� Ƚ��
    public int getBackPings;                  // ����� ���� �� Ƚ��
    public int holdPings;                     // ����� ��� ��û �� Ƚ��
    public int needVisionPings;               // ����� �þ� ��û �� Ƚ��
    public int onMyWayPings;                  // ����� �̵� �� Ƚ��
    public int pushPings;                     // ����� push �� Ƚ��
    public int visionClearedPings;            // ����� �þ� ���� ��û �� Ƚ��
    public int retreatPings;                  // ����� ���� ��û �� Ƚ��
    
    //���ط�, ȸ����, ���� ���ط�, �氨�� ���ط�
    public int totalDamageDealt;              // �� ���ط�
    public int totalDamageDealtToChampions;   // è�Ǿ𿡰� ���� �� ���ط�
    public int totalDamageTaken;              // ���� ���ط�
    public int damageSelfMitigated;           // �氨�� ���ط�
    public int totalHeal;                     // �� ȸ����
    public int totalDamageShieldedOnTeammates;// �Ʊ� ��ȣ�� �� �����
    public int totalHealsOnTeammates;         // �Ʊ� ȸ����
    public int totalUnitsHealed;              // ȸ���� ���� ��?
    public int physicalDamageDealt;           // ���� ���� ���ط�
    public int physicalDamageDealtToChampions;// è�Ǿ𿡰� ���� ���� ���ط�
    public int physicalDamageTaken;           // ���� ���� ���ط�
    public int magicDamageDealt;              // ���� ���� ���ط�
    public int magicDamageDealtToChampions;   // è�Ǿ𿡰� ���� ���� ���ط�
    public int magicDamageTaken;              // �� ���� ���� ���ط�
    public int trueDamageDealt;               // �� ���� ���ط�
    public int trueDamageDealtToChampions;    // è�Ǿ𿡰� ���� ���� ���ط�
    public int trueDamageTaken;               // ���� ���� ���ط�
    public int damageDealtToBuildings;        // �������� ���� ���ط�
    public int damageDealtToTurrets;          // ��ž�� ���� ���ط�
    public int damageDealtToObjectives;       // ������Ʈ�� ���� ���ط�

    //������Ʈ, ������
    public boolean firstBloodAssist;          // ù ų ��ý�Ʈ ����
    public boolean firstBloodKill;            // ù ų ����
    public boolean firstTowerAssist;          // ù ��ž ��ý�Ʈ ����
    public boolean firstTowerKill;            // ù ��ž �ı� ����
    public int objectivesStolen;              // ������Ʈ ��ƿ ��
    public int objectivesStolenAssists;       // ������Ʈ ��ƿ ��ý�Ʈ ��
    public int turretKills;                   // ��ž óġ ��
    public int turretTakedowns;               // ��ž �ı�����
    public int turretsLost;                   // ���� ��ž ��
    public int baronKills;                    // �ٷ� óġ Ƚ��
    public int dragonKills;                   // �巡�� óġ ��
    public int inhibitorKills;                // ������ �ı� ��
    public int inhibitorTakedowns;            // ������ �ı�����
    public int inhibitorsLost;                // ���� ������ ��
    public int nexusKills;                    // �ؼ��� �ı� ��
    public int nexusLost;                     // ���� �ؼ��� ��
    public int nexusTakedowns;                // �ؼ��� �ı�����
    
    //�þ�
    public int visionScore;                   // �þ� ����
    public int detectorWardsPlaced;           // ���� �͵� ��ġ ��
    public int visionWardsBoughtInGame;       // ���� �͵� ���� ��
    public int wardsPlaced;                   // �͵� ��ġ ��
    public int wardsKilled;                   // �͵� ���� ��
    public int sightWardsBoughtInGame;        // �þ߿� �͵� ���� ��(���� �͵� ���ϴ� �� ����)
    
    //��
    public int teamId;                        // �� ID(���:100, ����:200)
    public boolean gameEndedInEarlySurrender; // ���� �׺����� ���� ����
    public boolean gameEndedInSurrender;      // �׺����� ���� ����
    public boolean teamEarlySurrendered;      // �� ���� �׺� ����
    public boolean win;                       // �¸� ����
    
    //�뵵 �Ҹ�
    public int PlayerScore0;                  // �÷��̾� ���� 0?
    public int PlayerScore1;                  // �÷��̾� ���� 1?
    public int PlayerScore2;                  // �÷��̾� ���� 2?
    public int PlayerScore3;                  // �÷��̾� ���� 3?
    public int PlayerScore4;                  // �÷��̾� ���� 4?
    public int PlayerScore5;                  // �÷��̾� ���� 5?
    public int PlayerScore6;                  // �÷��̾� ���� 6?
    public int PlayerScore7;                  // �÷��̾� ���� 7?
    public int PlayerScore8;                  // �÷��̾� ���� 8?
    public int PlayerScore9;                  // �÷��̾� ���� 9?
    public int PlayerScore10;                 // �÷��̾� ���� 10?
    public int PlayerScore11;                 // �÷��̾� ���� 11?
    public boolean eligibleForProgression;    // ���α׷��� ���� ���� ����?
    public int subteamPlacement;              // ������ ����?
    public int placement;                     // ��� ����?
    public int playerAugment1;                // �÷��̾� ���� �ɷ�ġ 1?
    public int playerAugment2;                // �÷��̾� ���� �ɷ�ġ 2?
    public int playerAugment3;                // �÷��̾� ���� �ɷ�ġ 3?
    public int playerAugment4;                // �÷��̾� ���� �ɷ�ġ 4?
    public int playerAugment5;                // �÷��̾� ���� �ɷ�ġ 5?
    public int playerAugment6;                // �÷��̾� ���� �ɷ�ġ 6?
    public int playerSubteamId;               // ���� �� ID?
    public Missions missions;                 // �̼� ����?
    public String summonerName;               // ��ȯ�� �̸�?
}

