package com.spring.dto.tft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.service.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TFTChampion {
	public String id;
	public String name;
	public int tier;
	public Image image;
}
