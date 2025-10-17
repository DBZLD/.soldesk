package com.spring.dto.tft;

import com.spring.service.TFTApiProcessor;

public class TFTPlayerRankInfos {
	public TFTPlayerRankInfo rank;		//랭크 정보
	public TFTPlayerRankInfo doubleUp;	//더블 업 정보
	public TFTPlayerRankInfo turbo;		//초고속 모드 정보
	
	//rank, doubleUp, turbo, tap을 받아와서 번역, 정리 후 저장하는 생성자 함수
	public TFTPlayerRankInfos(TFTRankDto rank, TFTRankDto doubleUp, TFTRankDto turbo, TFTApiProcessor tap) {
		//rank의 값을 rank, tap값을 넣은 TFTPlayerRankInfo로 할당
		this.rank = new TFTPlayerRankInfo(rank, tap);
		//doubleUp의 값을 doubleUp, tap값을 넣은 TFTPlayerRankInfo로 할당
		this.doubleUp = new TFTPlayerRankInfo(doubleUp, tap);
		//turbo의 값을 turbo, tap값을 넣은 TFTPlayerRankInfo로 할당
		this.turbo = new TFTPlayerRankInfo(turbo, tap);
	}
	
	//기본 생성자
	public TFTPlayerRankInfos() {
	}
}
