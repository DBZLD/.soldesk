package com.spring.dto.lol;

import lombok.Data;

@Data
public class ViewItem {
	private Integer itemId;
	
	public ViewItem(Integer itemId) {
		this.itemId = itemId;
	}
}
