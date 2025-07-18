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
import com.spring.dto.tft.RankDto;
import com.spring.tft.TFTMatchInfo;
import com.spring.tft.TFTPlayerProfileInfo;
import com.spring.tft.TFTPlayerRankInfos;
import com.spring.util.PuuidDto;
import com.spring.util.Common;
import com.spring.util.ProfileDto;

import lombok.extern.log4j.Log4j;

@Log4j
public class TFTRecordProcessor {
	private TFTApiProcessor tap = new TFTApiProcessor(Common.LATEST_VERSIONS);
	public boolean bSuccess = true;
	private PuuidDto puuidDto = new PuuidDto();
	private ArrayList<String> matchIds = new ArrayList<>();
	private ArrayList<MatchDto> matchDto = new ArrayList<>();
	private ArrayList<RankDto> rankDto = new ArrayList<>();
	private ProfileDto profileDto = new ProfileDto();
	
	public TFTPlayerRankInfos playerRankInfo = new TFTPlayerRankInfos();
	public TFTPlayerProfileInfo playerProfileInfo = new TFTPlayerProfileInfo();
	public ArrayList<TFTMatchInfo> matchInfo = new ArrayList<>();

	public TFTRecordProcessor(String playerId, String playerTag) {
		setPuuidDto(playerId, playerTag);
		if (bSuccess == true) {
			setGameIds();
			setPlayerRankDto();
			setMatchDto();
			setProfileDto();

			setPlayerRankInfo();
			setPlayerProfileInfo();
			setMatchInfo();
		}
	}

	public void setPuuidDto(String AC_ID, String AC_TAG) { // account id, account tag로 puuid 얻기
		String accountId = AC_ID;
		String accountTag = AC_TAG;
		// id 또는 tag가 한글일때 URL 인코딩 해야함
		try {
			if (AC_ID.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
				accountId = URLEncoder.encode(accountId, StandardCharsets.UTF_8.name());
			}
			if (AC_TAG.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
				accountTag = URLEncoder.encode(accountTag, StandardCharsets.UTF_8.name());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String API_URL = String.format(
				"https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/%s/%s?api_key=%s", accountId,
				accountTag, Common.API_KEY);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			this.puuidDto = restTemplate.getForObject(uri, PuuidDto.class);
		} catch (URISyntaxException | HttpClientErrorException e) {
			this.bSuccess = false;
			e.printStackTrace();
		}
		// puuid
		// f98WWOqUGgb4fJw5YoM_EIi5ylBtG2gBNjnufiPE28COchIKm0kFBTjZSuQvZ8pitMZxLXC3feDw2A
	}

	public void setGameIds() {
		// puuid로 gameIds 얻기
		String API_URL = String.format(
				"https://asia.api.riotgames.com/tft/match/v1/matches/by-puuid/%s/ids?start=0&count=%d&api_key=%s",
				puuidDto.puuid, Common.MATCH_COUNT, Common.API_KEY);
		RestTemplate restTemplate = new RestTemplate();
		try {
			URI uri = new URI(API_URL);
			ResponseEntity<ArrayList<String>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<ArrayList<String>>() {
					});
			this.matchIds = response.getBody();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void setMatchDto() {
		// gameId로 matchInfo얻기
		RestTemplate restTemplate = new RestTemplate();
		ArrayList<MatchDto> matchInfos = new ArrayList<MatchDto>();
		for (int i = 0; i < matchIds.size(); i++) {
			String API_URL = String.format("https://asia.api.riotgames.com/tft/match/v1/matches/%s?api_key=%s",
					matchIds.get(i), Common.API_KEY);
			try {
				URI uri = new URI(API_URL);
				MatchDto matchInfo = restTemplate.getForObject(uri, MatchDto.class);
				matchInfos.add(matchInfo);
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
		this.matchDto = matchInfos;
	}

	public void setPlayerRankDto() {
		//puuid로 플레이어 랭크 정보 얻기
		String API_URL = String.format("https://kr.api.riotgames.com/tft/league/v1/by-puuid/%s?api_key=%s",
				puuidDto.puuid, Common.API_KEY);
		RestTemplate restTemplate = new RestTemplate();
		try {
			URI uri = new URI(API_URL);
			ResponseEntity<ArrayList<RankDto>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<ArrayList<RankDto>>() {
					});
			rankDto = response.getBody();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void setProfileDto() {
		//puuid로 플레이어 프로필 정보 얻기
		String API_URL = String.format("https://kr.api.riotgames.com/tft/summoner/v1/summoners/by-puuid/%s?api_key=%s",
				puuidDto.puuid, Common.API_KEY);
		URI uri = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			uri = new URI(API_URL);
			this.profileDto = restTemplate.getForObject(uri, ProfileDto.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void setPlayerRankInfo() { // 플레이어 랭크 정보 재정리
		playerRankInfo = new TFTPlayerRankInfos(
			getRank(Common.TFT_RANK), getRank(Common.TFT_DOUBLE_UP), getRank(Common.TFT_TURBO), tap
		);
	}
	private RankDto getRank(String queueType) {
		int index = findRankIndex(queueType);
		
		if (index != -1) {
			return rankDto.get(index);
		}
		RankDto provisional = new RankDto();
		provisional.queueType = queueType;
		
		if(queueType.equals(Common.TFT_TURBO)){
			provisional.ratedTier = Common.UNRATED;
		}else {
			provisional.tier = Common.UNRATED;			
		}
		
		return provisional;
	}
	public int findRankIndex(String rankType) {
		//랭크 타입 받아서 타입 일치하는 rankDto인덱스 받아오기(없으면 -1반환)
		ArrayList<String> queueTypeList = new ArrayList<>();
		for (int i = 0; i < rankDto.size(); i++) {
			queueTypeList.add(rankDto.get(i).queueType);
		}
		int pIndex = queueTypeList.indexOf(rankType);
		return pIndex;
	}

	public void setPlayerProfileInfo() {
		//플레이어 프로필 정보 재정리
		playerProfileInfo = new TFTPlayerProfileInfo(profileDto, puuidDto, tap);
	}

	public void setMatchInfo() {
		// 매치 정보 재정리
		for (int i = 0; i < matchIds.size(); i++) {
			matchInfo.add(new TFTMatchInfo(matchDto.get(i), playerProfileInfo.puuid));
		}
	}

//public String getMatchDate(int mIndex) {
//	long unixTime = matchInfos.get(mIndex).info.game_datetime;
//	Date date = new Date(unixTime);
//	Calendar gameDate = Calendar.getInstance();
//	gameDate.setTime(date);
//	Calendar nowDate = Calendar.getInstance();
//	String stDate = "";
//	if (gameDate.get(Calendar.YEAR) != nowDate.get(Calendar.YEAR)) {
//		stDate = Integer.toString(nowDate.get(Calendar.YEAR) - gameDate.get(Calendar.YEAR)) + "년 전";
//	} else if (gameDate.get(Calendar.MONTH) != nowDate.get(Calendar.MONTH)) {
//		stDate = Integer.toString(nowDate.get(Calendar.MONTH) - gameDate.get(Calendar.MONTH)) + "달 전";
//	} else if (gameDate.get(Calendar.DAY_OF_MONTH) != nowDate.get(Calendar.DAY_OF_MONTH)) {
//		stDate = Integer.toString(nowDate.get(Calendar.DAY_OF_MONTH) - gameDate.get(Calendar.DAY_OF_MONTH)) + "일 전";
//	} else if (gameDate.get(Calendar.HOUR_OF_DAY) != nowDate.get(Calendar.HOUR_OF_DAY)) {
//		stDate = Integer.toString(nowDate.get(Calendar.HOUR_OF_DAY) - gameDate.get(Calendar.HOUR_OF_DAY)) + "시간 전";
//	} else if (gameDate.get(Calendar.MINUTE) != nowDate.get(Calendar.MINUTE)) {
//		stDate = Integer.toString(nowDate.get(Calendar.MINUTE) - gameDate.get(Calendar.MINUTE)) + "분 전";
//	} else {
//		stDate = "방금 전";
//	}
//	return stDate;
//}
//
//public String getMatchPlayerName(int mIndex, int pIndex) {
//	String name = "";
//	name += matchInfos.get(mIndex).info.participants.get(pIndex).riotIdGameName + "#";
//	name += matchInfos.get(mIndex).info.participants.get(pIndex).riotIdTagline;
//	return name;
//}
//
//public String getMatchType(int mIndex) {
//	String queueId = "Q" + matchInfos.get(mIndex).info.queueId;
//	String name = "";
//	try {
//		Object objData = queue.data;
//		Field fieldQueue = objData.getClass().getDeclaredField(queueId);
//		fieldQueue.setAccessible(true);
//		Object objQueue = fieldQueue.get(objData);
//
//		Field fieldName = objQueue.getClass().getDeclaredField("name");
//		fieldQueue.setAccessible(true);
//		name = (String) fieldName.get(objQueue);
//	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
//		e.printStackTrace();
//	}
//	return name;
//}
//
//public String getRankRegaliaImg(String rankType, int pIndex) {
//	if (pIndex == -1) {
//		return String.format("<img class = \"%s\" alt=\"%s\" src=\"%s\">",
//		"tft-regalia", "tft-regalia", getImageURL("tft-regalia", "TFT_Regalia_Provisional.png"));
//	}
//	String url = "";
//	String pTier = "";
//	pTier = playerInfo.get(pIndex).tier;
//	
//	try {
//		Object objData = regalia.data;
//		Field fieldRank = objData.getClass().getDeclaredField(rankType);
//		fieldRank.setAccessible(true);
//		Object objRank = fieldRank.get(objData);
//
//		Field fieldTier = objRank.getClass().getDeclaredField(pTier);
//		fieldTier.setAccessible(true);
//		Object objTier = fieldTier.get(objRank);
//
//		Field fieldImage = objTier.getClass().getDeclaredField("image");
//		fieldImage.setAccessible(true);
//		Object objImage = fieldImage.get(objTier);
//
//		Image image = (Image) objImage;
//		url = String.format("<img class = \"%s\" alt=\"%s\" src=\"%s\">",
//			  regalia.type, regalia.type, getImageURL(regalia.type, image.full));
//	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
//		e.printStackTrace();
//	}
//	return url;
//}
//
//public int findPlayer(int mIndex, String puuid) {
//	int pIndex = matchInfos.get(mIndex).metadata.participants.indexOf(puuid);
//	return pIndex;
//}
//
//public String getMatchPlacement(int mIndex) {
//	String gamePlacement = Integer.toString(
//			matchInfos.get(mIndex).info.participants.get(findPlayer(mIndex, puuid.puuid)).placement) + "등";
//	return gamePlacement;
//}
//
//public String getMatchTime(int mIndex) {
//	int time = (int) matchInfos.get(mIndex).info.participants.get(findPlayer(mIndex, puuid.puuid)).time_eliminated;
//	int nMin = time / 60;
//	int nSec = time % 60;
//	String gameTime = String.format("%d분 %d초", nMin, nSec);
//	return gameTime;
//}
}
