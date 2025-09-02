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

import com.spring.util.Common;
import com.spring.util.ProfileDto;
import com.spring.util.PuuidDto;

public class LOLRecordProcessor {
	public boolean bSuccess = true; 									// 올바른 요청 여부
	public String latestVersion = setLatestVersion(); 					// 최신 버전
	public LOLApiProcessor lap = new LOLApiProcessor(latestVersion); 	// 라이엇 API JSON 데이터
	public PuuidDto puuidDto = new PuuidDto(); 							// 라이엇 API puuid JSON 데이터
	public ArrayList<String> matchIds = new ArrayList<>(); 				// 라이엇 API matchId 배열
	public ProfileDto profileDto = new ProfileDto(); 					// 라이엇 API profile JSON 데이터
	
	// 플레이어 id, tag를 받아서 bSuccess를 설정하고 JSON 데이터를 만드는 생성자 함수
	public LOLRecordProcessor(String playerId, String playerTag) {
		// 라이엇 API에서 플레이어 id, tag를 이용해서 puuid를 받으면 bSuccess를 true로 설정
		setPuuidDto(playerId, playerTag);
		// bSuccess가 true일때만 나머지 JSON 데이터들을 받아옴
		if (bSuccess == true) {
			setMatchIds();
			setProfileDto();
		}
	}

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
	//puuid로 라이엇 API에서 profileDto JSON 데이터를 얻어오는 함수
	public void setProfileDto() {
		//API_URL 할당
		String API_URL = String.format("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/%s?api_key=%s",
				puuidDto.puuid, Common.API_KEY);
		//RestTemplate(Spring에서의 HTTP 통신 도구) 생성
		RestTemplate restTemplate = new RestTemplate();
		//API_URL 접속 후 받아온 JSON 데이터를 profileDto에 할당
		try {
			URI uri = new URI(API_URL);
			this.profileDto = restTemplate.getForObject(uri, ProfileDto.class);
		} catch (URISyntaxException e) {
			//요청이 잘못되었을 경우 예외 처리
			e.printStackTrace();
		}
	}
}
