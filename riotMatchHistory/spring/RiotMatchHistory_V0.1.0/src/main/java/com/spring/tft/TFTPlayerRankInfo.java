package com.spring.tft;

import com.spring.dto.tft.RankDto;
import com.spring.service.TFTApiProcessor;
import com.spring.util.Common;

import lombok.extern.log4j.Log4j;

@Log4j
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

	public TFTPlayerRankInfo(RankDto rankDto, TFTApiProcessor tap) {
		type = rankDto.queueType;
		boolean isTurbo = Common.TFT_TURBO.equals(type);
		tier = isTurbo ? rankDto.ratedTier : rankDto.tier;
		boolean isUnrated = Common.UNRATED.equals(tier);
		tier = tier.substring(0, 1).toUpperCase() + tier.substring(1).toLowerCase();

		full = tap.regalia.tier.get(tier).image.full;
		group = tap.regalia.tier.get(tier).image.group;
		imgURL = tap.getRegaliaImg(full, group);
		if (!isUnrated) {
			rank = isTurbo ? Integer.toString(rankDto.ratedRating) : rankDto.rank;
			point = isTurbo ? 0 : rankDto.leaguePoints;
			win = rankDto.wins;
			lose = rankDto.losses;
		}
		// ¹ø¿ª
		type = tap.transQueueType(type);
		tier = tap.regalia.tier.get(tier).name;
		if (rank != null) {
			rank = tap.transRankNum(rank);
		}
	}
}
