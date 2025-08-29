package com.spring.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileIconDto {
	public String type;										//데이터 종류
	public String version;									//데이터 버전
	public Map<String, ProfileIcon> data = new HashMap<>(); //데이터 MAP
}
