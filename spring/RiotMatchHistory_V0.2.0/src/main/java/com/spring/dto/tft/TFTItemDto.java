package com.spring.dto.tft;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TFTItemDto {
	public String type;			//정보 타입
    public String version;		//정보 버전
    public Map<String, TFTItem> data = new HashMap<>();	//아이템 정보 맵
}
