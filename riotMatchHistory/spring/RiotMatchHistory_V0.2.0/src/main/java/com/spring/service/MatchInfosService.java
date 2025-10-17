package com.spring.service;

public interface MatchInfosService {
	// �÷��̾� id, tag�� �޾ƿ��� �÷��̾� ���� api�� �޾ƿ� �� �簡���� JSON �����͸� ���� TFTRecordProcessor�� ��ȯ
	public TFTRecordProcessor getTRP(String playerId, String playerTag);
	
	//������ �޾ƿ��� ���̾� api�� �޾ƿ� �� �簡���� JSON �����͸� ���� TFTApiProcessor�� ��ȯ
	public TFTApiProcessor getTAP(String version);
}
