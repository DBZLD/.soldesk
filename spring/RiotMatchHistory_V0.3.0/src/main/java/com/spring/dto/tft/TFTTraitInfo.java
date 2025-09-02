package com.spring.dto.tft;

import com.spring.service.TFTApiProcessor;

public class TFTTraitInfo {
	public String name;		//특성 이름
	public Integer style;	//특성 단계
	public String full;		//특성 이미지
	public String group;	//특성 이미지 종류
	public String imgURL;	//특성 이미지 링크

	//trait, tap을 받아와서 번역, 정리 후 저장하는 생성자 함수
	public TFTTraitInfo(Trait trait, TFTApiProcessor tap) {
		//name에 trait.name과 key값이 일치하는 tap.trait.data.name의 값을 할당
		name = tap.trait.data.get(trait.name).name;
		//style에 trait.style 할당
		style = trait.style;
		//full에 trait.name과 key값이 일치하는 tap.trait.data.full의 값을 할당
		full = tap.trait.data.get(trait.name).image.full;
		//group에 trait.name과 key값이 일치하는 tap.trait.data.group의 값을 할당
		group = tap.trait.data.get(trait.name).image.group;
		//imgURL에 tap에서 변환한 이미지URL을 할당
		imgURL = tap.getImgURL(group, full);
	}
}
