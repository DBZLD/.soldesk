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
		CatDto catDto = new CatDto("¾ß¿ËÀÌ", 7); 
		catDto.hobby.add("½Ä»§±Á±â");	
		catDto.hobby.add("ÀáÀÚ±â");
		catDto.skills.add(new SkillDto("ÇÒÄû±â",2));
		catDto.skills.add(new SkillDto("¹é´ýºí¸µ",3));
		catDto.skills.add(new SkillDto("´Þ¸®±â",5));
		
		return catDto;
	}			
}				