package com.spring.dto.tft;

import java.util.HashMap;
import java.util.Map;

public class TFTTraitDto {
	public String type;		//정보 타입
	public String version;	//정보 버전
	public Map<String, TFTTrait> data = new HashMap<>();	//특성 정보 맵
}
