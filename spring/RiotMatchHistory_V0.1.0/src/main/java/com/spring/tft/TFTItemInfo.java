package com.spring.tft;

import java.util.Map;

import com.spring.dto.tft.TFTItem;
import com.spring.service.TFTApiProcessor;

import lombok.extern.log4j.Log4j;

@Log4j
public class TFTItemInfo {
	public String name;
	public String full;
	public String group;
	public String imgURL;

	public TFTItemInfo(String itemName, TFTApiProcessor tap) {
		name = itemName;
		TFTItem item = new TFTItem();
		for (Map.Entry<String, TFTItem> entry : tap.item.data.entrySet()) {
			if (entry.getKey().contains(name)) {
				item = entry.getValue();
				break;
			}
		}
		full = item.image.full;
		group = item.image.group;
		imgURL = tap.getImgURL(group, full);
	}
}
