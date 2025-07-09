package com.spring.tft;


import com.spring.dto.tft.RankDto;
import com.spring.dto.tft.TFTQueue;
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
		boolean isTurbo = Common.TFT_TURBO.equals(rankDto.queueType);
		boolean isUnrated = isTurbo ? Common.UNRATED.equals(rankDto.ratedTier)
		                             : Common.UNRATED.equals(rankDto.tier);
		
		type = rankDto.queueType;
		tier = isTurbo ? rankDto.ratedTier : rankDto.tier;
		tier = tier.substring(0, 1).toUpperCase() + tier.substring(1).toLowerCase();
		
		full = isTurbo && !isUnrated ? tap.regalia.data.RANKED_TFT_TURBO.get(tier).image.full :
			tap.regalia.data.RANKED_TFT.get(tier).image.full;
		group = isTurbo && !isUnrated ? tap.regalia.data.RANKED_TFT_TURBO.get(tier).image.group :
			tap.regalia.data.RANKED_TFT.get(tier).image.group;
		imgURL = tap.getRegaliaImg(full, group);
		if (!isUnrated) {
		    rank = isTurbo ? Integer.toString(rankDto.ratedRating) : rankDto.rank;
		    point = isTurbo ? 0 : rankDto.leaguePoints;
		    win = rankDto.wins;
		    lose = rankDto.losses;
		}
		//¹ø¿ª
		tier = isTurbo && !isUnrated ? tap.regalia.data.RANKED_TFT_TURBO.get(tier).name : 
			tap.regalia.data.RANKED_TFT.get(tier).name;
        for (TFTQueue info : tap.queue.data.values()) {
            if (type.equals(info.queueType)) {
                type = info.name;
            }
        }
	}
}
