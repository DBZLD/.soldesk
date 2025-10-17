package com.spring.service;

public interface MatchInfosService {
	public TFTRecordProcessor getMIP(String playerId, String playerTag);
	public TFTApiProcessor getTAP(String version);
}
