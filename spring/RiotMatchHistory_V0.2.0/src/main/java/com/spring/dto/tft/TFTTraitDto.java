package com.spring.dto.tft;

import java.util.HashMap;
import java.util.Map;

public class TFTTraitDto {
	public String type;
	public String version;
	public Map<String, TFTTrait> data = new HashMap<>();
}
