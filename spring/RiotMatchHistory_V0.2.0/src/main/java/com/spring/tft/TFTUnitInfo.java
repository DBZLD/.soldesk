package com.spring.tft;

import java.util.ArrayList;
import java.util.Map;

import com.spring.dto.tft.TFTChampion;
import com.spring.dto.tft.Unit;
import com.spring.service.TFTApiProcessor;

import lombok.extern.log4j.Log4j;
@Log4j
public class TFTUnitInfo {
	public String name;		//���� �̸�
	public Integer rarity;	//���� ��͵�
	public Integer tier;	//���� �� ��
	public String full;		//���� �̹���
	public String group;	//���� �̹��� ����
	public String imgURL;	//���� �̹��� ��ũ
	public ArrayList<TFTItemInfo> itemList = new ArrayList<>();	//������ ������ ������ �迭

	//unit, tap �� �޾ƿͼ� ����, ���� �� �����ϴ� ������ �Լ�
	public TFTUnitInfo(Unit unit, TFTApiProcessor tap) {
		//�� TFTChampion ����
		TFTChampion units = new TFTChampion();
		//tap.unit.data�� ���� ���� key,value ���¸� ��ȯ
		for (Map.Entry<String, TFTChampion> entry : tap.unit.data.entrySet()) { 
			//���� map�� key�� �տ� maps/shipping~~/�� �پ��־� unit.character_id�� ���Ե� ������ ã��
			if (entry.getKey().toLowerCase().contains(unit.character_id.toLowerCase())) {
				//units�� entry�� value���� �Ҵ�
				units = entry.getValue();
				break;
			}
		}
		//name�� units.name�� �Ҵ�
		name = units.name;
		//full�� units.full�� �Ҵ�
		full = units.image.full;
		//group�� units.group�� �Ҵ�
		group = units.image.group;
		//imgURL�� tap���� ��ȯ�� �̹���URL�� �Ҵ�
		imgURL = tap.getImgURL(group, full);
		//rarity�� unit.rarity�� �Ҵ�
		rarity = unit.rarity;
		//tier�� unit.tier�� �Ҵ�
		tier = unit.tier;
		//unit.itemNames�� ������� ���� �� imageList�� itemName, tap�� �־� ���� TFTItemInfo �߰�
		if (unit.itemNames.size() != 0) {
			for (String itemName : unit.itemNames) {
				itemList.add(new TFTItemInfo(itemName, tap));
			}
		}
	}
}
