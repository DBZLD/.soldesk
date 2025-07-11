package com.spring.dto.tft;

import java.util.HashMap;
import java.util.Map;

public class TFTChampionDto {
	public String type;
	public String version;
	public Map<String, TFTUnit> data = new HashMap<>();
}
