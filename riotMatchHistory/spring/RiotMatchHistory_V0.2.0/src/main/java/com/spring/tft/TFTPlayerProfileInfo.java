package com.spring.tft;

import com.spring.service.TFTApiProcessor;
import com.spring.util.ProfileDto;
import com.spring.util.PuuidDto;

public class TFTPlayerProfileInfo {
	public String puuid;		//�÷��̾� puuid
	public String name;			//�÷��̾� ���̵�
	public String tag;			//�÷��̾� �±�
	public String level;		//�÷��̾� ����
	public String iconFull;		//�÷��̾� ������ �̹���
	public String iconGroup;	//�÷��̾� ������ �̹��� ����
	public String iconURL;		//�÷��̾� ������ �̹��� ��ũ
	
	//profil, puuid, tap�� �޾Ƽ� ����, ���� �� �����ϴ� ������ �Լ�
	public TFTPlayerProfileInfo(ProfileDto profile, PuuidDto puuid, TFTApiProcessor tap) {
		//puuid�� puuid.puuid �Ҵ�
		this.puuid =  puuid.puuid;
		//name�� puuid.gameName �Ҵ�
		name = puuid.gameName;
		//tag�� puuid.tagLine �Ҵ�
		tag = puuid.tagLine;
		//level�� profile.summonerLevel �Ҵ�
		level = profile.summonerLevel;
		//iconFull�� profileIconId�� ��ġ�ϴ� key�� ���� tap.profileIcon.data.image.full�� �Ҵ�
		iconFull = tap.profileIcon.data.get(profile.profileIconId).image.full;
		//iconGroup�� profileIconId�� ��ġ�ϴ� key�� ���� tap.profileIcon.data.image.group�� �Ҵ�
		iconGroup = tap.profileIcon.data.get(profile.profileIconId).image.group;
		//iconURL�� tap���� ��ȯ�� �̹���URL�� �Ҵ�
		iconURL = tap.getImgURL(iconGroup, iconFull);
	}
	//�⺻ ������ �Լ�
	public TFTPlayerProfileInfo() {
	}
}
