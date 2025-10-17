package com.spring.service;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MatchInfosServiceImpl implements MatchInfosService{
	
	//�÷��̾� id, tag�� �޾ƿ��� id, tag�� �Ű������� �ϴ� TFTRecordProcessor�� ��ȯ��
	@Override
	public TFTRecordProcessor getTRP(String playerId, String playerTag) {
		TFTRecordProcessor trp = new TFTRecordProcessor(playerId, playerTag);
		return trp;
	}
	
	//version�� �޾ƿ��� version�� �Ű������� �ϴ� TFTApiProcessor�� ��ȯ��
	@Override
	public TFTApiProcessor getTAP(String version) {
		TFTApiProcessor tap = new TFTApiProcessor(version);
		return tap;
	}
}
