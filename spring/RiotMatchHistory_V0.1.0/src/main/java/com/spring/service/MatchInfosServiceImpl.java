package com.spring.service;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MatchInfosServiceImpl implements MatchInfosService{
	
	@Override
	public HisrotyInfosProcessor getMIP(String playerId, String playerTag) {
		HisrotyInfosProcessor mip = new HisrotyInfosProcessor(playerId, playerTag);
		return mip;
	}
}
