package com.spring.tft;

import com.spring.dto.tft.RankDto;
import com.spring.service.TFTApiProcessor;
import com.spring.util.Common;

import lombok.extern.log4j.Log4j;

@Log4j
public class TFTPlayerRankInfo {
	public String type;		//랭크 타입
	public String tier;		//랭크 티어(다이아몬드)
	public String rank;		//랭크 수(1,2)
	public int point;		//랭크 점수(LP)
	public int win;			//승 수
	public int lose;		//패 수
	public String full;		//랭크 이미지
	public String group;	//랭크 이미지 종류
	public String imgURL;	//랭크 이미지 링크

	//rankDto, tap을 받아와서 번역, 정리 후 저장하는 생성자 함수
	public TFTPlayerRankInfo(RankDto rankDto, TFTApiProcessor tap) {
		//type에 rankDto.queueType을 할당
		type = rankDto.queueType;
		//랭크 타입이 turbo인지 여부를 판단해서 isTurbo에 할당
		boolean isTurbo = Common.TFT_TURBO.equals(type);
		//tier에 삼항연산자로 isTurbo가 true일때 ratedTier의, false일때 tier의 값을 할당 
		tier = isTurbo ? rankDto.ratedTier : rankDto.tier;
		//tier의 값이 랭크 없음인지 여부를 판단해서 isUnrated에 할당
		boolean isUnrated = Common.UNRATED.equals(tier);
		//tier의 값을 첫 글자 대문자,이외 글자 소문자로 변환
		tier = tier.substring(0, 1).toUpperCase() + tier.substring(1).toLowerCase();

		//full에 tier의 값과 key값이 일치하는 value.image.full 값을 할당
		full = tap.regalia.tier.get(tier).image.full;
		//group에 tier의 값과 key값이 일치하는 value.image.group 값을 할당
		group = tap.regalia.tier.get(tier).image.group;
		//tap에서 변환한 이미지URL값을 imgURL에 할당
		imgURL = tap.getRegaliaImg(full, group);
		
		//isUnrated가 false일때만 rank, point, win, lose값을 할당함
		if (!isUnrated) {
			//rank에 삼항연산자로 isTurbo가 true일때 ratedRating의, false일때 rank의 값을 할당
			rank = isTurbo ? Integer.toString(rankDto.ratedRating) : rankDto.rank;
			//point에 삼항연산자로 isTurbo가 true일때 0을, false일때 leaguePoints의 값을 할당
			point = isTurbo ? 0 : rankDto.leaguePoints;
			//win에 rankDto.wins의 값을 할당
			win = rankDto.wins;
			//lose에 rankDto.losses의 값을 할당
			lose = rankDto.losses;
		}
		//type의 값을 tap에서 번역시켜 할당
		type = tap.transQueueType(type);
		//tier의 값을 tap에서 변역시켜 할당
		tier = tap.regalia.tier.get(tier).name;
		//rank의 값을 tap에서 변환시켜 할당
		if (rank != null) {
			rank = tap.transRankNum(rank);
		}
	}
}
