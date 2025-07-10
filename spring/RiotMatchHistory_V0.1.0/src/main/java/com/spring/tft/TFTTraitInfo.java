package com.spring.tft;

import com.spring.dto.tft.Trait;
import com.spring.service.TFTApiProcessor;

public class TFTTraitInfo {
	public String name;
	public Integer tier;
	public String full;
	public String group;
	public String imgURL;

	public TFTTraitInfo(Trait trait, TFTApiProcessor tap) {
		name = trait.name;
		tier = trait.tier_current;
		full = tap.trait.data.get(trait.name).image.full;
		group = tap.trait.data.get(trait.name).image.group;
		imgURL = tap.getImgURL(group, full);
	}
}
