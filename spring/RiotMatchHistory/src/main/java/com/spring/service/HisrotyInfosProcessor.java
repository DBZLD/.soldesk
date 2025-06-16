package com.spring.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.spring.dto.tft.MatchDto;
import com.spring.dto.tft.Participant;
import com.spring.dto.tft.PlayerDto;
import com.spring.dto.tft.PuuidDto;
import com.spring.dto.tft.queue.QueueDto;

import lombok.extern.log4j.Log4j;
@Log4j
public class HisrotyInfosProcessor {
	
	public String API_KEY = "RGAPI-b12eed46-aa9e-4b15-9d5c-ccb9dbe0d180";	
	public PuuidDto puuid = new PuuidDto();
	public ArrayList<String> gameIds = new ArrayList<String>();
	public ArrayList<MatchDto> matchInfos = new ArrayList<MatchDto>();
	public ArrayList<PlayerDto> playerInfo = new ArrayList<PlayerDto>();
	public QueueDto queue = new QueueDto();
	
	public HisrotyInfosProcessor(String playerId, String playerTag) {
		setPuuid(playerId, playerTag);
		setPlayerInfo();
		setGameIds();
		setMatchInfos();
		
		setQueue();
		setImage("1", "2");
	}
	public int findRankIndex() {
		ArrayList<String> queueTypeList = new ArrayList<>();
		for(int i = 0; i < playerInfo.size(); i++) {
			queueTypeList.add(playerInfo.get(i).queueType);
		}
		int pIndex = queueTypeList.indexOf("RANKED_TFT");
		return pIndex;
	}
	public int findDURankIndex() {
		ArrayList<String> queueTypeList = new ArrayList<>();
		for(int i = 0; i < playerInfo.size(); i++) {
			queueTypeList.add(playerInfo.get(i).queueType);
		}
		int pIndex = queueTypeList.indexOf("RANKED_TFT_DOUBLE_UP");
		return pIndex;
	}
	public int findTRankIndex() {
		ArrayList<String> queueTypeList = new ArrayList<>();
		for(int i = 0; i < playerInfo.size(); i++) {
			queueTypeList.add(playerInfo.get(i).queueType);
		}
		int pIndex = queueTypeList.indexOf("RANKED_TFT_TURBO");
		return pIndex;
	}
	public String getPlayerRankInfo() {
		String rankInfo = "";
		int pIndex = findRankIndex();
		if(pIndex == -1) {
			return "랭크 전적 없음";
		}
		rankInfo += "랭크 : " + playerInfo.get(pIndex).tier + " ";
		rankInfo += playerInfo.get(pIndex).rank + " ";
		rankInfo += playerInfo.get(pIndex).leaguePoints + "LP<br>";
		rankInfo += playerInfo.get(pIndex).wins + "승 ";
		rankInfo += playerInfo.get(pIndex).losses + "패";
		return rankInfo;
	}
	public String getPlayerDURankInfo() {
		String rankInfo = "";
		int pIndex = findDURankIndex();
		if(pIndex == -1) {
			return "더블업 전적 없음";
		}
		rankInfo += "더블업 : " + playerInfo.get(pIndex).tier + " ";
		rankInfo += playerInfo.get(pIndex).rank + " ";
		rankInfo += playerInfo.get(pIndex).leaguePoints + "LP<br>";
		rankInfo += playerInfo.get(pIndex).wins + "승 ";
		rankInfo += playerInfo.get(pIndex).losses + "패";
		return rankInfo;
	}
	public String getPlayerTRankInfo() {
		String rankInfo = "";
		int pIndex = findTRankIndex();
		if(pIndex == -1) {
			return "초고속 모드 전적 없음";
		}
		rankInfo += "초고속 모드 : " + playerInfo.get(pIndex).ratedTier + " ";
		rankInfo += playerInfo.get(pIndex).ratedRating + "점<br>";
		rankInfo += playerInfo.get(pIndex).wins + "승 ";
		rankInfo += playerInfo.get(pIndex).losses + "패";
		return rankInfo;
	}
	public String getPlayerName() {
		String name = "";
		name += puuid.gameName + "#";
		name += puuid.tagLine;
		return name;
	}
	public Participant getMatchParticipant(int mIndex, int pIndex) {
		return matchInfos.get(mIndex).info.participants.get(pIndex);
	}
	public String getMatchDate(int mIndex) {
		long unixTime = matchInfos.get(mIndex).info.game_datetime;
		Date date = new Date(unixTime);
		Calendar gameDate = Calendar.getInstance();
		gameDate.setTime(date);
		Calendar nowDate = Calendar.getInstance();
		String stDate = "";
		if(gameDate.get(Calendar.YEAR) != nowDate.get(Calendar.YEAR)) {
			stDate = Integer.toString(nowDate.get(Calendar.YEAR)-gameDate.get(Calendar.YEAR)) + "년 전";
		}else if(gameDate.get(Calendar.MONTH) != nowDate.get(Calendar.MONTH)) {
			stDate = Integer.toString(nowDate.get(Calendar.MONTH)-gameDate.get(Calendar.MONTH)) + "달 전";
		}else if(gameDate.get(Calendar.DAY_OF_MONTH) != nowDate.get(Calendar.DAY_OF_MONTH)) {
			stDate = Integer.toString(nowDate.get(Calendar.DAY_OF_MONTH)-gameDate.get(Calendar.DAY_OF_MONTH)) + "일 전";
		}else if(gameDate.get(Calendar.HOUR_OF_DAY) != nowDate.get(Calendar.HOUR_OF_DAY)) {
			stDate = Integer.toString(nowDate.get(Calendar.HOUR_OF_DAY)-gameDate.get(Calendar.HOUR_OF_DAY)) + "시간 전";
		}else if(gameDate.get(Calendar.MINUTE) != nowDate.get(Calendar.MINUTE)) {
			stDate = Integer.toString(nowDate.get(Calendar.MINUTE)-gameDate.get(Calendar.MINUTE)) + "분 전";
		}else {
			stDate = "방금 전";
		}
		return stDate;
	}
	public String getMatchPlayerName(int mIndex, int pIndex) {
		String name = "";
		name += matchInfos.get(mIndex).info.participants.get(pIndex).riotIdGameName + "#";
		name += matchInfos.get(mIndex).info.participants.get(pIndex).riotIdTagline;
		return name;
	}
	
	public String getMatchType(int mIndex) {
	    int type = matchInfos.get(mIndex).info.queueId;
	    switch (type) {
	        case 1090:
	            return queue.data.Q1090.name;
	        case 1100:
	            return queue.data.Q1100.name;
	        case 1110:
	            return queue.data.Q1110.name;
	        case 1130:
	            return queue.data.Q1130.name;
	        case 1160:
	            return queue.data.Q1160.name;
	        case 1170:
	            return queue.data.Q1170.name;
	        case 1180:
	            return queue.data.Q1180.name;
	        case 1190:
	            return queue.data.Q1190.name;
	        default:
	            return null;
	    }
	}
	public int findPlayer(int mIndex, String puuid) {
		int pIndex = matchInfos.get(mIndex).metadata.participants.indexOf(puuid);
		return pIndex;
	}
	public String getMatchPlacement(int mIndex) {
		String gamePlacement = Integer.toString(matchInfos.get(mIndex).info.participants.get(findPlayer(mIndex, puuid.puuid)).placement)+"등";
		return gamePlacement;
	}
	public String getMatchTime(int mIndex) {
		int time = (int)matchInfos.get(mIndex).info.participants.get(findPlayer(mIndex, puuid.puuid)).time_eliminated;
		int nMin = time/60;
		int nSec = time%60;
		String gameTime = String.format("%d분 %d초", nMin, nSec);
		return gameTime;
	}
	public void shortQ() {
		
	}
	//생성 시 함수
	public void setPuuid(String AC_ID, String AC_TAG) { //account id, account tag로 puuid 얻기
		String API_URL = String.format("https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/%s/%s?api_key=%s", AC_ID, AC_TAG, API_KEY);												
		URI uri = null; 
		RestTemplate restTemplate = new RestTemplate();
		try {						
				uri = new URI(API_URL);
		} catch (URISyntaxException e) {						
				e.printStackTrace();					
			}
			this.puuid = restTemplate.getForObject(uri, PuuidDto.class);
			//puuid  f98WWOqUGgb4fJw5YoM_EIi5ylBtG2gBNjnufiPE28COchIKm0kFBTjZSuQvZ8pitMZxLXC3feDw2A
	}
	public void setGameIds(){
		//puuid로 gameIds 얻기 
		int nCount = 5;
		String API_URL = String.format("https://asia.api.riotgames.com/tft/match/v1/matches/by-puuid/%s/ids?start=0&count=%d&api_key=%s", puuid.puuid, nCount, API_KEY);
		RestTemplate restTemplate = new RestTemplate();
		try {
			URI uri = new URI(API_URL);
            ResponseEntity<ArrayList<String>> response = restTemplate.exchange(
            		uri, HttpMethod.GET,
                    null, new ParameterizedTypeReference<ArrayList<String>>() {}
                );
            this.gameIds = response.getBody();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	public void setMatchInfos() {
		//gameId로 matchInfo얻기
		RestTemplate restTemplate = new RestTemplate();
		ArrayList<MatchDto> matchInfos = new ArrayList<MatchDto>();
		for(int i = 0; i < gameIds.size(); i++) {
			String API_URL = String.format("https://asia.api.riotgames.com/tft/match/v1/matches/%s?api_key=%s",gameIds.get(i), API_KEY);
			try {						
				URI uri = new URI(API_URL);
				MatchDto matchInfo = restTemplate.getForObject(uri, MatchDto.class);
				matchInfos.add(matchInfo);		
			} catch (URISyntaxException e) {						
				e.printStackTrace();					
			}
		}
		this.matchInfos = matchInfos;
	}
	public void setPlayerInfo() {
		String API_URL = String.format("https://kr.api.riotgames.com/tft/league/v1/by-puuid/%s?api_key=%s", puuid.puuid, API_KEY);												 
		RestTemplate restTemplate = new RestTemplate();
		try {	
			URI uri = new URI(API_URL);
            ResponseEntity<ArrayList<PlayerDto>> response = restTemplate.exchange(
            		uri, HttpMethod.GET,
                    null, new ParameterizedTypeReference<ArrayList<PlayerDto>>() {}
                );
            playerInfo = response.getBody();
		} catch (URISyntaxException e) {						
				e.printStackTrace();					
			}
	}
	public void setQueue() {
		String API_URL = "https://ddragon.leagueoflegends.com/cdn/13.24.1/data/ko_KR/tft-queues.json";
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {						
			uri = new URI(API_URL);
		} catch (URISyntaxException e) {						
			e.printStackTrace();					
		}
		queue = restTemplate.getForObject(uri, QueueDto.class);
	}
	public String setImage(String imageType, String imageId) {
		log.info(matchInfos.get(0).info.participants.get(0).traits.get(0).name);
		//String imageURL = String.format("https://ddragon.leagueoflegends.com/cdn/13.24.1/img/%s/%s.png", imageType, imageId);
		return "1";
	}
}
