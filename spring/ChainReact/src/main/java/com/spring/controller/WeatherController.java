package com.spring.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.spring.dto.CatDto;
import com.spring.dto.SkillDto;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/weather/*")
//@AllArgsConstructor
@Controller
public class WeatherController {					
	@RequestMapping("/getCat")							
	public void getCat() {							
		//// 우리나라 공공 api ////						
		//인코딩 인증키						
		String API_URL = "http://localhost:8080/api/cat";						
		// * 주의 * https 아님 http 임. https 는 인증관련 복잡한 처리를 해야함.				
		RestTemplate restTemplate = new RestTemplate();						
		
		//// **** 중요 **** uri						
		URI uri = null; //java.net.URI 임포트 하셈						
		try {						
			uri = new URI(API_URL); // URI 클래스는 URL에 대한 유효성 검사, 구성요소 추출, 보안(특수문자, 공백 처리 등)을 도와줌					
		} catch (URISyntaxException e) {						
			e.printStackTrace();					
		}						
		
		String s = restTemplate.getForObject(uri, String.class); //						
		log.info("====== 내 고양이 api 요청으로 받은 json 문자열 잘 나오나? "+s);	
		
		CatDto catDto = restTemplate.getForObject(uri, CatDto.class); // 자기 클래스로 바꾸시오..		
		log.info("==== json ==== : 고양이 이름 잘 나오냐? : "+catDto.name);		
		log.info("==== json ==== : 고양이 나이 잘 나오냐? : "+catDto.age);
		log.info("==== json ==== : 고양이 취미 잘 나오냐? : "+catDto.hobby.get(0));
		log.info("==== json ==== : 고양이 취미 잘 나오냐? : "+catDto.hobby.get(1));
		for(SkillDto sd : catDto.skills) {
			log.info("==== json ==== : 고양이 스킬 목록과 레벨 잘 나오냐? : "+sd.name+" 레벨:"+sd.level);
		}
	}							
	
}
