package com.spring.dto.tft;

import java.util.HashMap;
import java.util.Map;


public class TFTTacticianDto {
	public String type;		//���� Ÿ��
	public String version;	//���� ����
	public Map<String, TFTTactician> data = new HashMap<>();	//������ ���� ��
}
