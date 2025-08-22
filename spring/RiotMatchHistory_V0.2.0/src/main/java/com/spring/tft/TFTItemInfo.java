package com.spring.tft;

import java.util.Map;

import com.spring.dto.tft.TFTItem;
import com.spring.service.TFTApiProcessor;

import lombok.extern.log4j.Log4j;

@Log4j
public class TFTItemInfo {
	public String name;		//�����۸�
	public String full;		//������ �̹���
	public String group;	//������ �̹��� �з�
	public String imgURL;	//������ �̹��� ��ũ

	//itemName, tap�� �޾ƿͼ� ����, ���� �� �����ϴ� ������ �Լ�
	public TFTItemInfo(String itemName, TFTApiProcessor tap) {
		TFTItem item = new TFTItem();
		//tap.item.data ��ü�� ���鼭 key,value���¸� ������ ��
		for (Map.Entry<String, TFTItem> entry : tap.item.data.entrySet()) { 
			//�̺�Ʈ ������ ���� map�� key�� �տ� tft~~~/�� �پ��־� itemName�� ���Ե� ������� ã��
			if (entry.getKey().equals(itemName) || entry.getKey().endsWith("/"+itemName)) {
				//itemName�� �����ϰų� ��ġ�Ѵٸ� entry�� value���� item�� �Ҵ�
				item = entry.getValue();
				break;
			}
		}
		name = item.name;						//item.name�� name�� �Ҵ�
		full = item.image.full;					//item.image.full�� full�� �Ҵ�
		group = item.image.group;				//item.image.group�� group�� �Ҵ�
		imgURL = tap.getImgURL(group, full);	//tap���� group, full�� �̿��ؼ� �̹���URL �Ҵ�
	}
}
