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
		TFTItem item = new TFTItem();
		for (Map.Entry<String, TFTItem> entry : tap.item.data.entrySet()) { 
			//엑소코어,이벤트 아이템 등은 map의 key값 앞에 tft???/가 붙어있어 itemName이 포함된 목록으로 찾음
			if (entry.getKey().equals(itemName) || entry.getKey().endsWith("/"+itemName)) {
				item = entry.getValue();
				break;
			}
		}
		name = item.name;
		full = item.image.full;
		group = item.image.group;
		imgURL = tap.getImgURL(group, full);
	}
}
