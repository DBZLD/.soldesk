package com.spring.dto.tft;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.util.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TFTQueue {
	public String id;		 //��ġ Ÿ�� ���̵�
	public String name;		 //��ġ �̸�
	public String queueType; //��ġ Ÿ��
	public Image image;		 //��ġ �̹���
}
