package com.spring.tft;

import java.util.ArrayList;
import java.util.Map;

import com.spring.dto.tft.TFTUnit;
import com.spring.dto.tft.Unit;
import com.spring.service.TFTApiProcessor;

import lombok.extern.log4j.Log4j;
@Log4j
public class TFTUnitInfo {
	public String name;
	public Integer rarity;
	public Integer tier;
	public String full;
	public String group;
	public String imgURL;
	public ArrayList<TFTItemInfo> itemList = new ArrayList<>();

	public TFTUnitInfo(Unit unit, TFTApiProcessor tap) {
		TFTUnit units = new TFTUnit();
		for (Map.Entry<String, TFTUnit> entry : tap.unit.data.entrySet()) { 
			//���� map�� key�� �տ� maps/shipping~~/�� �پ��־� unist.character_id�� ���Ե� ������ ã��
			if (entry.getKey().contains(unit.character_id)) {
				units = entry.getValue();
				break;
			}
		}
		name = units.name;
		full = units.image.full;
		group = units.image.group;
		imgURL = tap.getImgURL(group, full);
		rarity = unit.rarity;
		tier = unit.tier;
		if (unit.itemNames.size() != 0) {
			for (String itemName : unit.itemNames) {
				itemList.add(new TFTItemInfo(itemName, tap));
			}
		}
	}
}
