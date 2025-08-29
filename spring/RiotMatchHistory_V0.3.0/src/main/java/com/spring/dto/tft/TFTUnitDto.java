package com.spring.dto.tft;

import java.util.HashMap;
import java.util.Map;

public class TFTUnitDto {
	public String type;		//정보 타입
	public String version;	//정보 버전
	public Map<String, TFTUnit> data = new HashMap<>();	//유닛 정보 맵
}
