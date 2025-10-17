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
import com.spring.dto.tft.TFTRankDto;
import com.spring.dto.tft.TFTMatchInfo;
import com.spring.dto.tft.TFTPlayerProfileInfo;
import com.spring.dto.tft.TFTPlayerRankInfos;
import com.spring.util.PuuidDto;
import com.spring.util.Common;
import com.spring.util.ProfileDto;

import lombok.extern.log4j.Log4j;

@Log4j
public class TFTRecordProcessor {
	public boolean bSuccess = true;										// 올바른 요청 여부
	private String latestVersion = setLatestVersion();					// 최신 버전
	private TFTApiProcessor tap = new TFTApiProcessor(latestVersion);	// 라이엇 API JSON 데이터
	private PuuidDto puuidDto = new PuuidDto();							// 라이엇 API puuid JSON 데이터
	private ArrayList<String> matchIds = new ArrayList<>();				// 라이엇 API matchId 배열
	private ArrayList<MatchDto> matchDto = new ArrayList<>();			// 라이엇 API match JSON 데이터
	private ArrayList<TFTRankDto> rankDto = new ArrayList<>();				// 라이엇 API rank JSON 데이터
	private ProfileDto profileDto = new ProfileDto();					// 라이엇 API profile JSON 데이터
	
	public TFTPlayerRankInfos playerRankInfo = new TFTPlayerRankInfos();		// API 정리, 번역한 플레이어 랭크 JSON 데이터
	public TFTPlayerProfileInfo playerProfileInfo = new TFTPlayerProfileInfo();	// API 정리, 번역한 플레이어 프로필 JSON 데이터
	public ArrayList<TFTMatchInfo> matchInfo = new ArrayList<>();				// API 정리, 번역한 매치 JSON 데이터
	
	// 플레이어 id, tag를 받아서 bSuccess를 설정하고 JSON 데이터를 만드는 생성자 함수
	public TFTRecordProcessor(String playerId, String playerTag) {
		// 라이엇 API에서 플레이어 id, tag를 이용해서 puuid를 받으면 bSuccess를 true로 설정
		setPuuidDto(playerId, playerTag);
		// bSuccess가 true일때만 나머지 JSON 데이터들을 받아옴
		if (bSuccess == true) {
			setMatchIds();			// 라이엇 API에서 puuid를 이용해서 matchIds JSON 데이터를 받아옴
			setRankDto();			// 라이엇 API에서 puuid를 이용해서 rankDto JSON 데이터를 받아옴
			setMatchDto();			// 라이엇 API에서 matchIds를 이용해서 matchDto JSON 데이터를 받아옴
			setProfileDto();		// 라이엇 API에서 puuid를 이용해서 profileDto JSON 데이터를 받아옴

			setPlayerRankInfo();	// rankDto를 이용해서 playerRankInfo JSON 데이터를 만들어냄
			setPlayerProfileInfo();	// profileDto를 이용해서 playerProfileInfo JSON 데이터를 만들어냄
			setMatchInfos();			// matcDto를 이요애서 matchDto JSON 데이터를 만들어냄
		}
	}
	
	// 라이엇 API에서 최신 버전을 받아오는 함수
	public String setLatestVersion() {
		ArrayList<String> versionList = new ArrayList<String>();
		// API_URL 설정
		String API_URL = "https://ddragon.leagueoflegends.com/api/versions.json";
		// RestTemplate(Spring에서의 HTTP 통신 도구) 생성
		RestTemplate restTemplate = new RestTemplate();
		// API_URL링크로 들어간 후 JSON데이터를 받아서 versionList에 할당
		try {
			URI uri = new URI(API_URL);
			ResponseEntity<ArrayList<String>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<ArrayList<String>>() {
					});
			versionList = response.getBody();
		} catch (URISyntaxException e) {
			// 요청이 잘못되었을 경우 예외 처리
			e.printStackTrace();
		}
		// 배열의 1번째 값(최신 버전)을 반환
		return versionList.get(0);
	}
	
	// 플레이어 id, tag를 받아온 후 라이엇 API에서 puuid JSON 데이터를 받아오는 함수
	public void setPuuidDto(String AC_ID, String AC_TAG) { 
		String accountId = AC_ID;
		String accountTag = AC_TAG;
		// id 또는 tag가 한글, 한자, 일본어일때 URL 인코딩
		try {
			// 유니코드 정규식 범위를 이용해서 아이디가 일치한다면 URL 인코딩 
			if (AC_ID.matches(".*[\\uAC00-\\uD7A3\\u1100-\\u11FF\\u3130-\\u318F\\u3040-\\u309F\\u30A0-\\u30FF\\u4E00-\\u9FFF]+.*")) {
			    accountId = URLEncoder.encode(accountId, StandardCharsets.UTF_8.name());
			}
			// 유니코드 정규식 범위를 이용해서 태그가 일치한다면 URL 인코딩 
			if (AC_TAG.matches(".*[\\uAC00-\\uD7A3\\u1100-\\u11FF\\u3130-\\u318F\\u3040-\\u309F\\u30A0-\\u30FF\\u4E00-\\u9FFF]+.*")) {
			    accountTag = URLEncoder.encode(accountTag, StandardCharsets.UTF_8.name());
			}
		} catch (Exception e) {
			// 요청이 잘못되었을 경우 예외 처리
			e.printStackTrace();
		}
		// API_URL 할당
		String API_URL = String.format(
				"https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/%s/%s?api_key=%s", accountId,
				accountTag, Common.API_KEY);
		// RestTemplate(Spring에서의 HTTP 통신 도구) 생성
		RestTemplate restTemplate = new RestTemplate();
		// API_URL로 접속 후 puuidDto에 JSON 데이터 값 할당
		try {
			URI uri = new URI(API_URL);
			this.puuidDto = restTemplate.getForObject(uri, PuuidDto.class);
		} catch (URISyntaxException | HttpClientErrorException e) {
			// 요청이 잘못되었을 경우 bSuccess = false
			this.bSuccess = false;
			e.printStackTrace();
		}
		// test용 puuid:f98WWOqUGgb4fJw5YoM_EIi5ylBtG2gBNjnufiPE28COchIKm0kFBTjZSuQvZ8pitMZxLXC3feDw2A
	}

	// puuid값으로 라이엇 API에서 matchIds JSON 데이터를 얻어오는 함수
	public void setMatchIds() {
		// API_URL 할당
		String API_URL = String.format(
				"https://asia.api.riotgames.com/tft/match/v1/matches/by-puuid/%s/ids?start=0&startTime=%s&count=%d&api_key=%s",
				puuidDto.puuid, Common.SET15_START, Common.MATCH_COUNT, Common.API_KEY);
		// RestTemplate(Spring에서의 HTTP 통신 도구) 생성
		RestTemplate restTemplate = new RestTemplate();
		// API_URL로 접속 후 matchIds에 JSON 데이터 할당
		try {
			URI uri = new URI(API_URL);
			ResponseEntity<ArrayList<String>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<ArrayList<String>>() {
					});
			this.matchIds = response.getBody();
		} catch (URISyntaxException e) {
			// 요청이 잘못되었을 경우 예외 처리
			e.printStackTrace();
		}
		// test용 matchId : KR_7769892440
	}

	// matchIds로 라이엇 API에서 matchDto JSON 데이터를 얻어오는 함수
	public void setMatchDto() {
		// RestTemplate(Spring에서의 HTTP 통신 도구) 생성
		RestTemplate restTemplate = new RestTemplate();
		// matchInfos 생성
		ArrayList<MatchDto> matchInfos = new ArrayList<MatchDto>();
		// 받아온 matchIds의 크기만큼 반복
		for (int i = 0; i < matchIds.size(); i++) {
			// API_URL 할당
			String API_URL = String.format("https://asia.api.riotgames.com/tft/match/v1/matches/%s?api_key=%s",
					matchIds.get(i), Common.API_KEY);
			// API_URL에 접속해서 받아온 JSON 데이터를 matchInfo에 할당 후 matchInfo를 matchInfos에 추가
			try {
				URI uri = new URI(API_URL);
				MatchDto matchInfo = restTemplate.getForObject(uri, MatchDto.class);
				matchInfos.add(matchInfo);
			} catch (URISyntaxException e) {
				// 요청이 잘못되었을 경우 예외 처리
				e.printStackTrace();
			}
		}
		// matchInfos의 값을 matchDto에 할당
		this.matchDto = matchInfos;
	}

	// puuid로 라이엇 API에서 rankDto JSON 데이터를 얻어오는 함수
	public void setRankDto() {
		// API_URL 할당
		String API_URL = String.format("https://kr.api.riotgames.com/tft/league/v1/by-puuid/%s?api_key=%s",
				puuidDto.puuid, Common.API_KEY);
		// RestTemplate(Spring에서의 HTTP 통신 도구) 생성
		RestTemplate restTemplate = new RestTemplate();
		// API_URL로 접속 후 받아온 JSON 데이터를 rankDto에 할당
		try {
			URI uri = new URI(API_URL);
			ResponseEntity<ArrayList<TFTRankDto>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<ArrayList<TFTRankDto>>() {
					});
			rankDto = response.getBody();
		} catch (URISyntaxException e) {
			// 요청이 잘못되었을 경우 예외 처리
			e.printStackTrace();
		}
	}

	// puuid로 라이엇 API에서 profileDto JSON 데이터를 얻어오는 함수
	public void setProfileDto() {
		// API_URL 할당
		String API_URL = String.format("https://kr.api.riotgames.com/tft/summoner/v1/summoners/by-puuid/%s?api_key=%s",
				puuidDto.puuid, Common.API_KEY);
		// RestTemplate(Spring에서의 HTTP 통신 도구) 생성
		RestTemplate restTemplate = new RestTemplate();
		// API_URL 접속 후 받아온 JSON 데이터를 profileDto에 할당
		try {
			URI uri = new URI(API_URL);
			this.profileDto = restTemplate.getForObject(uri, ProfileDto.class);
		} catch (URISyntaxException e) {
			// 요청이 잘못되었을 경우 예외 처리
			e.printStackTrace();
		}
	}
	
	// rankDto를 이용해서 번역 및 필요한 정보를 모아 정리한 playerRankInfo를 설정하는 함수
	public void setPlayerRankInfo() {
		playerRankInfo = new TFTPlayerRankInfos(
			getRank(Common.TFT_RANK), getRank(Common.TFT_DOUBLE_UP), getRank(Common.TFT_TURBO), tap
		);
	}
	
	// rankDto의 정보 중 queueType에 맞는 정보를 반환
	private TFTRankDto getRank(String queueType) {
		// queueType에 맞는 정보의 index를 받아옴(비존재시 -1 반환)
		int index = findRankIndex(queueType);
		
		// 존재한다면 rankDto[index]를 반환
		if (index != -1) {
			return rankDto.get(index);
		}
		// 존재하지 않다면 provisional(랭크 없음)객체를 만들어서 반환
		TFTRankDto provisional = new TFTRankDto();
		provisional.queueType = queueType;
		
		if(queueType.equals(Common.TFT_TURBO)){
			// queueType이 turbo라면 ratedTier의 값을 UNRATED(PROVISIONAL)로 할당
			provisional.ratedTier = Common.UNRATED;
		}else {
			// queueType이 turbo가 아니라면 tier의 값을 UNRATED(PROVISIONAL)로 할당
			provisional.tier = Common.UNRATED;			
		}
		
		return provisional;
	}
	// rankDto에서 rankType에 맞는 정보의 index를 받아오는 함수(비존재시 -1 반환)
	public int findRankIndex(String rankType) {
		// 빈 String 배열 생성
		ArrayList<String> queueTypeList = new ArrayList<>();
		// rankDto의 크기만큼 queueTypeList에 rankDto.queueType을 할당
		for (int i = 0; i < rankDto.size(); i++) {
			queueTypeList.add(rankDto.get(i).queueType);
		}
		// rankType과 일치하는 값의 queueTypeList배열 index를 할당(비존재시 -1 할당)
		int pIndex = queueTypeList.indexOf(rankType);
		
		return pIndex;
	}

	// profile, puuidDto를 이용해서 번역 및 필요한 정보들만 모아 정리한 playerProfileInfo를 설정하는 함수
	public void setPlayerProfileInfo() {
		playerProfileInfo = new TFTPlayerProfileInfo(profileDto, puuidDto, tap);
	}

	// matchDto, puuid를 이용해서 번역 및 필요한 정보들만 모아 정리한 matchInfos를 설정하는 함수
	public void setMatchInfos() {
		for (int i = 0; i < matchIds.size(); i++) {
			matchInfo.add(new TFTMatchInfo(matchDto.get(i), puuidDto.puuid));
		}
	}
}
