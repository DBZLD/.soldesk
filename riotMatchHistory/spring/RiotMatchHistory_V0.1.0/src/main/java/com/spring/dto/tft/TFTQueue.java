package com.spring.dto.tft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.util.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TFTQueue {
	public String id;
	public String name;
	public String queueType;
	public Image image;
}
