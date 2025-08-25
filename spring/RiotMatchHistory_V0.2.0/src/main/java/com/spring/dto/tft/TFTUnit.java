package com.spring.dto.tft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.util.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TFTUnit {
	public String id;	//è�Ǿ� ���̵�
	public String name;	//è�Ǿ� �̸�
	public int tier;	//è�Ǿ� ��͵�
	public Image image;	//è�Ǿ� �̹���
	
	//id, name, tier, full�� �޾ƿͼ� �����ϴ� ������ �Լ�
	public TFTUnit(String id, String name, int tier, String full) {
		this.id = id;
		this.name = name;
		this.tier = tier;
		this.image = new Image();
		this.image.full = full;
	}
	//�⺻ ������ �Լ�
	public TFTUnit() {
	}
}
