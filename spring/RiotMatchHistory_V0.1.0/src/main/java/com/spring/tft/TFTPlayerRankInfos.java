package com.spring.tft;

import com.spring.dto.tft.RankDto;
import com.spring.service.TFTApiProcessor;

public class TFTPlayerRankInfos {
	public TFTPlayerRankInfo RANKED_TFT;
	public TFTPlayerRankInfo RANKED_TFT_DOUBLE_UP;
	public TFTPlayerRankInfo RANKED_TFT_TURBO;
	
	public TFTPlayerRankInfos(RankDto rank, RankDto doubleUp, RankDto turbo, TFTApiProcessor tap) {
		RANKED_TFT = new TFTPlayerRankInfo(rank, tap);
		RANKED_TFT_DOUBLE_UP = new TFTPlayerRankInfo(doubleUp, tap);
		RANKED_TFT_TURBO = new TFTPlayerRankInfo(turbo, tap);
	}
	public TFTPlayerRankInfos() {
	}
}
