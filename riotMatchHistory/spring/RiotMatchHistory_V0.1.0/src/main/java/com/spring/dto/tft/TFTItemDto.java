package com.spring.dto.tft;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TFTItemDto {
	public String type;
    public String version;
    public Map<String, TFTItem> data = new HashMap<>();
}
