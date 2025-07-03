package com.spring.dto.tft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.service.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TFTRegalia {
	public Image image;
	public String name;
}
