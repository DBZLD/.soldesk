package com.spring.tft;

import com.spring.dto.tft.RankDto;

public class TFTPlayerRankInfos {
	public TFTPlayerRankInfo RANKED_TFT = new TFTPlayerRankInfo();
	public TFTPlayerRankInfo RANKED_TFT_DOUBLE_UP = new TFTPlayerRankInfo();
	public TFTPlayerRankInfo RANKED_TFT_TURBO = new TFTPlayerRankInfo();
	
	public TFTPlayerRankInfos(RankDto rank, RankDto doubleUp, RankDto turbo) {
		RANKED_TFT.tier = rank.tier;
		if(RANKED_TFT.tier != "Provisional") {
			RANKED_TFT.rank = rank.rank;
			RANKED_TFT.point = rank.leaguePoints;
			RANKED_TFT.win = rank.wins;
			RANKED_TFT.lose = rank.losses;			
		}
		
		RANKED_TFT_DOUBLE_UP.tier = doubleUp.tier;
		if(RANKED_TFT_DOUBLE_UP.tier != "Provisional") {
			RANKED_TFT_DOUBLE_UP.rank = doubleUp.rank;
			RANKED_TFT_DOUBLE_UP.point = doubleUp.leaguePoints;
			RANKED_TFT_DOUBLE_UP.win = doubleUp.wins;
			RANKED_TFT_DOUBLE_UP.lose = doubleUp.losses;			
		}
		
		RANKED_TFT_TURBO.tier = turbo.tier;
		if(RANKED_TFT_TURBO.tier != "Provisional") {
			RANKED_TFT_TURBO.rank = turbo.rank;
			RANKED_TFT_TURBO.point = turbo.leaguePoints;
			RANKED_TFT_TURBO.win = turbo.wins;
			RANKED_TFT_TURBO.lose = turbo.losses;			
		}
	}
	public TFTPlayerRankInfos() {
	}
}
