package com.spring.dto.tft;

import java.util.HashMap;
import java.util.Map;

public class TFTUnitDto {
	public String type;		//���� Ÿ��
	public String version;	//���� ����
	public Map<String, TFTUnit> data = new HashMap<>();	//���� ���� ��
}
