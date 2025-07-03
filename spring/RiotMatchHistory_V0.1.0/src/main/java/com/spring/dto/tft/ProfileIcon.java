package com.spring.dto.tft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.service.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileIcon {
	public int id;
	public Image image;
}
