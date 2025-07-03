package com.spring.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.web.client.RestTemplate;

import com.spring.dto.tft.ProfileIconDto;
import com.spring.dto.tft.TFTChampionDto;
import com.spring.dto.tft.TFTItemDto;
import com.spring.dto.tft.TFTQueueDto;
import com.spring.dto.tft.TFTRegaliaDto;
import com.spring.dto.tft.TFTTacticianDto;
import com.spring.dto.tft.TFTTraitDto;

import lombok.extern.log4j.Log4j;

@Log4j

public class TFTApiProcessor {
	public static final String VERSIONS = "15.13.1";
	public static final String REGIONS = "ko_KR";
	public TFTQueueDto queue = new TFTQueueDto();
	public TFTRegaliaDto regalia = new TFTRegaliaDto();
	public TFTTraitDto traits = new TFTTraitDto();
	public TFTChampionDto champion = new TFTChampionDto();
	public TFTItemDto item = new TFTItemDto();
	public TFTTacticianDto tactician = new TFTTacticianDto();
	public ProfileIconDto profileIcon = new ProfileIconDto();
	
	public TFTApiProcessor() {
		setQueue();
		setRegalia();
		setTraits();
		setChampion();
		setItem();
		setTactician();
		setProfileIcon();
	}
//	public int findRankIndex(String rankType) {
//		ArrayList<String> queueTypeList = new ArrayList<>();
//		for (int i = 0; i < playerInfo.size(); i++) {
//			queueTypeList.add(playerInfo.get(i).queueType);
//		}
//		int pIndex = queueTypeList.indexOf(rankType);
//		return pIndex;
//	}
//
//	public String getPlayerRankInfo(String rankType) {
//		String rankInfo = "";
//		int pIndex = findRankIndex(rankType);
//
//		rankInfo += getRankRegaliaImg(rankType, pIndex);
//		if (pIndex == -1) {
//			rankInfo += "전적 없음";
//			return rankInfo;
//		}
//		rankInfo += playerInfo.get(pIndex).tier + " ";
//		rankInfo += playerInfo.get(pIndex).rank + " ";
//		rankInfo += playerInfo.get(pIndex).leaguePoints + "LP<br>";
//		rankInfo += playerInfo.get(pIndex).wins + "승 ";
//		rankInfo += playerInfo.get(pIndex).losses + "패";
//		return rankInfo;
//	}
//
//	public String getPlayerName() {
//		String name = "";
//		name += puuid.gameName + "#";
//		name += puuid.tagLine;
//		return name;
//	}
//
//	public Participant getMatchParticipant(int mIndex, int pIndex) {
//		return matchInfos.get(mIndex).info.participants.get(pIndex);
//	}
//
//	public String getMatchDate(int mIndex) {
//		long unixTime = matchInfos.get(mIndex).info.game_datetime;
//		Date date = new Date(unixTime);
//		Calendar gameDate = Calendar.getInstance();
//		gameDate.setTime(date);
//		Calendar nowDate = Calendar.getInstance();
//		String stDate = "";
//		if (gameDate.get(Calendar.YEAR) != nowDate.get(Calendar.YEAR)) {
//			stDate = Integer.toString(nowDate.get(Calendar.YEAR) - gameDate.get(Calendar.YEAR)) + "년 전";
//		} else if (gameDate.get(Calendar.MONTH) != nowDate.get(Calendar.MONTH)) {
//			stDate = Integer.toString(nowDate.get(Calendar.MONTH) - gameDate.get(Calendar.MONTH)) + "달 전";
//		} else if (gameDate.get(Calendar.DAY_OF_MONTH) != nowDate.get(Calendar.DAY_OF_MONTH)) {
//			stDate = Integer.toString(nowDate.get(Calendar.DAY_OF_MONTH) - gameDate.get(Calendar.DAY_OF_MONTH)) + "일 전";
//		} else if (gameDate.get(Calendar.HOUR_OF_DAY) != nowDate.get(Calendar.HOUR_OF_DAY)) {
//			stDate = Integer.toString(nowDate.get(Calendar.HOUR_OF_DAY) - gameDate.get(Calendar.HOUR_OF_DAY)) + "시간 전";
//		} else if (gameDate.get(Calendar.MINUTE) != nowDate.get(Calendar.MINUTE)) {
//			stDate = Integer.toString(nowDate.get(Calendar.MINUTE) - gameDate.get(Calendar.MINUTE)) + "분 전";
//		} else {
//			stDate = "방금 전";
//		}
//		return stDate;
//	}
//
//	public String getMatchPlayerName(int mIndex, int pIndex) {
//		String name = "";
//		name += matchInfos.get(mIndex).info.participants.get(pIndex).riotIdGameName + "#";
//		name += matchInfos.get(mIndex).info.participants.get(pIndex).riotIdTagline;
//		return name;
//	}
//
//	public String getMatchType(int mIndex) {
//		String queueId = "Q" + matchInfos.get(mIndex).info.queueId;
//		String name = "";
//		try {
//			Object objData = queue.data;
//			Field fieldQueue = objData.getClass().getDeclaredField(queueId);
//			fieldQueue.setAccessible(true);
//			Object objQueue = fieldQueue.get(objData);
//
//			Field fieldName = objQueue.getClass().getDeclaredField("name");
//			fieldQueue.setAccessible(true);
//			name = (String) fieldName.get(objQueue);
//		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
//			e.printStackTrace();
//		}
//		return name;
//	}
//
//	public String getRankRegaliaImg(String rankType, int pIndex) {
//		if (pIndex == -1) {
//			return String.format("<img class = \"%s\" alt=\"%s\" src=\"%s\">",
//			"tft-regalia", "tft-regalia", getImageURL("tft-regalia", "TFT_Regalia_Provisional.png"));
//		}
//		String url = "";
//		String pTier = "";
//		pTier = playerInfo.get(pIndex).tier;
//		
//		try {
//			Object objData = regalia.data;
//			Field fieldRank = objData.getClass().getDeclaredField(rankType);
//			fieldRank.setAccessible(true);
//			Object objRank = fieldRank.get(objData);
//
//			Field fieldTier = objRank.getClass().getDeclaredField(pTier);
//			fieldTier.setAccessible(true);
//			Object objTier = fieldTier.get(objRank);
//
//			Field fieldImage = objTier.getClass().getDeclaredField("image");
//			fieldImage.setAccessible(true);
//			Object objImage = fieldImage.get(objTier);
//
//			Image image = (Image) objImage;
//			url = String.format("<img class = \"%s\" alt=\"%s\" src=\"%s\">",
//				  regalia.type, regalia.type, getImageURL(regalia.type, image.full));
//		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
//			e.printStackTrace();
//		}
//		return url;
//	}
//
//	public int findPlayer(int mIndex, String puuid) {
//		int pIndex = matchInfos.get(mIndex).metadata.participants.indexOf(puuid);
//		return pIndex;
//	}
//
//	public String getMatchPlacement(int mIndex) {
//		String gamePlacement = Integer.toString(
//				matchInfos.get(mIndex).info.participants.get(findPlayer(mIndex, puuid.puuid)).placement) + "등";
//		return gamePlacement;
//	}
//
//	public String getMatchTime(int mIndex) {
//		int time = (int) matchInfos.get(mIndex).info.participants.get(findPlayer(mIndex, puuid.puuid)).time_eliminated;
//		int nMin = time / 60;
//		int nSec = time % 60;
//		String gameTime = String.format("%d분 %d초", nMin, nSec);
//		return gameTime;
//	}
//
//	public String getImageURL(String imageType, String imageId) {
//		String imageURL = String.format("https://ddragon.leagueoflegends.com/cdn/15.12.1/img/%s/%s", imageType,
//				imageId);
//		return imageURL;
//	}
	public void setQueue() {
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-queues.json",VERSIONS,REGIONS);
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
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-regalia.json",VERSIONS,REGIONS);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			regalia = restTemplate.getForObject(uri, TFTRegaliaDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	public void setTraits() {
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-trait.json",VERSIONS,REGIONS);
		log.info(API_URL);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			traits = restTemplate.getForObject(uri, TFTTraitDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	public void setChampion() {
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-champion.json",VERSIONS,REGIONS);
		log.info(API_URL);
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
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-item.json",VERSIONS,REGIONS);
		log.info(API_URL);
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
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/tft-tactician.json",VERSIONS,REGIONS);
		log.info(API_URL);
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
		String API_URL = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/profileicon.json",VERSIONS,REGIONS);
		log.info(API_URL);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			profileIcon = restTemplate.getForObject(uri, ProfileIconDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	public void setRegaliaName() {
		
	}
}
