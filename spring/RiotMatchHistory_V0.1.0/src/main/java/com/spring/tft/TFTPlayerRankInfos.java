package com.spring.tft;

import com.spring.dto.tft.RankDto;

public class TFTPlayerRankInfos {
	public TFTPlayerRankInfo RANKED_TFT;
	public TFTPlayerRankInfo RANKED_TFT_DOUBLE_UP;
	public TFTPlayerRankInfo RANKED_TFT_TURBO;
	
	public TFTPlayerRankInfos(RankDto rank, RankDto doubleUp, RankDto turbo) {
		RANKED_TFT = new TFTPlayerRankInfo(rank);
		RANKED_TFT_DOUBLE_UP = new TFTPlayerRankInfo(doubleUp);
		RANKED_TFT_TURBO = new TFTPlayerRankInfo(turbo);
	}
	public TFTPlayerRankInfos() {
	}
}
