package com.spring.dto.tft;

import java.util.HashMap;
import java.util.Map;


public class TFTTacticianDto {
	public String type;		//정보 타입
	public String version;	//정보 버전
	public Map<String, TFTTactician> data = new HashMap<>();	//전설이 정보 맵
}
