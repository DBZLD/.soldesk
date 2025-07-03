package com.spring.dto.tft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.service.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TFTItem {
	public String id;
    public String name;
    public Image image;
}
