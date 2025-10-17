package com.spring.dto.lol;

import lombok.Data;

@Data
public class ViewFeats {
	private Integer state;
	
	public ViewFeats(FeatState feats) {
		this.state = feats.featState;
	}

}
