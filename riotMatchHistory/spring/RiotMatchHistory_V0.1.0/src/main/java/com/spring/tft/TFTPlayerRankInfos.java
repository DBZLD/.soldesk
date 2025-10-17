package com.spring.tft;

import com.spring.dto.tft.RankDto;
import com.spring.service.TFTApiProcessor;

public class TFTPlayerRankInfos {
	public TFTPlayerRankInfo rank;
	public TFTPlayerRankInfo doubleUp;
	public TFTPlayerRankInfo turbo;
	
	public TFTPlayerRankInfos(RankDto rank, RankDto doubleUp, RankDto turbo, TFTApiProcessor tap) {
		this.rank = new TFTPlayerRankInfo(rank, tap);
		this.doubleUp = new TFTPlayerRankInfo(doubleUp, tap);
		this.turbo = new TFTPlayerRankInfo(turbo, tap);
	}
	public TFTPlayerRankInfos() {
	}
}
