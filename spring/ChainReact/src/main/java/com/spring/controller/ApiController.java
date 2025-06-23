package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.spring.dto.CatDto;
import com.spring.service.Dice;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/api/*")
@RestController
public class ApiController {
	class Card{
		public String job;
		public String grade;
		public Card(String job, String grade) {
			this.job = job;
			this.grade = grade;
		}
	}
	
	public int getLuck() {
		//È®·ü °ø°³:
		//SSR: 1%
		//SR: 3%
		//S: 6%
		//R: 10%
		//H: 30%
		//N: 50%
		int r = Dice.roll(1,100);
		int t = 5;	// N Normal
		if(r<=50) {	// H High
			t = 4; 
		}
		if(r<=20) {	// R Rare
			t = 3; 
		}
		if(r<=10) {	// S Super
			t = 2; 
		}
		if(r<=4) {	// SR SuperRare
			t = 1; 
		}
		if(r==1) {	// SSR SuperSuperRare
			t = 0; 
		}
		return t;
	}
	
	@GetMapping("/gacha")
	public Card gacha() {
		String jobs[] = {"Àü»ç","¸¶¹ý»ç","±Ã¼ö","µµÀû","»çÁ¦"};
		String grade[] = {"SSR","SR","S","R","H","N"};
		return new Card(jobs[Dice.roll(0,4)],grade[getLuck()]);
	}
	@GetMapping("/cat")
	public CatDto cat() {
		CatDto cat = new CatDto("¾ß¿ËÀÌ",7);
		cat.hobby.add("½Ä»§±Á±â");
		cat.hobby.add("ÀáÀÚ±â");

		
		return cat;
	}
}