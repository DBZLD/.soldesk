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
	public boolean bSuccess = true;
	public String latestVersion = setLatestVersion();
	private TFTApiProcessor tap = new TFTApiProcessor(latestVersion);
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
	public String setLatestVersion() {
		ArrayList<String> versionList = new ArrayList<String>();
		String API_URL = "https://ddragon.leagueoflegends.com/api/versions.json";
		RestTemplate restTemplate = new RestTemplate();
		try {
			URI uri = new URI(API_URL);
			ResponseEntity<ArrayList<String>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<ArrayList<String>>() {
					});
			versionList = response.getBody();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return versionList.get(0);
	}
	public void setPuuidDto(String AC_ID, String AC_TAG) { // account id, account tag로 puuid 얻기
		String accountId = AC_ID;
		String accountTag = AC_TAG;
		// id 또는 tag가 한글, 한자, 일본어일때 URL 인코딩 해야함
		try {
			if (AC_ID.matches(".*[\\uAC00-\\uD7A3\\u1100-\\u11FF\\u3130-\\u318F\\u3040-\\u309F\\u30A0-\\u30FF\\u4E00-\\u9FFF]+.*")) {
			    accountId = URLEncoder.encode(accountId, StandardCharsets.UTF_8.name());
			}
			if (AC_TAG.matches(".*[\\uAC00-\\uD7A3\\u1100-\\u11FF\\u3130-\\u318F\\u3040-\\u309F\\u30A0-\\u30FF\\u4E00-\\u9FFF]+.*")) {
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
}
