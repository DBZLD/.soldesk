package com.spring.dto.tft;

import java.util.HashMap;
import java.util.Map;

public class TFTQueueDto {
	public String type;		//정보 타입
	public String version;	//정보 버전
	public Map<String, TFTQueue> data = new HashMap<>(); //매치 정보 맵
}
