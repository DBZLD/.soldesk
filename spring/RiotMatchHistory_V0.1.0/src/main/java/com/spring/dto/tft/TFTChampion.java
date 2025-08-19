package com.spring.dto.tft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.util.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TFTChampion {
	public String id;
	public String name;
	public int tier;
	public Image image;
	public TFTChampion(String id, String name, int tier, String full) {
		this.id = id;
		this.name = name;
		this.tier = tier;
		this.image = new Image();
		this.image.full = full;
	}
	public TFTChampion() {
	}
}
