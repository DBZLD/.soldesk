package com.spring.dto.tft.regalia;

import java.util.ArrayList;

public class RegaliaNameDto {
	public ArrayList<Regalia> regalia = new ArrayList<Regalia>();
	
	public RegaliaNameDto() {
		regalia.add(new Regalia("�����", "BRONZE"));
		regalia.add(new Regalia("ç����", "CHALLENGER"));
		regalia.add(new Regalia("���̾Ƹ��", "DIAMOND"));
		regalia.add(new Regalia("���޶���", "EMERALD"));
		regalia.add(new Regalia("���", "GOLD"));
		regalia.add(new Regalia("�׷��帶����", "GRANDMASTER"));
		regalia.add(new Regalia("���̾�", "IRON"));
		regalia.add(new Regalia("������", "MASTER"));
		regalia.add(new Regalia("�÷�Ƽ��", "PLATINUM"));
		regalia.add(new Regalia("���� ����", "PROVISIONS"));
		regalia.add(new Regalia("�ǹ�", "SILVER"));
	}
	
}
