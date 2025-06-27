package com.spring.service;

import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
import com.spring.dto.tft.regalia.Image;
import com.spring.dto.tft.queue.QueueDto;
import com.spring.dto.tft.regalia.RegaliaDto;

import lombok.extern.log4j.Log4j;

@Log4j
public class HistoryInfosProcessor {

	public String API_KEY = "RGAPI-f7d19d53-6a1d-4f45-ac9e-d170feafe555";
	public PuuidDto puuid = new PuuidDto();
	public ArrayList<String> gameIds = new ArrayList<String>();
	public ArrayList<MatchDto> matchInfos = new ArrayList<MatchDto>();
	public ArrayList<PlayerDto> playerInfo = new ArrayList<PlayerDto>();
	public QueueDto queue = new QueueDto();
	public RegaliaDto regalia = new RegaliaDto();

	public HistoryInfosProcessor(String playerId, String playerTag) {
		setPuuid(playerId, playerTag);
		setPlayerInfo();
		setGameIds();
		setMatchInfos();
		setQueue();
		setRegalia();

	}

	public int findRankIndex(String rankType) {
		ArrayList<String> queueTypeList = new ArrayList<>();
		for (int i = 0; i < playerInfo.size(); i++) {
			queueTypeList.add(playerInfo.get(i).queueType);
		}
		int pIndex = queueTypeList.indexOf(rankType);
		return pIndex;
	}

	public String getPlayerRankInfo(String rankType) {
		String rankInfo = "";
		int pIndex = findRankIndex(rankType);

		rankInfo += getRankRegaliaImg(rankType, pIndex);
		if (pIndex == -1) {
			rankInfo += "ÀüÀû ¾øÀ½";
			return rankInfo;
		}
		rankInfo += playerInfo.get(pIndex).tier + " ";
		rankInfo += playerInfo.get(pIndex).rank + " ";
		rankInfo += playerInfo.get(pIndex).leaguePoints + "LP<br>";
		rankInfo += playerInfo.get(pIndex).wins + "½Â ";
		rankInfo += playerInfo.get(pIndex).losses + "ÆÐ";
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
		if (gameDate.get(Calendar.YEAR) != nowDate.get(Calendar.YEAR)) {
			stDate = Integer.toString(nowDate.get(Calendar.YEAR) - gameDate.get(Calendar.YEAR)) + "³â Àü";
		} else if (gameDate.get(Calendar.MONTH) != nowDate.get(Calendar.MONTH)) {
			stDate = Integer.toString(nowDate.get(Calendar.MONTH) - gameDate.get(Calendar.MONTH)) + "´Þ Àü";
		} else if (gameDate.get(Calendar.DAY_OF_MONTH) != nowDate.get(Calendar.DAY_OF_MONTH)) {
			stDate = Integer.toString(nowDate.get(Calendar.DAY_OF_MONTH) - gameDate.get(Calendar.DAY_OF_MONTH)) + "ÀÏ Àü";
		} else if (gameDate.get(Calendar.HOUR_OF_DAY) != nowDate.get(Calendar.HOUR_OF_DAY)) {
			stDate = Integer.toString(nowDate.get(Calendar.HOUR_OF_DAY) - gameDate.get(Calendar.HOUR_OF_DAY)) + "½Ã°£ Àü";
		} else if (gameDate.get(Calendar.MINUTE) != nowDate.get(Calendar.MINUTE)) {
			stDate = Integer.toString(nowDate.get(Calendar.MINUTE) - gameDate.get(Calendar.MINUTE)) + "ºÐ Àü";
		} else {
			stDate = "¹æ±Ý Àü";
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
		String queueId = "Q" + matchInfos.get(mIndex).info.queueId;
		String name = "";
		try {
			Object objData = queue.data;
			Field fieldQueue = objData.getClass().getDeclaredField(queueId);
			fieldQueue.setAccessible(true);
			Object objQueue = fieldQueue.get(objData);

			Field fieldName = objQueue.getClass().getDeclaredField("name");
			fieldQueue.setAccessible(true);
			name = (String) fieldName.get(objQueue);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		return name;
	}

	public String getRankRegaliaImg(String rankType, int pIndex) {
		if (pIndex == -1) {
			return String.format("<img class = \"%s\" alt=\"%s\" src=\"%s\">",
			"tft-regalia", "tft-regalia", getImageURL("tft-regalia", "TFT_Regalia_Provisional.png"));
		}
		String url = "";
		String pTier = "";
		pTier = playerInfo.get(pIndex).tier;
		
		try {
			Object objData = regalia.data;
			Field fieldRank = objData.getClass().getDeclaredField(rankType);
			fieldRank.setAccessible(true);
			Object objRank = fieldRank.get(objData);

			Field fieldTier = objRank.getClass().getDeclaredField(pTier);
			fieldTier.setAccessible(true);
			Object objTier = fieldTier.get(objRank);

			Field fieldImage = objTier.getClass().getDeclaredField("image");
			fieldImage.setAccessible(true);
			Object objImage = fieldImage.get(objTier);

			Image image = (Image) objImage;
			url = String.format("<img class = \"%s\" alt=\"%s\" src=\"%s\">",
				  regalia.type, regalia.type, getImageURL(regalia.type, image.full));
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		return url;
	}

	public int findPlayer(int mIndex, String puuid) {
		int pIndex = matchInfos.get(mIndex).metadata.participants.indexOf(puuid);
		return pIndex;
	}

	public String getMatchPlacement(int mIndex) {
		String gamePlacement = Integer.toString(
				matchInfos.get(mIndex).info.participants.get(findPlayer(mIndex, puuid.puuid)).placement) + "µî";
		return gamePlacement;
	}

	public String getMatchTime(int mIndex) {
		int time = (int) matchInfos.get(mIndex).info.participants.get(findPlayer(mIndex, puuid.puuid)).time_eliminated;
		int nMin = time / 60;
		int nSec = time % 60;
		String gameTime = String.format("%dºÐ %dÃÊ", nMin, nSec);
		return gameTime;
	}

	public String getImageURL(String imageType, String imageId) {
		String imageURL = String.format("https://ddragon.leagueoflegends.com/cdn/15.12.1/img/%s/%s", imageType,
				imageId);
		return imageURL;
	}

	// »ý¼º ½Ã ÇÔ¼ö
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
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		this.puuid = restTemplate.getForObject(uri, PuuidDto.class);
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

	public void setPlayerInfo() {
		String API_URL = String.format("https://kr.api.riotgames.com/tft/league/v1/by-puuid/%s?api_key=%s", puuid.puuid,
				API_KEY);
		RestTemplate restTemplate = new RestTemplate();
		try {
			URI uri = new URI(API_URL);
			ResponseEntity<ArrayList<PlayerDto>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<ArrayList<PlayerDto>>() {
					});
			playerInfo = response.getBody();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void setQueue() {
		String API_URL = "https://ddragon.leagueoflegends.com/cdn/15.12.1/data/ko_KR/tft-queues.json";
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		queue = restTemplate.getForObject(uri, QueueDto.class);
	}

	public void setRegalia() {
		String API_URL = "https://ddragon.leagueoflegends.com/cdn/15.12.1/data/ko_KR/tft-regalia.json";
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		regalia = restTemplate.getForObject(uri, RegaliaDto.class);
	}
}
