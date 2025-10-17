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

public class TFTApiProcessor {	// 버전에 맞는 라이엇 API를 가져오는 클래스
	
	public String version;										// 게임 버전
	public TFTQueueDto queue = new TFTQueueDto();				// 매치 타입 정보, 번역 API
	public TFTRegaliaInfoDto regalia = new TFTRegaliaInfoDto(); // 티어 정보, 번역 API
	public TFTTraitDto trait = new TFTTraitDto();				// 특성 정보, 번역 API
	public TFTUnitDto unit = new TFTUnitDto();					// 유닛 정보, 번역 API
	public TFTItemDto item = new TFTItemDto();					// 아이템 정보, 번역 API
	public TFTTacticianDto tactician = new TFTTacticianDto();	// 전설이(플레이어 캐릭터) 정보, 번역 API
	public ProfileIconDto profileIcon = new ProfileIconDto();	// 프로필 아이콘 정보, 번역 API

	private Map<String, String> regaliaName = Map.ofEntries(	// key값과 일치하는 티어 번역 map
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
			entry("Provisional", "랭크 없음"),
			entry("Blue", "블루"),
			entry("Gray", "그레이"),
			entry("Green", "그린"),
			entry("Orange", "하이퍼"),
			entry("Purple", "퍼플")
		);
	
	// version을 매개 변수로 받는 생성자 함수
	public TFTApiProcessor(String version) {
		this.version = version;
		setQueue();				// queue 변수를 설정
		setRegalia();			// regalia 변수를 설정
		setTrait();				// trait 변수를 설정
		setUnit();				// unit 변수를 설정
		setItem();				// item 변수를 설정
		setTactician();			// tactician 변수를 설정
		setProfileIcon();		// profileIcon 변수를 설정
	}
	
	// full, group을 받아서 이미지URL을 반환하는 함수
	public String getRegaliaImg(String full, String group) {
		// version, group(이미지 분류), full(이미지 이름.png)과 URL을 합침
		String imgURL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/img/%s/%s",
				version, group, full);
		
		return imgURL;
	}
	
	// queue 변수를 설정하는 함수
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
	
	// regalia 변수를 설정하는 함수
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
		// 플레이어 랭크 정보 가져올때는 티어 이름이 Orange고 이미지,번역 Api에서는 Hyper임(api내에서 불일치)
		// regaliaShort에서 기존 Hyper키 객체를 복사한 hyper변수 생성
		TFTRegalia hyper = regaliaShort.data.RANKED_TFT_TURBO.get("Hyper");
		// regaliaShort에서 Hyper 키를 삭제
		regaliaShort.data.RANKED_TFT_TURBO.remove("Hyper");
		// regaliaShort에서 Orange라는 키에 아까 가져온 hyper 객체를 생성
		regaliaShort.data.RANKED_TFT_TURBO.put("Orange", hyper);
		
		// regalia에 regaliaShort의 내용 넣기(regalia.tier는 Map형식)
		regalia.tier.putAll(regaliaShort.data.RANKED_TFT);
		regalia.tier.putAll(regaliaShort.data.RANKED_TFT_TURBO);
		// regalia에 regaliaName(티어 번역 Map)을 넣어줄 setRegaliaName 호출
		setRegaliaName(regalia.tier, regaliaName);
	}
	
	// trait 변수를 설정하는 함수
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
	
	// unit 변수를 설정하는 함수
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
		// 라이엇 api에 거대 메크 로봇이 없기 때문에 직접 만들어줌(api자체 오류)
		unit.data.put("TFT15_Galio", new TFTUnit("TFT15_Galio", "거대 메크 로봇", 9, "TFTTutorial_Galio.png", Common.UNITS_URL));
	}
	
	// item 변수를 설정하는 함수
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
	
	// tactician 변수를 설정하는 함수
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
	
	// profileIcon 변수를 설정하는 함수
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
	
	// map의 key값과 일치하는 key값을 가지고 있는 name의 value값을 map.name으로 설정하는 함수
	public void setRegaliaName(Map<String, TFTRegalia> map, Map<String, String> trans) {
		// map의 key,value쌍을 모두 반복해서 key,value형태로 반환
		for(Map.Entry<String, TFTRegalia> entry : map.entrySet()) {
			// entry의 key값을 tier에 넣기
			String tier = entry.getKey();
			// entry의 value값을 regalia에 넣기
			TFTRegalia regalia = entry.getValue();
			// regalia.name값을 trans에서 tier값과 일치하는 key값을 가진 객체의 값으로 설정(없으면 tier값 자체로 설정)
			regalia.name = trans.getOrDefault(tier, tier);
		}
	}
	// group, full을 받아와서 이미지URL을 반환하는 함수
	public String getImgURL(String group, String full) {
		// 라이엇 이미지 링크에 version, group, full값을 넣어서 이미지URL 링크를 만들어줌
		String imgURL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/img/%s/%s",
				version, group, full);
		return imgURL;
	}
	
	// gameDatetime을 받아와서 경과 시간을 반환하는 함수
	public String transGamePassedtime(Long gameDatetime) {
		// gameDatetime은 밀리초 단위로 표현되어 있어서 instant(특정 시점부터 얼마나 시간이 흘렀는지 나타냄)객체로 변환
	    Instant instant = Instant.ofEpochMilli(gameDatetime);
	    // instant를 시스템 기본 시간대로 변환
	    ZonedDateTime gameTime = instant.atZone(ZoneId.systemDefault());
	    // 현재 시간으로 설정
	    ZonedDateTime now = ZonedDateTime.now();
	    
	    // gameTime과 now의 YEARS를 비교
	    long years = ChronoUnit.YEARS.between(gameTime, now);
	    // 차이가 난다면 'N년 전' 반환
	    if (years > 0) return years + "년 전";
	    
	    // gameTime과 now의 MONTHS를 비교
	    long months = ChronoUnit.MONTHS.between(gameTime, now);
	    // 차이가 난다면 'N달 전' 반환
	    if (months > 0) return months + "달 전";
	    
	    // gameTime과 now의 DAYS를 비교
	    long days = ChronoUnit.DAYS.between(gameTime, now);
	    // 차이가 난다면 'N일 전' 반환
	    if (days > 0) return days + "일 전";
	    
	    // gameTime과 now의 HOURS를 비교
	    long hours = ChronoUnit.HOURS.between(gameTime, now);
	    // 차이가 난다면 'N시간 전' 반환
	    if (hours > 0) return hours + "시간 전";

	    // gameTime과 now의 MINUTES를 비교
	    long minutes = ChronoUnit.MINUTES.between(gameTime, now);
	    // 차이가 난다면 'N분 전' 반환
	    if (minutes > 0) return minutes + "분 전";
	    
	    // 위 값이 전부 차이가 나지 않는다면 '방금 전' 반환
	    return "방금 전";
	}
	
	//g ameDatetime을 받아와서 게임 일자를 반환하는 함수
	public String transGameDatetime(Long gameDatetime) {
		// gameDatetime은 밀리초 단위로 표현되어 있어서 instant(특정 시점부터 얼마나 시간이 흘렀는지 나타냄)객체로 변환
		Instant instant = Instant.ofEpochMilli(gameDatetime);
		// instant를 시스템 기본 시간대로 변환
	    ZonedDateTime gameTime = instant.atZone(ZoneId.systemDefault());
	    // gameTime을 String으로 변환
	    String trans = String.format("%s", gameTime);
	    
	    return trans;
	}
	
	// gameLength를 받아와서 게임 경과 시간을 반환하는 함수
	public String transTimeElemented(Double gameLength) {
	// gameLength를 60으로 나눠서 분 얻기
	int nMin = (int)Math.floor(gameLength/60);
	// gameLength를 60으로 나눈 나머지를 얻어서 초 얻기
	int nSec = (int)Math.ceil(gameLength%60);
	
	// '분 : 초' 반환
	return nMin + ":" + nSec;
}
	// queueType의 값을 가지고 API에서 일치하는 값의 name을 반환하는 함수
	public String transQueueType(int queueType) {
		// queue.data에서 queueType의 값과 같은 값의 key의 name을 찾음
		String trans = queue.data.get(Integer.toString(queueType)).name;
		
		return trans;
	}
	
	// queueType의 값을 가지고 API에서 일치하는 값의 name을 반환하는 함수
	public String transQueueType(String queueType) {
		String trans = "";
		// queue.data를 모두 돌아 key,value형태로 반환
	    for (Map.Entry<String, TFTQueue> entry : queue.data.entrySet()) {
	    	// entry의 value.queueType과 queueType이 같은지 확인
	        if (entry.getValue().queueType.equals(queueType)) {
	        	// 같다면 entry의 value.name값을 trans로 설정
	            trans = entry.getValue().name;
	        }
	    }
	    
		return trans;
	}
	
	// rank값을 받아와서 숫자를 반환하는 함수
	public String transRankNum(String rank) {
		// rank값에 따라 숫자 반환
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
		
		// 일치하지 않을시 rank 그대로 반환
		return rank;
	}
	
	// lastRound를 받아와서 마지막 라운드를 반환하는 함수
	public String transLastRound(int lastRound) {
		// 라운드를 계산 해서 'N-N'을 반환
		String trans = ((lastRound - 5)/7+2) + "-" + ((lastRound-5)%7+1);
		
		return trans;
	}
}
