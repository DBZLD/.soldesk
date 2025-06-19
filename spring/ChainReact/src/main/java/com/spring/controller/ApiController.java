package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.CatDto;
import com.spring.dto.SkillDto;

@RestController				
@RequestMapping("/api")				
public class ApiController {				
	@GetMapping("/cat")			
	public CatDto getCat() {	
		CatDto catDto = new CatDto("�߿���", 7); 
		catDto.hobby.add("�Ļ�����");	
		catDto.hobby.add("���ڱ�");
		catDto.skills.add(new SkillDto("������",2));
		catDto.skills.add(new SkillDto("�����",3));
		catDto.skills.add(new SkillDto("�޸���",5));
		
		return catDto;
	}			
}				