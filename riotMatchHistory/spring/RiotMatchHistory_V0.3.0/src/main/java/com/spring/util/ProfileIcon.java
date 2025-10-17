package com.spring.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileIcon {
	public int id;		//아이콘 아이디
	public Image image;	//아이콘 이미지
}
