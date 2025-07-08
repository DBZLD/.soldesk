package com.spring.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import static java.util.Map.entry;

import org.springframework.web.client.RestTemplate;

import com.spring.dto.tft.TFTChampionDto;
import com.spring.dto.tft.TFTItemDto;
import com.spring.dto.tft.TFTQueueDto;
import com.spring.dto.tft.TFTRegalia;
import com.spring.dto.tft.TFTRegaliaDto;
import com.spring.dto.tft.TFTTacticianDto;
import com.spring.dto.tft.TFTTraitDto;
import com.spring.util.Common;
import com.spring.util.Image;
import com.spring.util.ProfileIconDto;

import lombok.extern.log4j.Log4j;

@Log4j

public class TFTApiProcessor {
	public TFTQueueDto queue = new TFTQueueDto();
	public TFTRegaliaDto regalia = new TFTRegaliaDto();
	public TFTTraitDto trait = new TFTTraitDto();
	public TFTChampionDto champion = new TFTChampionDto();
	public TFTItemDto item = new TFTItemDto();
	public TFTTacticianDto tactician = new TFTTacticianDto();
	public ProfileIconDto profileIcon = new ProfileIconDto();
	
	private Map<String, String> regaliaName = Map.ofEntries(
		entry("Iron", "아이언"),
		entry("Bronze", "브론즈"),
		entry("Silver", "실버"),
		entry("Gold", "골드"),
		entry("Platinum", "플레티넘"),
		entry("Emerald", "에메랄드"),
		entry("Diamond", "다이아몬드"),
		entry("Master", "마스터"),
		entry("Grandmaster", "그랜드마스터"),
		entry("Challenger", "챌린저"),
		entry("Provisional", "랭크 없음")
	);
	private Map<String, String> regaliaNameTurbo = Map.of(
		"Blue", "블루",
		"Gray", "그레이",
		"Green", "그린",
		"Hyper", "하이퍼",
		"Purple", "퍼플"
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
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-regalia.json",
				Common.VERSIONS,Common.REGIONS);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			regalia = restTemplate.getForObject(uri, TFTRegaliaDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		setRegaliaName(regalia.data.RANKED_TFT, regaliaName);
		setRegaliaName(regalia.data.RANKED_TFT_DOUBLE_UP, regaliaName);
		setRegaliaName(regalia.data.RANKED_TFT_TURBO, regaliaNameTurbo);
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
			champion = restTemplate.getForObject(uri, TFTChampionDto.class);
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
}
