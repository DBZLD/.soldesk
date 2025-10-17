package com.spring.tft;

import com.spring.service.TFTApiProcessor;
import com.spring.util.ProfileDto;
import com.spring.util.PuuidDto;

public class TFTPlayerProfileInfo {
	public String puuid;		//플레이어 puuid
	public String name;			//플레이어 아이디
	public String tag;			//플레이어 태그
	public String level;		//플레이어 레벨
	public String iconFull;		//플레이어 아이콘 이미지
	public String iconGroup;	//플레이어 아이콘 이미지 종류
	public String iconURL;		//플레이어 아이콘 이미지 링크
	
	//profil, puuid, tap을 받아서 번역, 정리 후 저장하는 생성자 함수
	public TFTPlayerProfileInfo(ProfileDto profile, PuuidDto puuid, TFTApiProcessor tap) {
		//puuid에 puuid.puuid 할당
		this.puuid =  puuid.puuid;
		//name에 puuid.gameName 할당
		name = puuid.gameName;
		//tag에 puuid.tagLine 할당
		tag = puuid.tagLine;
		//level에 profile.summonerLevel 할당
		level = profile.summonerLevel;
		//iconFull에 profileIconId와 일치하는 key를 가진 tap.profileIcon.data.image.full을 할당
		iconFull = tap.profileIcon.data.get(profile.profileIconId).image.full;
		//iconGroup에 profileIconId와 일치하는 key를 가진 tap.profileIcon.data.image.group을 할당
		iconGroup = tap.profileIcon.data.get(profile.profileIconId).image.group;
		//iconURL에 tap에서 변환한 이미지URL을 할당
		iconURL = tap.getImgURL(iconGroup, iconFull);
	}
	//기본 생성자 함수
	public TFTPlayerProfileInfo() {
	}
}
