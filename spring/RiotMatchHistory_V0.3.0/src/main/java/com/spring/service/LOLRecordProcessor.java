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
	public boolean bSuccess = true; 									// �ùٸ� ��û ����
	public String latestVersion = setLatestVersion(); 					// �ֽ� ����
	public LOLApiProcessor lap = new LOLApiProcessor(latestVersion); 	// ���̾� API JSON ������
	public PuuidDto puuidDto = new PuuidDto(); 							// ���̾� API puuid JSON ������
	public ArrayList<String> matchIds = new ArrayList<>(); 				// ���̾� API matchId �迭
	public ProfileDto profileDto = new ProfileDto(); 					// ���̾� API profile JSON ������
	
	// �÷��̾� id, tag�� �޾Ƽ� bSuccess�� �����ϰ� JSON �����͸� ����� ������ �Լ�
	public LOLRecordProcessor(String playerId, String playerTag) {
		// ���̾� API���� �÷��̾� id, tag�� �̿��ؼ� puuid�� ������ bSuccess�� true�� ����
		setPuuidDto(playerId, playerTag);
		// bSuccess�� true�϶��� ������ JSON �����͵��� �޾ƿ�
		if (bSuccess == true) {
			setMatchIds();
			setProfileDto();
		}
	}

	public String setLatestVersion() {
		ArrayList<String> versionList = new ArrayList<String>();
		// API_URL ����
		String API_URL = "https://ddragon.leagueoflegends.com/api/versions.json";
		// RestTemplate(Spring������ HTTP ��� ����) ����
		RestTemplate restTemplate = new RestTemplate();
		// API_URL��ũ�� �� �� JSON�����͸� �޾Ƽ� versionList�� �Ҵ�
		try {
			URI uri = new URI(API_URL);
			ResponseEntity<ArrayList<String>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<ArrayList<String>>() {
					});
			versionList = response.getBody();
		} catch (URISyntaxException e) {
			// ��û�� �߸��Ǿ��� ��� ���� ó��
			e.printStackTrace();
		}
		// �迭�� 1��° ��(�ֽ� ����)�� ��ȯ
		return versionList.get(0);
	}

	// �÷��̾� id, tag�� �޾ƿ� �� ���̾� API���� puuid JSON �����͸� �޾ƿ��� �Լ�
	public void setPuuidDto(String AC_ID, String AC_TAG) {
		String accountId = AC_ID;
		String accountTag = AC_TAG;
		// id �Ǵ� tag�� �ѱ�, ����, �Ϻ����϶� URL ���ڵ�
		try {
			// �����ڵ� ���Խ� ������ �̿��ؼ� ���̵� ��ġ�Ѵٸ� URL ���ڵ�
			if (AC_ID.matches(
					".*[\\uAC00-\\uD7A3\\u1100-\\u11FF\\u3130-\\u318F\\u3040-\\u309F\\u30A0-\\u30FF\\u4E00-\\u9FFF]+.*")) {
				accountId = URLEncoder.encode(accountId, StandardCharsets.UTF_8.name());
			}
			// �����ڵ� ���Խ� ������ �̿��ؼ� �±װ� ��ġ�Ѵٸ� URL ���ڵ�
			if (AC_TAG.matches(
					".*[\\uAC00-\\uD7A3\\u1100-\\u11FF\\u3130-\\u318F\\u3040-\\u309F\\u30A0-\\u30FF\\u4E00-\\u9FFF]+.*")) {
				accountTag = URLEncoder.encode(accountTag, StandardCharsets.UTF_8.name());
			}
		} catch (Exception e) {
			// ��û�� �߸��Ǿ��� ��� ���� ó��
			e.printStackTrace();
		}
		// API_URL �Ҵ�
		String API_URL = String.format(
				"https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/%s/%s?api_key=%s", accountId,
				accountTag, Common.API_KEY);
		// RestTemplate(Spring������ HTTP ��� ����) ����
		RestTemplate restTemplate = new RestTemplate();
		// API_URL�� ���� �� puuidDto�� JSON ������ �� �Ҵ�
		try {
			URI uri = new URI(API_URL);
			this.puuidDto = restTemplate.getForObject(uri, PuuidDto.class);
		} catch (URISyntaxException | HttpClientErrorException e) {
			// ��û�� �߸��Ǿ��� ��� bSuccess = false
			this.bSuccess = false;
			e.printStackTrace();
		}
		// test��
		// puuid:f98WWOqUGgb4fJw5YoM_EIi5ylBtG2gBNjnufiPE28COchIKm0kFBTjZSuQvZ8pitMZxLXC3feDw2A
	}

	// puuid������ ���̾� API���� matchIds JSON �����͸� ������ �Լ�
	public void setMatchIds() {
		// API_URL �Ҵ�
		String API_URL = String.format(
				"https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/%s/ids?start=0&count=%d&api_key=%s",
				puuidDto.puuid, Common.MATCH_COUNT, Common.API_KEY);
		// RestTemplate(Spring������ HTTP ��� ����) ����
		RestTemplate restTemplate = new RestTemplate();
		// API_URL�� ���� �� matchIds�� JSON ������ �Ҵ�
		try {
			URI uri = new URI(API_URL);
			ResponseEntity<ArrayList<String>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<ArrayList<String>>() {
					});
			this.matchIds = response.getBody();
		} catch (URISyntaxException e) {
			// ��û�� �߸��Ǿ��� ��� ���� ó��
			e.printStackTrace();
		}
		// test�� matchId : KR_7769892440
	}
	//puuid�� ���̾� API���� profileDto JSON �����͸� ������ �Լ�
	public void setProfileDto() {
		//API_URL �Ҵ�
		String API_URL = String.format("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/%s?api_key=%s",
				puuidDto.puuid, Common.API_KEY);
		//RestTemplate(Spring������ HTTP ��� ����) ����
		RestTemplate restTemplate = new RestTemplate();
		//API_URL ���� �� �޾ƿ� JSON �����͸� profileDto�� �Ҵ�
		try {
			URI uri = new URI(API_URL);
			this.profileDto = restTemplate.getForObject(uri, ProfileDto.class);
		} catch (URISyntaxException e) {
			//��û�� �߸��Ǿ��� ��� ���� ó��
			e.printStackTrace();
		}
	}
}
