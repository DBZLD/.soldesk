package com.spring.dto.lol;

import lombok.Data;

@Data
public class ViewPerks {
	private Perks perks;
	
	public ViewPerks(Perks perks) {
		this.perks = perks;
	}
}
