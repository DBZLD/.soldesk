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
	public boolean bSuccess = true;										// �ùٸ� ��û ����
	private String latestVersion = setLatestVersion();					// �ֽ� ����
	private TFTApiProcessor tap = new TFTApiProcessor(latestVersion);	// ���̾� API JSON ������
	private PuuidDto puuidDto = new PuuidDto();							// ���̾� API puuid JSON ������
	private ArrayList<String> matchIds = new ArrayList<>();				// ���̾� API matchId �迭
	private ArrayList<MatchDto> matchDto = new ArrayList<>();			// ���̾� API match JSON ������
	private ArrayList<TFTRankDto> rankDto = new ArrayList<>();				// ���̾� API rank JSON ������
	private ProfileDto profileDto = new ProfileDto();					// ���̾� API profile JSON ������
	
	public TFTPlayerRankInfos playerRankInfo = new TFTPlayerRankInfos();		// API ����, ������ �÷��̾� ��ũ JSON ������
	public TFTPlayerProfileInfo playerProfileInfo = new TFTPlayerProfileInfo();	// API ����, ������ �÷��̾� ������ JSON ������
	public ArrayList<TFTMatchInfo> matchInfo = new ArrayList<>();				// API ����, ������ ��ġ JSON ������
	
	// �÷��̾� id, tag�� �޾Ƽ� bSuccess�� �����ϰ� JSON �����͸� ����� ������ �Լ�
	public TFTRecordProcessor(String playerId, String playerTag) {
		// ���̾� API���� �÷��̾� id, tag�� �̿��ؼ� puuid�� ������ bSuccess�� true�� ����
		setPuuidDto(playerId, playerTag);
		// bSuccess�� true�϶��� ������ JSON �����͵��� �޾ƿ�
		if (bSuccess == true) {
			setMatchIds();			// ���̾� API���� puuid�� �̿��ؼ� matchIds JSON �����͸� �޾ƿ�
			setRankDto();			// ���̾� API���� puuid�� �̿��ؼ� rankDto JSON �����͸� �޾ƿ�
			setMatchDto();			// ���̾� API���� matchIds�� �̿��ؼ� matchDto JSON �����͸� �޾ƿ�
			setProfileDto();		// ���̾� API���� puuid�� �̿��ؼ� profileDto JSON �����͸� �޾ƿ�

			setPlayerRankInfo();	// rankDto�� �̿��ؼ� playerRankInfo JSON �����͸� ����
			setPlayerProfileInfo();	// profileDto�� �̿��ؼ� playerProfileInfo JSON �����͸� ����
			setMatchInfos();			// matcDto�� �̿�ּ� matchDto JSON �����͸� ����
		}
	}
	
	// ���̾� API���� �ֽ� ������ �޾ƿ��� �Լ�
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
			if (AC_ID.matches(".*[\\uAC00-\\uD7A3\\u1100-\\u11FF\\u3130-\\u318F\\u3040-\\u309F\\u30A0-\\u30FF\\u4E00-\\u9FFF]+.*")) {
			    accountId = URLEncoder.encode(accountId, StandardCharsets.UTF_8.name());
			}
			// �����ڵ� ���Խ� ������ �̿��ؼ� �±װ� ��ġ�Ѵٸ� URL ���ڵ� 
			if (AC_TAG.matches(".*[\\uAC00-\\uD7A3\\u1100-\\u11FF\\u3130-\\u318F\\u3040-\\u309F\\u30A0-\\u30FF\\u4E00-\\u9FFF]+.*")) {
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
		// test�� puuid:f98WWOqUGgb4fJw5YoM_EIi5ylBtG2gBNjnufiPE28COchIKm0kFBTjZSuQvZ8pitMZxLXC3feDw2A
	}

	// puuid������ ���̾� API���� matchIds JSON �����͸� ������ �Լ�
	public void setMatchIds() {
		// API_URL �Ҵ�
		String API_URL = String.format(
				"https://asia.api.riotgames.com/tft/match/v1/matches/by-puuid/%s/ids?start=0&startTime=%s&count=%d&api_key=%s",
				puuidDto.puuid, Common.SET15_START, Common.MATCH_COUNT, Common.API_KEY);
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

	// matchIds�� ���̾� API���� matchDto JSON �����͸� ������ �Լ�
	public void setMatchDto() {
		// RestTemplate(Spring������ HTTP ��� ����) ����
		RestTemplate restTemplate = new RestTemplate();
		// matchInfos ����
		ArrayList<MatchDto> matchInfos = new ArrayList<MatchDto>();
		// �޾ƿ� matchIds�� ũ�⸸ŭ �ݺ�
		for (int i = 0; i < matchIds.size(); i++) {
			// API_URL �Ҵ�
			String API_URL = String.format("https://asia.api.riotgames.com/tft/match/v1/matches/%s?api_key=%s",
					matchIds.get(i), Common.API_KEY);
			// API_URL�� �����ؼ� �޾ƿ� JSON �����͸� matchInfo�� �Ҵ� �� matchInfo�� matchInfos�� �߰�
			try {
				URI uri = new URI(API_URL);
				MatchDto matchInfo = restTemplate.getForObject(uri, MatchDto.class);
				matchInfos.add(matchInfo);
			} catch (URISyntaxException e) {
				// ��û�� �߸��Ǿ��� ��� ���� ó��
				e.printStackTrace();
			}
		}
		// matchInfos�� ���� matchDto�� �Ҵ�
		this.matchDto = matchInfos;
	}

	// puuid�� ���̾� API���� rankDto JSON �����͸� ������ �Լ�
	public void setRankDto() {
		// API_URL �Ҵ�
		String API_URL = String.format("https://kr.api.riotgames.com/tft/league/v1/by-puuid/%s?api_key=%s",
				puuidDto.puuid, Common.API_KEY);
		// RestTemplate(Spring������ HTTP ��� ����) ����
		RestTemplate restTemplate = new RestTemplate();
		// API_URL�� ���� �� �޾ƿ� JSON �����͸� rankDto�� �Ҵ�
		try {
			URI uri = new URI(API_URL);
			ResponseEntity<ArrayList<TFTRankDto>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<ArrayList<TFTRankDto>>() {
					});
			rankDto = response.getBody();
		} catch (URISyntaxException e) {
			// ��û�� �߸��Ǿ��� ��� ���� ó��
			e.printStackTrace();
		}
	}

	// puuid�� ���̾� API���� profileDto JSON �����͸� ������ �Լ�
	public void setProfileDto() {
		// API_URL �Ҵ�
		String API_URL = String.format("https://kr.api.riotgames.com/tft/summoner/v1/summoners/by-puuid/%s?api_key=%s",
				puuidDto.puuid, Common.API_KEY);
		// RestTemplate(Spring������ HTTP ��� ����) ����
		RestTemplate restTemplate = new RestTemplate();
		// API_URL ���� �� �޾ƿ� JSON �����͸� profileDto�� �Ҵ�
		try {
			URI uri = new URI(API_URL);
			this.profileDto = restTemplate.getForObject(uri, ProfileDto.class);
		} catch (URISyntaxException e) {
			// ��û�� �߸��Ǿ��� ��� ���� ó��
			e.printStackTrace();
		}
	}
	
	// rankDto�� �̿��ؼ� ���� �� �ʿ��� ������ ��� ������ playerRankInfo�� �����ϴ� �Լ�
	public void setPlayerRankInfo() {
		playerRankInfo = new TFTPlayerRankInfos(
			getRank(Common.TFT_RANK), getRank(Common.TFT_DOUBLE_UP), getRank(Common.TFT_TURBO), tap
		);
	}
	
	// rankDto�� ���� �� queueType�� �´� ������ ��ȯ
	private TFTRankDto getRank(String queueType) {
		// queueType�� �´� ������ index�� �޾ƿ�(������� -1 ��ȯ)
		int index = findRankIndex(queueType);
		
		// �����Ѵٸ� rankDto[index]�� ��ȯ
		if (index != -1) {
			return rankDto.get(index);
		}
		// �������� �ʴٸ� provisional(��ũ ����)��ü�� ���� ��ȯ
		TFTRankDto provisional = new TFTRankDto();
		provisional.queueType = queueType;
		
		if(queueType.equals(Common.TFT_TURBO)){
			// queueType�� turbo��� ratedTier�� ���� UNRATED(PROVISIONAL)�� �Ҵ�
			provisional.ratedTier = Common.UNRATED;
		}else {
			// queueType�� turbo�� �ƴ϶�� tier�� ���� UNRATED(PROVISIONAL)�� �Ҵ�
			provisional.tier = Common.UNRATED;			
		}
		
		return provisional;
	}
	// rankDto���� rankType�� �´� ������ index�� �޾ƿ��� �Լ�(������� -1 ��ȯ)
	public int findRankIndex(String rankType) {
		// �� String �迭 ����
		ArrayList<String> queueTypeList = new ArrayList<>();
		// rankDto�� ũ�⸸ŭ queueTypeList�� rankDto.queueType�� �Ҵ�
		for (int i = 0; i < rankDto.size(); i++) {
			queueTypeList.add(rankDto.get(i).queueType);
		}
		// rankType�� ��ġ�ϴ� ���� queueTypeList�迭 index�� �Ҵ�(������� -1 �Ҵ�)
		int pIndex = queueTypeList.indexOf(rankType);
		
		return pIndex;
	}

	// profile, puuidDto�� �̿��ؼ� ���� �� �ʿ��� �����鸸 ��� ������ playerProfileInfo�� �����ϴ� �Լ�
	public void setPlayerProfileInfo() {
		playerProfileInfo = new TFTPlayerProfileInfo(profileDto, puuidDto, tap);
	}

	// matchDto, puuid�� �̿��ؼ� ���� �� �ʿ��� �����鸸 ��� ������ matchInfos�� �����ϴ� �Լ�
	public void setMatchInfos() {
		for (int i = 0; i < matchIds.size(); i++) {
			matchInfo.add(new TFTMatchInfo(matchDto.get(i), puuidDto.puuid));
		}
	}
}
