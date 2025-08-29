package com.spring.dto.tft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.util.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TFTTrait {
	public String id;	//Ư�� ���̵�
	public String name;	//Ư�� �̸�
	public Image image;	//Ư�� �̹���
}
