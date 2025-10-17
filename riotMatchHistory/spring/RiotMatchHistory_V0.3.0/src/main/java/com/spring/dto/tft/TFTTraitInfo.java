package com.spring.dto.tft;

import com.spring.service.TFTApiProcessor;

public class TFTTraitInfo {
	public String name;		//Ư�� �̸�
	public Integer style;	//Ư�� �ܰ�
	public String full;		//Ư�� �̹���
	public String group;	//Ư�� �̹��� ����
	public String imgURL;	//Ư�� �̹��� ��ũ

	//trait, tap�� �޾ƿͼ� ����, ���� �� �����ϴ� ������ �Լ�
	public TFTTraitInfo(Trait trait, TFTApiProcessor tap) {
		//name�� trait.name�� key���� ��ġ�ϴ� tap.trait.data.name�� ���� �Ҵ�
		name = tap.trait.data.get(trait.name).name;
		//style�� trait.style �Ҵ�
		style = trait.style;
		//full�� trait.name�� key���� ��ġ�ϴ� tap.trait.data.full�� ���� �Ҵ�
		full = tap.trait.data.get(trait.name).image.full;
		//group�� trait.name�� key���� ��ġ�ϴ� tap.trait.data.group�� ���� �Ҵ�
		group = tap.trait.data.get(trait.name).image.group;
		//imgURL�� tap���� ��ȯ�� �̹���URL�� �Ҵ�
		imgURL = tap.getImgURL(group, full);
	}
}
