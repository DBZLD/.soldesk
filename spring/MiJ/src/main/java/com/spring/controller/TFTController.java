package com.spring.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.spring.dto.PuuidDto;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/riot/*")
//@AllArgsConstructor
@Controller
public class TFTController {

	@RequestMapping("/tft")							
	public void w() {							
		String API_KEY = "RGAPI-36fe9cd0-1a1b-44bc-bf0a-59522f3b8846";
		String AC_ID = "dbzld";
		String AC_TAG = "9476";
		String API_URL = String.format("https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/%s/%s?api_key=%s", AC_ID, AC_TAG, API_KEY);						

		RestTemplate restTemplate = new RestTemplate();						
		URI uri = null; 					
		try {						
			uri = new URI(API_URL);
		} catch (URISyntaxException e) {						
			e.printStackTrace();					
		}
		PuuidDto pu = restTemplate.getForObject(uri, PuuidDto.class);
		log.info(String.format("\n계정이름 : %s#%s\npuuid : %s", pu.gameName, pu.tagLine, pu.puuid));
		//puuid  f98WWOqUGgb4fJw5YoM_EIi5ylBtG2gBNjnufiPE28COchIKm0kFBTjZSuQvZ8pitMZxLXC3feDw2A
		int nCount = 20;
		API_URL = String.format("https://asia.api.riotgames.com/tft/match/v1/matches/by-puuid/%s/ids?start=0&count=%d&api_key=%s", pu.puuid, nCount, API_KEY);
		List<String> gameIds = null;
		try {
			uri = new URI(API_URL);
            ResponseEntity<ArrayList<String>> response = restTemplate.exchange(
            		uri, HttpMethod.GET,
                    null, new ParameterizedTypeReference<ArrayList<String>>() {}
                );
            gameIds = response.getBody();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}
		log.info(String.format("1.%s\n2.%s\n3.%s\n4.%s\n5.%s",gameIds.get(0),gameIds.get(1),gameIds.get(2),gameIds.get(3),gameIds.get(4)));
	}							
	
}
