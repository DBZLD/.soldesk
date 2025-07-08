package com.spring.tft;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import com.spring.dto.tft.RankDto;
import com.spring.service.TFTApiProcessor;
import com.spring.util.Common;

public class TFTPlayerRankInfo {
	public String type;
	public String tier;
	public String rank;
	public int point;
	public int win;
	public int lose;
	public String full;
	public String group;
	public String imgURL;

	public TFTPlayerRankInfo(RankDto rank) {
		TFTApiProcessor tap = new TFTApiProcessor();
		boolean isTurbo = Common.TFT_TURBO.equals(rank.queueType);
		boolean isUnrated = isTurbo ? Common.UNRATED.equals(rank.ratedTier)
		                             : Common.UNRATED.equals(rank.tier);
		this.tier = isTurbo ? rank.ratedTier.substring(0, 1).toUpperCase() + rank.ratedTier.substring(1).toLowerCase(): 
			rank.tier.substring(0, 1).toUpperCase() + rank.tier.substring(1).toLowerCase();
		this.type = rank.queueType;
		this.full = isTurbo ? tap.regalia.data.RANKED_TFT_TURBO.get(this.tier).image.full :
			tap.regalia.data.RANKED_TFT.get(this.tier).image.full;
		this.group = isTurbo ? tap.regalia.data.RANKED_TFT_TURBO.get(this.tier).image.group :
			tap.regalia.data.RANKED_TFT.get(this.tier).image.group;
		this.imgURL = tap.getRegaliaImg(tier, type);
		if (!isUnrated) {
		    this.rank = isTurbo ? Integer.toString(rank.ratedRating) : rank.rank;
		    this.point = isTurbo ? 0 : rank.leaguePoints;
		    this.win = rank.wins;
		    this.lose = rank.losses;
		}
	}
}
