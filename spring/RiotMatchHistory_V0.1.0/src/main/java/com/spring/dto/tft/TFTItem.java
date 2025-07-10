package com.spring.dto.tft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.util.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TFTItem {
	public String id;
    public String name;
    public Image image = new Image();
    
    public TFTItem(String id, String name, String full, String group) {
    	this.id = id;
    	this.name = name;
    	this.image.full = full;
    	this.image.group = group;
    }
	public TFTItem() {
	}    
}
