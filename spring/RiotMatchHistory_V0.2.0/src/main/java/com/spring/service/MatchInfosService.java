package com.spring.service;

public interface MatchInfosService {
	// 플레이어 id, tag를 받아오고 플레이어 정보 api를 받아온 후 재가공한 JSON 데이터를 모은 TFTRecordProcessor를 반환
	public TFTRecordProcessor getTRP(String playerId, String playerTag);
	
	//버전을 받아오고 라이엇 api를 받아온 후 재가공한 JSON 데이터를 모은 TFTApiProcessor를 반환
	public TFTApiProcessor getTAP(String version);
}
