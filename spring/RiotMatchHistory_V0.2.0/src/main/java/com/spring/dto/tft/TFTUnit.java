package com.spring.dto.tft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.util.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TFTUnit {
	public String id;	//챔피언 아이디
	public String name;	//챔피언 이름
	public int tier;	//챔피언 희귀도
	public Image image;	//챔피언 이미지
	
	//id, name, tier, full을 받아와서 저장하는 생성자 함수
	public TFTUnit(String id, String name, int tier, String full) {
		this.id = id;
		this.name = name;
		this.tier = tier;
		this.image = new Image();
		this.image.full = full;
	}
	//기본 생성자 함수
	public TFTUnit() {
	}
}
