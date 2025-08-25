package com.spring.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {
    public String full;		//이미지 이름
    public String sprite;	//스프라이트 이름
    public String group;	//이미지 종류
    public int x;			//스프라이트 x 위치
    public int y;			//스프라이트 y 위치
    public int w;			//스프라이트 너비
    public int h;			////스프라이트 높이
}