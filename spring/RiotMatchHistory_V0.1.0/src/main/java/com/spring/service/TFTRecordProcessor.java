package com.spring.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.spring.dto.tft.MatchDto;
import com.spring.dto.tft.PlayerDto;
import com.spring.dto.tft.PuuidDto;
import com.spring.dto.tft.SummonerDto;

import lombok.extern.log4j.Log4j;

@Log4j
public class TFTRecordProcessor {

	private static String API_KEY = "RGAPI-91166597-36e6-426f-8fbc-2b137f4055c8";
	public boolean bSuccess = true;
	public PuuidDto puuid = new PuuidDto();
	public ArrayList<String> gameIds = new ArrayList<String>();
	public ArrayList<MatchDto> matchInfos = new ArrayList<MatchDto>();
	public ArrayList<PlayerDto> playerRankInfo = new ArrayList<PlayerDto>();
	public SummonerDto summonerInfo = new SummonerDto();
	
	public TFTRecordProcessor(String playerId, String playerTag) {
		setPuuid(playerId, playerTag);
		if(bSuccess == true) {
			setPlayerRankInfo();
			setGameIds();
			setMatchInfos();
			setSummoner();
		}
	}
	public void setPuuid(String AC_ID, String AC_TAG) { // account id, account tag·Î puuid ¾ò±â
		String accountId = AC_ID;
		String accountTag = AC_TAG;
		try {
			if (AC_ID.matches(".*[¤¡-¤¾¤¿-¤Ó°¡-ÆR]+.*")) {
				accountId = URLEncoder.encode(accountId, StandardCharsets.UTF_8.name());
			}
			if (AC_TAG.matches(".*[¤¡-¤¾¤¿-¤Ó°¡-ÆR]+.*")) {
				accountTag = URLEncoder.encode(accountTag, StandardCharsets.UTF_8.name());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String API_URL = String.format(
				"https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/%s/%s?api_key=%s", accountId,
				accountTag, API_KEY);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			this.puuid = restTemplate.getForObject(uri, PuuidDto.class);
		} catch (URISyntaxException|HttpClientErrorException e) {
			this.bSuccess = false;
			e.printStackTrace();
		}
		// puuid
		// f98WWOqUGgb4fJw5YoM_EIi5ylBtG2gBNjnufiPE28COchIKm0kFBTjZSuQvZ8pitMZxLXC3feDw2A
	}

	public void setGameIds() {
		// puuid·Î gameIds ¾ò±â
		int nCount = 5;
		String API_URL = String.format(
				"https://asia.api.riotgames.com/tft/match/v1/matches/by-puuid/%s/ids?start=0&count=%d&api_key=%s",
				puuid.puuid, nCount, API_KEY);
		RestTemplate restTemplate = new RestTemplate();
		try {
			URI uri = new URI(API_URL);
			ResponseEntity<ArrayList<String>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<ArrayList<String>>() {
					});
			this.gameIds = response.getBody();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void setMatchInfos() {
		// gameId·Î matchInfo¾ò±â
		RestTemplate restTemplate = new RestTemplate();
		ArrayList<MatchDto> matchInfos = new ArrayList<MatchDto>();
		for (int i = 0; i < gameIds.size(); i++) {
			String API_URL = String.format("https://asia.api.riotgames.com/tft/match/v1/matches/%s?api_key=%s",
					gameIds.get(i), API_KEY);
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

	public void setPlayerRankInfo() {
		String API_URL = String.format(
		"https://kr.api.riotgames.com/tft/league/v1/by-puuid/%s?api_key=%s", puuid.puuid, API_KEY);
		RestTemplate restTemplate = new RestTemplate();
		try {
			URI uri = new URI(API_URL);
			ResponseEntity<ArrayList<PlayerDto>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<ArrayList<PlayerDto>>() {
					});
			playerRankInfo = response.getBody();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	public void setSummoner() {
		String API_URL = String.format(
		"https://kr.api.riotgames.com/tft/summoner/v1/summoners/by-puuid/%s?api_key=%s"
		, puuid.puuid, API_KEY);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			this.summonerInfo = restTemplate.getForObject(uri, SummonerDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
