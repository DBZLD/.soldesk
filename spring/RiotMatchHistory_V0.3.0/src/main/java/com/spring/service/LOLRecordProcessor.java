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

import com.spring.dto.lol.LOLRankDto;
import com.spring.dto.lol.MatchDto;
import com.spring.dto.lol.MatchTimeLineDto;
import com.spring.util.Common;
import com.spring.util.ProfileDto;
import com.spring.util.PuuidDto;

public class LOLRecordProcessor {
	private boolean bSuccess = true; 								 	// 올바른 요청 여부
	private String latestVersion = setLatestVersion(); 				 	// 최신 버전
	private LOLApiProcessor lap = new LOLApiProcessor(latestVersion); 	// 라이엇 API JSON 데이터
	private PuuidDto puuidDto = new PuuidDto(); 						// 라이엇 API puuid JSON 데이터
	private ArrayList<String> matchIds = new ArrayList<>(); 			// 라이엇 API matchId 배열
	private ArrayList<MatchDto> matchDto = new ArrayList<>(); 		 	// 라이엇 API match JSON 데이터
	private ArrayList<LOLRankDto> rankDto = new ArrayList<>();		 	// 라이엇 API rank JSON 데이터
	private ProfileDto profileDto = new ProfileDto(); 				 	// 라이엇 API profile JSON 데이터
	public ArrayList<MatchTimeLineDto> timeLineDto = new ArrayList<>(); // 라이엇 API timeline JSON 데이터
	
	// 플레이어 id, tag를 받아서 bSuccess를 설정하고 JSON 데이터를 만드는 생성자 함수
	public LOLRecordProcessor(String playerId, String playerTag) {
		// 라이엇 API에서 플레이어 id, tag를 이용해서 puuid를 받으면 bSuccess를 true로 설정
		setPuuidDto(playerId, playerTag);
		// bSuccess가 true일때만 나머지 JSON 데이터들을 받아옴
		if (bSuccess == true) {
			setMatchIds();
			setMatchDto();
			setProfileDto();
			setRankDto();
			setTimeLineDto();
		}
	}
	
	// 라이엇 api에서 최신 버전 가지고 오는 함수
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
			if (AC_ID.matches(
					".*[\\uAC00-\\uD7A3\\u1100-\\u11FF\\u3130-\\u318F\\u3040-\\u309F\\u30A0-\\u30FF\\u4E00-\\u9FFF]+.*")) {
				accountId = URLEncoder.encode(accountId, StandardCharsets.UTF_8.name());
			}
			// 유니코드 정규식 범위를 이용해서 태그가 일치한다면 URL 인코딩
			if (AC_TAG.matches(
					".*[\\uAC00-\\uD7A3\\u1100-\\u11FF\\u3130-\\u318F\\u3040-\\u309F\\u30A0-\\u30FF\\u4E00-\\u9FFF]+.*")) {
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
		// test용
		// puuid:f98WWOqUGgb4fJw5YoM_EIi5ylBtG2gBNjnufiPE28COchIKm0kFBTjZSuQvZ8pitMZxLXC3feDw2A
	}

	// puuid값으로 라이엇 API에서 matchIds JSON 데이터를 얻어오는 함수
	public void setMatchIds() {
		// API_URL 할당
		String API_URL = String.format(
				"https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/%s/ids?start=0&count=%d&api_key=%s",
				puuidDto.puuid, Common.MATCH_COUNT, Common.API_KEY);
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
		ArrayList<MatchDto> matchInfos = new ArrayList<MatchDto>();
		
		for (int i = 0; i < matchIds.size(); i++) {
			// API_URL 할당
			String API_URL = String.format("https://asia.api.riotgames.com/lol/match/v5/matches/%s?api_key=%s",
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
		String API_URL = String.format("https://kr.api.riotgames.com/lol/league/v4/entries/by-puuid/%s?api_key=%s",
				puuidDto.puuid, Common.API_KEY);
		// RestTemplate(Spring에서의 HTTP 통신 도구) 생성
		RestTemplate restTemplate = new RestTemplate();
		// API_URL로 접속 후 받아온 JSON 데이터를 rankDto에 할당
		try {
			URI uri = new URI(API_URL);
			ResponseEntity<ArrayList<LOLRankDto>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<ArrayList<LOLRankDto>>() {
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
		String API_URL = String.format("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/%s?api_key=%s",
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
	
	// puuid로 라이엇 API에서 timeLineDto JSON 데이터를 얻어오는 함수
	public void setTimeLineDto() {
		// RestTemplate(Spring에서의 HTTP 통신 도구) 생성
		RestTemplate restTemplate = new RestTemplate();
//		ArrayList<MatchTimeLineDto> timeLineList = new ArrayList<>();
		
//		for (int i = 0; i < matchIds.size(); i++) {
//			// API_URL 할당
			String API_URL = String.format("https://asia.api.riotgames.com/lol/match/v5/matches/%s/timeline?api_key=%s",
					"KR_7786901108", Common.API_KEY);
//			// API_URL에 접속해서 받아온 JSON 데이터를 timeLine에 할당 후 timeLine를 timeLineList에 추가
//			try {
//				URI uri = new URI(API_URL);
//				MatchTimeLineDto timeLine = restTemplate.getForObject(uri, MatchTimeLineDto.class);
//				timeLineList.add(timeLine);
//			} catch (URISyntaxException e) {
//				// 요청이 잘못되었을 경우 예외 처리
//				e.printStackTrace();
//			}
//		}
	}
}
