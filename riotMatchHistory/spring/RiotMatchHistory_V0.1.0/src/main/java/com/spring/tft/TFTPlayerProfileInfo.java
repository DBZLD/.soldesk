package com.spring.tft;

import com.spring.service.TFTApiProcessor;
import com.spring.util.ProfileDto;
import com.spring.util.PuuidDto;

public class TFTPlayerProfileInfo {
	public String puuid;
	public String name;
	public String tag;
	public String level;
	public String iconFull;
	public String iconGroup;
	public String iconURL;
	
	public TFTPlayerProfileInfo(ProfileDto profile, PuuidDto puuid, TFTApiProcessor tap) {
		this.puuid =  puuid.puuid;
		name = puuid.gameName;
		tag = puuid.tagLine;
		level = profile.summonerLevel;
		iconFull = tap.profileIcon.data.get(profile.profileIconId).image.full;
		iconGroup = tap.profileIcon.data.get(profile.profileIconId).image.group;
		iconURL = tap.getImgURL(iconGroup, iconFull);
	}
	public TFTPlayerProfileInfo() {
	}
}
