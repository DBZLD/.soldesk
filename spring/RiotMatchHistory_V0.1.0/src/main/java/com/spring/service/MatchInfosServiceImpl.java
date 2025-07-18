package com.spring.service;

import org.springframework.stereotype.Service;

import com.spring.util.Common;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MatchInfosServiceImpl implements MatchInfosService{
	
	@Override
	public TFTRecordProcessor getMIP(String playerId, String playerTag) {
		TFTRecordProcessor mip = new TFTRecordProcessor(playerId, playerTag);
		return mip;
	}
	@Override
	public TFTApiProcessor getTAP() {
		TFTApiProcessor tap = new TFTApiProcessor(Common.LATEST_VERSIONS);
		return tap;
	}
}
