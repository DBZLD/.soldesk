package com.spring.dto.tft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.util.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TFTQueue {
	public String id;		 //매치 타입 아이디
	public String name;		 //매치 이름
	public String queueType; //매치 타입
	public Image image;		 //매치 이미지
}
