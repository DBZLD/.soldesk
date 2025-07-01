package com.spring.dto.tft.regalia;

import java.util.ArrayList;

public class RegaliaNameDto {
	public ArrayList<Regalia> regalia = new ArrayList<Regalia>();
	
	public RegaliaNameDto() {
		regalia.add(new Regalia("브론즈", "BRONZE"));
		regalia.add(new Regalia("챌린저", "CHALLENGER"));
		regalia.add(new Regalia("다이아몬드", "DIAMOND"));
		regalia.add(new Regalia("에메랄드", "EMERALD"));
		regalia.add(new Regalia("골드", "GOLD"));
		regalia.add(new Regalia("그랜드마스터", "GRANDMASTER"));
		regalia.add(new Regalia("아이언", "IRON"));
		regalia.add(new Regalia("마스터", "MASTER"));
		regalia.add(new Regalia("플레티넘", "PLATINUM"));
		regalia.add(new Regalia("전적 없음", "PROVISIONS"));
		regalia.add(new Regalia("실버", "SILVER"));
	}
	
}
