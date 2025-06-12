package com.spring.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.spring.dto.MatchDto;
import com.spring.dto.Participant;
import com.spring.dto.PlayerDto;
import com.spring.dto.PuuidDto;

import lombok.extern.log4j.Log4j;
@Log4j
public class HisrotyInfosProcessor {
	
	public String API_KEY = "RGAPI-32cadf88-44de-4ac1-a3f2-2ba693a6cd3c";	
	public PuuidDto puuid = new PuuidDto();
	public ArrayList<String> gameIds = new ArrayList<String>();
	public ArrayList<MatchDto> matchInfos = new ArrayList<MatchDto>();
	public ArrayList<PlayerDto> playerInfo = new ArrayList<PlayerDto>();
	
	public HisrotyInfosProcessor(String playerId, String playerTag) {
		setPuuid(playerId, playerTag);
		setPlayerInfo();
		setGameIds();
		setMatchInfos();
	}
	public PlayerDto getPlayerRankInfo() {
		return playerInfo.get(0);
	}
	public PlayerDto getPlayerDURankInfo() {
		return playerInfo.get(1);
	}
	public String getPlayerRank() {
		String rank = "";
		rank += playerInfo.get(0).tier + " ";
		rank += playerInfo.get(0).rank + " ";
		rank += playerInfo.get(0).leaguePoints + "LP";
		return rank;
	}
	public String getPlayerDURank() {
		String rank = "";
		rank += playerInfo.get(1).tier + " ";
		rank += playerInfo.get(1).rank + " ";
		rank += playerInfo.get(1).leaguePoints + "LP";
		return rank;
	}
	public String getPlayerName() {
		String name = "";
		name += puuid.gameName + "#";
		name += puuid.tagLine;
		return name;
	}
	public PlayerDto getPlayerDoubleUpInfo() {
		return playerInfo.get(1);
	}
	public Participant getMatchParticipant(int mIndex, int pIndex) {
		return matchInfos.get(mIndex).info.participants.get(pIndex);
	}
	public String getMatchPlayerName(int mIndex, int pIndex) {
		String name = "";
		name += matchInfos.get(mIndex).info.participants.get(pIndex).riotIdGameName + "#";
		name += matchInfos.get(mIndex).info.participants.get(pIndex).riotIdTagline;
		return name;
	}
	public String getMatchType(int mIndex) {
		String type = matchInfos.get(mIndex).info.tft_game_type;
		String gameType = "";
		switch(type) {
		case"1090":
			gameType = "일반";
			break;
		case"1100":
			gameType = "랭크";
			break;
		case"1160":
			gameType = "더블 업";
			break;
		}
		return gameType;
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
}
