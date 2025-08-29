package com.spring.dto.tft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.util.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TFTTactician {
	public String id;	//전설이 아이디
	public String tier;	//전설이 등급
	public String name;	//전설이 이름
	public Image image;	//전설이 이미지
}
