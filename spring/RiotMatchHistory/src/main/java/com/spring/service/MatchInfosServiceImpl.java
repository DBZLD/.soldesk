package com.spring.service;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MatchInfosServiceImpl implements MatchInfosService{
	
	@Override
	public HistoryInfosProcessor getMIP(String playerId, String playerTag) {
		HistoryInfosProcessor mip = new HistoryInfosProcessor(playerId, playerTag);
		return mip;
	}
}
