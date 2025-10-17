package com.spring.dto.tft;

import java.util.HashMap;
import java.util.Map;

public class TFTQueueDto {
	public String type;
	public String version;
	public Map<String, TFTQueue> data = new HashMap<>();
}
