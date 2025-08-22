package com.spring.tft;

import java.util.ArrayList;
import java.util.Map;

import com.spring.dto.tft.TFTChampion;
import com.spring.dto.tft.Unit;
import com.spring.service.TFTApiProcessor;

import lombok.extern.log4j.Log4j;
@Log4j
public class TFTUnitInfo {
	public String name;		//유닛 이름
	public Integer rarity;	//유닛 희귀도
	public Integer tier;	//유닛 성 수
	public String full;		//유닛 이미지
	public String group;	//유닛 이미지 종류
	public String imgURL;	//유닛 이미지 링크
	public ArrayList<TFTItemInfo> itemList = new ArrayList<>();	//유닛이 보유한 아이템 배열

	//unit, tap 을 받아와서 번역, 정리 후 저장하는 생성자 함수
	public TFTUnitInfo(Unit unit, TFTApiProcessor tap) {
		//빈 TFTChampion 생성
		TFTChampion units = new TFTChampion();
		//tap.unit.data를 전부 돌며 key,value 형태를 반환
		for (Map.Entry<String, TFTChampion> entry : tap.unit.data.entrySet()) { 
			//유닛 map의 key값 앞에 maps/shipping~~/가 붙어있어 unit.character_id가 포함된 변수를 찾음
			if (entry.getKey().toLowerCase().contains(unit.character_id.toLowerCase())) {
				//units에 entry의 value값을 할당
				units = entry.getValue();
				break;
			}
		}
		//name에 units.name을 할당
		name = units.name;
		//full에 units.full을 할당
		full = units.image.full;
		//group에 units.group을 할당
		group = units.image.group;
		//imgURL에 tap에서 변환한 이미지URL을 할당
		imgURL = tap.getImgURL(group, full);
		//rarity에 unit.rarity를 할당
		rarity = unit.rarity;
		//tier에 unit.tier를 할당
		tier = unit.tier;
		//unit.itemNames가 비어있지 않을 때 imageList에 itemName, tap을 넣어 만든 TFTItemInfo 추가
		if (unit.itemNames.size() != 0) {
			for (String itemName : unit.itemNames) {
				itemList.add(new TFTItemInfo(itemName, tap));
			}
		}
	}
}
