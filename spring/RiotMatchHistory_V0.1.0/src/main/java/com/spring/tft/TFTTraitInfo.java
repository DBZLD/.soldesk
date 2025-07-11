package com.spring.tft;

import com.spring.dto.tft.Trait;
import com.spring.service.TFTApiProcessor;

public class TFTTraitInfo {
	public String name;
	public Integer style;
	public String full;
	public String group;
	public String imgURL;

	public TFTTraitInfo(Trait trait, TFTApiProcessor tap) {
		name = tap.trait.data.get(trait.name).name;
		style = trait.style;
		full = tap.trait.data.get(trait.name).image.full;
		group = tap.trait.data.get(trait.name).image.group;
		imgURL = tap.getImgURL(group, full);
	}
}
