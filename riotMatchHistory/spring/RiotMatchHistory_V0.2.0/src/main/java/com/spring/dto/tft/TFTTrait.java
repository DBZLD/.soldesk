package com.spring.dto.tft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.util.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TFTTrait {
	public String id;	//특성 아이디
	public String name;	//특성 이름
	public Image image;	//특성 이미지
}
