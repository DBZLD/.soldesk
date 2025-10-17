package com.spring.tft;

import java.util.Map;

import com.spring.dto.tft.TFTItem;
import com.spring.service.TFTApiProcessor;

import lombok.extern.log4j.Log4j;

@Log4j
public class TFTItemInfo {
	public String name;		//아이템명
	public String full;		//아이템 이미지
	public String group;	//아이템 이미지 분류
	public String imgURL;	//아이템 이미지 링크

	//itemName, tap을 받아와서 번역, 정리 후 저장하는 생성자 함수
	public TFTItemInfo(String itemName, TFTApiProcessor tap) {
		TFTItem item = new TFTItem();
		//tap.item.data 전체를 돌면서 key,value형태를 가지고 옴
		for (Map.Entry<String, TFTItem> entry : tap.item.data.entrySet()) { 
			//이벤트 아이템 등은 map의 key값 앞에 tft~~~/가 붙어있어 itemName이 포함된 목록으로 찾음
			if (entry.getKey().equals(itemName) || entry.getKey().endsWith("/"+itemName)) {
				//itemName을 포함하거나 일치한다면 entry의 value값을 item에 할당
				item = entry.getValue();
				break;
			}
		}
		name = item.name;						//item.name을 name에 할당
		full = item.image.full;					//item.image.full을 full에 할당
		group = item.image.group;				//item.image.group을 group에 할당
		imgURL = tap.getImgURL(group, full);	//tap에서 group, full을 이용해서 이미지URL 할당
	}
}
