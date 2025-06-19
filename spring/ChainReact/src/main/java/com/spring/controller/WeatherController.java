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
		//// �츮���� ���� api ////						
		//���ڵ� ����Ű						
		String API_URL = "http://localhost:8080/api/cat";						
		// * ���� * https �ƴ� http ��. https �� �������� ������ ó���� �ؾ���.				
		RestTemplate restTemplate = new RestTemplate();						
		
		//// **** �߿� **** uri						
		URI uri = null; //java.net.URI ����Ʈ �ϼ�						
		try {						
			uri = new URI(API_URL); // URI Ŭ������ URL�� ���� ��ȿ�� �˻�, ������� ����, ����(Ư������, ���� ó�� ��)�� ������					
		} catch (URISyntaxException e) {						
			e.printStackTrace();					
		}						
		
		String s = restTemplate.getForObject(uri, String.class); //						
		log.info("====== �� ����� api ��û���� ���� json ���ڿ� �� ������? "+s);	
		
		CatDto catDto = restTemplate.getForObject(uri, CatDto.class); // �ڱ� Ŭ������ �ٲٽÿ�..		
		log.info("==== json ==== : ����� �̸� �� ������? : "+catDto.name);		
		log.info("==== json ==== : ����� ���� �� ������? : "+catDto.age);
		log.info("==== json ==== : ����� ��� �� ������? : "+catDto.hobby.get(0));
		log.info("==== json ==== : ����� ��� �� ������? : "+catDto.hobby.get(1));
		for(SkillDto sd : catDto.skills) {
			log.info("==== json ==== : ����� ��ų ��ϰ� ���� �� ������? : "+sd.name+" ����:"+sd.level);
		}
	}							
	
}
