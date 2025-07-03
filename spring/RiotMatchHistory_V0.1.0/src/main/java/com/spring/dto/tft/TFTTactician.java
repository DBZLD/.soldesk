package com.spring.dto.tft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.service.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TFTTactician {
	public String id;
	public String tier;
	public String name;
	public Image image;
}
