package com.spring.dto.tft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.util.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TFTItem {
	public String id;					//아이템 아이디
    public String name;					//아이템 이름
    public Image image = new Image();	//아이템 이미지
    
    //id, name, full, group을 받아와서 설정하는 생성자 함수
    public TFTItem(String id, String name, String full, String group) {
    	this.id = id;
    	this.name = name;
    	this.image.full = full;
    	this.image.group = group;
    }
	public TFTItem() {
	}    
}
