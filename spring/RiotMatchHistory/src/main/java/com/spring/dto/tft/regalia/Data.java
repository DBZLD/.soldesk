package com.spring.dto.tft.regalia;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
	@JsonProperty("RANKED_TFT")
	RankTFT rankTFT;
	
	@JsonProperty("RANKED_TFT_DOUBLE_UP")
	RankDoubleUp rankDoubleUp;
	
	@JsonProperty("RANKED_TFT_TURBO")
	RankTurbo rankTurbo;
}
