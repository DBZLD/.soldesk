package com.spring.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import static java.util.Map.entry;

import org.springframework.web.client.RestTemplate;

import com.spring.dto.tft.TFTUnit;
import com.spring.dto.tft.TFTUnitDto;
import com.spring.dto.tft.TFTItemDto;
import com.spring.dto.tft.TFTQueue;
import com.spring.dto.tft.TFTQueueDto;
import com.spring.dto.tft.TFTRegalia;
import com.spring.dto.tft.TFTRegaliaDto;
import com.spring.dto.tft.TFTRegaliaInfoDto;
import com.spring.dto.tft.TFTTacticianDto;
import com.spring.dto.tft.TFTTraitDto;
import com.spring.util.Common;
import com.spring.util.ProfileIconDto;

import lombok.extern.log4j.Log4j;

@Log4j

public class TFTApiProcessor {	// ������ �´� ���̾� API�� �������� Ŭ����
	
	public String version;										// ���� ����
	public TFTQueueDto queue = new TFTQueueDto();				// ��ġ Ÿ�� ����, ���� API
	public TFTRegaliaInfoDto regalia = new TFTRegaliaInfoDto(); // Ƽ�� ����, ���� API
	public TFTTraitDto trait = new TFTTraitDto();				// Ư�� ����, ���� API
	public TFTUnitDto unit = new TFTUnitDto();					// ���� ����, ���� API
	public TFTItemDto item = new TFTItemDto();					// ������ ����, ���� API
	public TFTTacticianDto tactician = new TFTTacticianDto();	// ������(�÷��̾� ĳ����) ����, ���� API
	public ProfileIconDto profileIcon = new ProfileIconDto();	// ������ ������ ����, ���� API

	private Map<String, String> regaliaName = Map.ofEntries(	// key���� ��ġ�ϴ� Ƽ�� ���� map
			entry("Iron", "���̾�"),
			entry("Bronze", "�����"),
			entry("Silver", "�ǹ�"),
			entry("Gold", "���"),
			entry("Platinum", "�÷�Ƽ��"),
			entry("Emerald", "���޶���"),
			entry("Diamond", "���̾Ƹ��"),
			entry("Master", "������"),
			entry("Grandmaster", "�׷��帶����"),
			entry("Challenger", "ç����"),
			entry("Provisional", "��ũ ����"),
			entry("Blue", "���"),
			entry("Gray", "�׷���"),
			entry("Green", "�׸�"),
			entry("Orange", "������"),
			entry("Purple", "����")
		);
	
	// version�� �Ű� ������ �޴� ������ �Լ�
	public TFTApiProcessor(String version) {
		this.version = version;
		setQueue();				// queue ������ ����
		setRegalia();			// regalia ������ ����
		setTrait();				// trait ������ ����
		setUnit();				// unit ������ ����
		setItem();				// item ������ ����
		setTactician();			// tactician ������ ����
		setProfileIcon();		// profileIcon ������ ����
	}
	
	// full, group�� �޾Ƽ� �̹���URL�� ��ȯ�ϴ� �Լ�
	public String getRegaliaImg(String full, String group) {
		// version, group(�̹��� �з�), full(�̹��� �̸�.png)�� URL�� ��ħ
		String imgURL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/img/%s/%s",
				version, group, full);
		
		return imgURL;
	}
	
	// queue ������ �����ϴ� �Լ�
	public void setQueue() {
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-queues.json",
				version,Common.REGIONS);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			queue = restTemplate.getForObject(uri, TFTQueueDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	// regalia ������ �����ϴ� �Լ�
	public void setRegalia() {
		TFTRegaliaDto regaliaShort = new TFTRegaliaDto();
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-regalia.json",
				version,Common.REGIONS);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			regaliaShort = restTemplate.getForObject(uri, TFTRegaliaDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		// �÷��̾� ��ũ ���� �����ö��� Ƽ�� �̸��� Orange�� �̹���,���� Api������ Hyper��(api������ ����ġ)
		// regaliaShort���� ���� HyperŰ ��ü�� ������ hyper���� ����
		TFTRegalia hyper = regaliaShort.data.RANKED_TFT_TURBO.get("Hyper");
		// regaliaShort���� Hyper Ű�� ����
		regaliaShort.data.RANKED_TFT_TURBO.remove("Hyper");
		// regaliaShort���� Orange��� Ű�� �Ʊ� ������ hyper ��ü�� ����
		regaliaShort.data.RANKED_TFT_TURBO.put("Orange", hyper);
		
		// regalia�� regaliaShort�� ���� �ֱ�(regalia.tier�� Map����)
		regalia.tier.putAll(regaliaShort.data.RANKED_TFT);
		regalia.tier.putAll(regaliaShort.data.RANKED_TFT_TURBO);
		// regalia�� regaliaName(Ƽ�� ���� Map)�� �־��� setRegaliaName ȣ��
		setRegaliaName(regalia.tier, regaliaName);
	}
	
	// trait ������ �����ϴ� �Լ�
	public void setTrait() {
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-trait.json",
				version,Common.REGIONS);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			trait = restTemplate.getForObject(uri, TFTTraitDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	// unit ������ �����ϴ� �Լ�
	public void setUnit() {
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-champion.json",
				version,Common.REGIONS);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			unit = restTemplate.getForObject(uri, TFTUnitDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		// ���̾� api�� �Ŵ� ��ũ �κ��� ���� ������ ���� �������(api��ü ����)
		unit.data.put("TFT15_Galio", new TFTUnit("TFT15_Galio", "�Ŵ� ��ũ �κ�", 9, "TFTTutorial_Galio.png", Common.UNITS_URL));
	}
	
	// item ������ �����ϴ� �Լ�
	public void setItem() {
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-item.json",
				version,Common.REGIONS);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			item = restTemplate.getForObject(uri, TFTItemDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	// tactician ������ �����ϴ� �Լ�
	public void setTactician() {
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-tactician.json",
				version,Common.REGIONS);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			tactician = restTemplate.getForObject(uri, TFTTacticianDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	// profileIcon ������ �����ϴ� �Լ�
	public void setProfileIcon() {
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/profileicon.json",
				version,Common.REGIONS);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			profileIcon = restTemplate.getForObject(uri, ProfileIconDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	// map�� key���� ��ġ�ϴ� key���� ������ �ִ� name�� value���� map.name���� �����ϴ� �Լ�
	public void setRegaliaName(Map<String, TFTRegalia> map, Map<String, String> trans) {
		// map�� key,value���� ��� �ݺ��ؼ� key,value���·� ��ȯ
		for(Map.Entry<String, TFTRegalia> entry : map.entrySet()) {
			// entry�� key���� tier�� �ֱ�
			String tier = entry.getKey();
			// entry�� value���� regalia�� �ֱ�
			TFTRegalia regalia = entry.getValue();
			// regalia.name���� trans���� tier���� ��ġ�ϴ� key���� ���� ��ü�� ������ ����(������ tier�� ��ü�� ����)
			regalia.name = trans.getOrDefault(tier, tier);
		}
	}
	// group, full�� �޾ƿͼ� �̹���URL�� ��ȯ�ϴ� �Լ�
	public String getImgURL(String group, String full) {
		// ���̾� �̹��� ��ũ�� version, group, full���� �־ �̹���URL ��ũ�� �������
		String imgURL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/img/%s/%s",
				version, group, full);
		return imgURL;
	}
	
	// gameDatetime�� �޾ƿͼ� ��� �ð��� ��ȯ�ϴ� �Լ�
	public String transGamePassedtime(Long gameDatetime) {
		// gameDatetime�� �и��� ������ ǥ���Ǿ� �־ instant(Ư�� �������� �󸶳� �ð��� �귶���� ��Ÿ��)��ü�� ��ȯ
	    Instant instant = Instant.ofEpochMilli(gameDatetime);
	    // instant�� �ý��� �⺻ �ð���� ��ȯ
	    ZonedDateTime gameTime = instant.atZone(ZoneId.systemDefault());
	    // ���� �ð����� ����
	    ZonedDateTime now = ZonedDateTime.now();
	    
	    // gameTime�� now�� YEARS�� ��
	    long years = ChronoUnit.YEARS.between(gameTime, now);
	    // ���̰� ���ٸ� 'N�� ��' ��ȯ
	    if (years > 0) return years + "�� ��";
	    
	    // gameTime�� now�� MONTHS�� ��
	    long months = ChronoUnit.MONTHS.between(gameTime, now);
	    // ���̰� ���ٸ� 'N�� ��' ��ȯ
	    if (months > 0) return months + "�� ��";
	    
	    // gameTime�� now�� DAYS�� ��
	    long days = ChronoUnit.DAYS.between(gameTime, now);
	    // ���̰� ���ٸ� 'N�� ��' ��ȯ
	    if (days > 0) return days + "�� ��";
	    
	    // gameTime�� now�� HOURS�� ��
	    long hours = ChronoUnit.HOURS.between(gameTime, now);
	    // ���̰� ���ٸ� 'N�ð� ��' ��ȯ
	    if (hours > 0) return hours + "�ð� ��";

	    // gameTime�� now�� MINUTES�� ��
	    long minutes = ChronoUnit.MINUTES.between(gameTime, now);
	    // ���̰� ���ٸ� 'N�� ��' ��ȯ
	    if (minutes > 0) return minutes + "�� ��";
	    
	    // �� ���� ���� ���̰� ���� �ʴ´ٸ� '��� ��' ��ȯ
	    return "��� ��";
	}
	
	//g ameDatetime�� �޾ƿͼ� ���� ���ڸ� ��ȯ�ϴ� �Լ�
	public String transGameDatetime(Long gameDatetime) {
		// gameDatetime�� �и��� ������ ǥ���Ǿ� �־ instant(Ư�� �������� �󸶳� �ð��� �귶���� ��Ÿ��)��ü�� ��ȯ
		Instant instant = Instant.ofEpochMilli(gameDatetime);
		// instant�� �ý��� �⺻ �ð���� ��ȯ
	    ZonedDateTime gameTime = instant.atZone(ZoneId.systemDefault());
	    // gameTime�� String���� ��ȯ
	    String trans = String.format("%s", gameTime);
	    
	    return trans;
	}
	
	// gameLength�� �޾ƿͼ� ���� ��� �ð��� ��ȯ�ϴ� �Լ�
	public String transTimeElemented(Double gameLength) {
	// gameLength�� 60���� ������ �� ���
	int nMin = (int)Math.floor(gameLength/60);
	// gameLength�� 60���� ���� �������� �� �� ���
	int nSec = (int)Math.ceil(gameLength%60);
	
	// '�� : ��' ��ȯ
	return nMin + ":" + nSec;
}
	// queueType�� ���� ������ API���� ��ġ�ϴ� ���� name�� ��ȯ�ϴ� �Լ�
	public String transQueueType(int queueType) {
		// queue.data���� queueType�� ���� ���� ���� key�� name�� ã��
		String trans = queue.data.get(Integer.toString(queueType)).name;
		
		return trans;
	}
	
	// queueType�� ���� ������ API���� ��ġ�ϴ� ���� name�� ��ȯ�ϴ� �Լ�
	public String transQueueType(String queueType) {
		String trans = "";
		// queue.data�� ��� ���� key,value���·� ��ȯ
	    for (Map.Entry<String, TFTQueue> entry : queue.data.entrySet()) {
	    	// entry�� value.queueType�� queueType�� ������ Ȯ��
	        if (entry.getValue().queueType.equals(queueType)) {
	        	// ���ٸ� entry�� value.name���� trans�� ����
	            trans = entry.getValue().name;
	        }
	    }
	    
		return trans;
	}
	
	// rank���� �޾ƿͼ� ���ڸ� ��ȯ�ϴ� �Լ�
	public String transRankNum(String rank) {
		// rank���� ���� ���� ��ȯ
		switch(rank) {
		case"I":
			return "1";
		case"II":
			return "2";
		case"III":
			return "3";
		case"IV":
			return "4";
		}
		
		// ��ġ���� ������ rank �״�� ��ȯ
		return rank;
	}
	
	// lastRound�� �޾ƿͼ� ������ ���带 ��ȯ�ϴ� �Լ�
	public String transLastRound(int lastRound) {
		// ���带 ��� �ؼ� 'N-N'�� ��ȯ
		String trans = ((lastRound - 5)/7+2) + "-" + ((lastRound-5)%7+1);
		
		return trans;
	}
}
