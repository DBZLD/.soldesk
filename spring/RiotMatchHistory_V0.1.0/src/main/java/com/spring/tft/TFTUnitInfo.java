package com.spring.tft;

import java.util.ArrayList;

import com.spring.dto.tft.Unit;
import com.spring.service.TFTApiProcessor;

import lombok.extern.log4j.Log4j;
@Log4j
public class TFTUnitInfo {
	public String name;
	public Integer rarity;
	public Integer tier;
	public ArrayList<TFTItemInfo> itemList = new ArrayList<>();

	public TFTUnitInfo(Unit unit, TFTApiProcessor tap) {
		name = unit.character_id;
		rarity = unit.rarity;
		tier = unit.tier;
		if (unit.itemNames.size() != 0) {
			for (String itemName : unit.itemNames) {
				itemList.add(new TFTItemInfo(itemName, tap));
			}
		}
	}
}
