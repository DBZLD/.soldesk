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

import com.spring.dto.tft.TFTChampionDto;
import com.spring.dto.tft.TFTItem;
import com.spring.dto.tft.TFTItemDto;
import com.spring.dto.tft.TFTQueue;
import com.spring.dto.tft.TFTQueueDto;
import com.spring.dto.tft.TFTRegalia;
import com.spring.dto.tft.TFTRegaliaApiDto;
import com.spring.dto.tft.TFTRegaliaDto;
import com.spring.dto.tft.TFTTacticianDto;
import com.spring.dto.tft.TFTTraitDto;
import com.spring.util.Common;
import com.spring.util.ProfileIconDto;

import lombok.extern.log4j.Log4j;

@Log4j

public class TFTApiProcessor {
	public TFTQueueDto queue = new TFTQueueDto();
	public TFTRegaliaDto regalia = new TFTRegaliaDto();
	public TFTTraitDto trait = new TFTTraitDto();
	public TFTChampionDto unit = new TFTChampionDto();
	public TFTItemDto item = new TFTItemDto();
	public TFTTacticianDto tactician = new TFTTacticianDto();
	public ProfileIconDto profileIcon = new ProfileIconDto();
	
	private Map<String, String> regaliaName = Map.ofEntries(
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
	
	public TFTApiProcessor() {
		setQueue();
		setRegalia();
		setTrait();
		setChampion();
		setItem();
		setTactician();
		setProfileIcon();
	}
	
	public String getRegaliaImg(String full, String group) {
		String imgURL;
		imgURL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/img/%s/%s",
				Common.VERSIONS, group, full);
		
		return imgURL;
	}
	public void setQueue() {
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-queues.json",
				Common.VERSIONS,Common.REGIONS);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			queue = restTemplate.getForObject(uri, TFTQueueDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	public void setRegalia() {
		TFTRegaliaApiDto regaliaShort = new TFTRegaliaApiDto();
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-regalia.json",
				Common.VERSIONS,Common.REGIONS);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			regaliaShort = restTemplate.getForObject(uri, TFTRegaliaApiDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		TFTRegalia hyper = regaliaShort.data.RANKED_TFT_TURBO.get("Hyper"); //�÷��̾� ��ũ ���� �����ö��� Orange�� �̹���,���� Api������ Hyper��
		regaliaShort.data.RANKED_TFT_TURBO.remove("Hyper");
		regaliaShort.data.RANKED_TFT_TURBO.put("Orange", hyper);
		
		regalia.tier.putAll(regaliaShort.data.RANKED_TFT);
		regalia.tier.putAll(regaliaShort.data.RANKED_TFT_TURBO);
		setRegaliaName(regalia.tier, regaliaName);
	}
	public void setTrait() {
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-trait.json",
				Common.VERSIONS,Common.REGIONS);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			trait = restTemplate.getForObject(uri, TFTTraitDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	public void setChampion() {
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-champion.json",
				Common.VERSIONS,Common.REGIONS);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			unit = restTemplate.getForObject(uri, TFTChampionDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	public void setItem() {
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-item.json",
				Common.VERSIONS,Common.REGIONS);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			item = restTemplate.getForObject(uri, TFTItemDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		//���̾� �ֽ�api�� �ӽ��� ����(14.23.1���� ����)
		TFTItem spite = new TFTItem("TFT_Item_Spite", "�ӽ�", "TFT_Item_Spite.png", "tft-item"); 
		item.data.put("TFT_Item_Spite", spite);
	}
	public void setTactician() {
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-tactician.json",
				Common.VERSIONS,Common.REGIONS);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			tactician = restTemplate.getForObject(uri, TFTTacticianDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	public void setProfileIcon() {
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/profileicon.json",
				Common.VERSIONS,Common.REGIONS);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			profileIcon = restTemplate.getForObject(uri, ProfileIconDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	public void setRegaliaName(Map<String, TFTRegalia> map, Map<String, String> name) {
		for(Map.Entry<String, TFTRegalia> entry : map.entrySet()) {
			String tier = entry.getKey();
			TFTRegalia regalia = entry.getValue();
			regalia.name = name.getOrDefault(tier, tier);
		}
	}
	public String getImgURL(String group, String full) {
		if(full.equals("TFT_Item_Spite.png")) {
			return String.format("https://ddragon.leagueoflegends.com/cdn/%s/img/%s/%s",
					"14.23.1", group, full);
		}
		String imgURL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/img/%s/%s",
		Common.VERSIONS, group, full);
		return imgURL;
	}
	public String transGameDatetime(Long gameDatetime) {
	    Instant instant = Instant.ofEpochMilli(gameDatetime);
	    ZonedDateTime gameTime = instant.atZone(ZoneId.systemDefault());
	    ZonedDateTime now = ZonedDateTime.now();

	    long years = ChronoUnit.YEARS.between(gameTime, now);
	    if (years > 0) return years + "�� ��";

	    long months = ChronoUnit.MONTHS.between(gameTime, now);
	    if (months > 0) return months + "�� ��";

	    long days = ChronoUnit.DAYS.between(gameTime, now);
	    if (days > 0) return days + "�� ��";

	    long hours = ChronoUnit.HOURS.between(gameTime, now);
	    if (hours > 0) return hours + "�ð� ��";

	    long minutes = ChronoUnit.MINUTES.between(gameTime, now);
	    if (minutes > 0) return minutes + "�� ��";

	    return "��� ��";
	}
	public String transTimeElemented(Double gameLength) {
	int nMin = (int)Math.floor(gameLength/60);
	int nSec = (int)Math.ceil(gameLength%60);
	
	return nMin + ":" + nSec;
}
	public String transQueueType(int queueType) {
		String trans = queue.data.get(Integer.toString(queueType)).name;
		
		return trans;
	}
	public String transQueueType(String queueType) {
		String trans = "";
	    for (Map.Entry<String, TFTQueue> entry : queue.data.entrySet()) {
	        if (entry.getValue().queueType.equals(queueType)) {
	            trans = entry.getValue().name;
	        }
	    }
	    
		return trans;
	}
	public String transRankNum(String rank) {
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
		
		return rank;
	}
	public String transLastRound(int lastRound) {
		String trans = ((lastRound - 5)/7+2) + "-" + ((lastRound-5)%7+1);
		
		return trans;
	}
}
