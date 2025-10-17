package com.spring.dto.tft.regalia;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
	@JsonProperty("RANKED_TFT")
	public RankTFT RANKED_TFT;
	
	@JsonProperty("RANKED_TFT_DOUBLE_UP")
	public RankTFTDoubleUp RANKED_TFT_DOUBLE_UP;
	
	@JsonProperty("RANKED_TFT_TURBO")
	public RankTFTTurbo RANKED_TFT_TURBO;
}
