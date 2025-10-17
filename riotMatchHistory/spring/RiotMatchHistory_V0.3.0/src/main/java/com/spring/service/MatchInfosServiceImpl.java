package com.spring.service;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MatchInfosServiceImpl implements MatchInfosService {

	// 플레이어 id, tag를 받아오고 id, tag를 매개변수로 하는 TFTRecordProcessor를 반환함
	@Override
	public TFTRecordProcessor getTRP(String playerId, String playerTag) {
		TFTRecordProcessor trp = new TFTRecordProcessor(playerId, playerTag);
		return trp;
	}

	// version을 받아오고 version을 매개변수로 하는 TFTApiProcessor를 반환함
	@Override
	public TFTApiProcessor getTAP(String version) {
		TFTApiProcessor tap = new TFTApiProcessor(version);
		return tap;
	}

	// 플레이어 id, tag를 받아오고 id, tag를 매개변수로 하는 LOLRecordProcessor를 반환함
	@Override
	public LOLRecordProcessor getLRP(String playerId, String playerTag) {
		LOLRecordProcessor trp = new LOLRecordProcessor(playerId, playerTag);
		return trp;
	}

	// version을 받아오고 version을 매개변수로 하는 LOLApiProcessor를 반환함
	@Override
	public LOLApiProcessor getLAP(String version) {
		LOLApiProcessor tap = new LOLApiProcessor(version);
		return tap;
	}
}
