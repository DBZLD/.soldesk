package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.CardDto;
import com.spring.service.CardService;
import com.spring.service.Dice;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j

@RequestMapping("/api/*")
@RestController
public class ApiController {
	
	@Setter(onMethod_ = @Autowired)
	private CardService service;	
	
	
	public int getLuck() {
		//확률 공개:
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
	
	@GetMapping("/addCard")
	public CardDto gacha() {
		String jobs[] = {"전사","마법사","궁수","도적","사제"};
		String grade[] = {"SSR","SR","S","R","H","N"};
		CardDto card = new CardDto(jobs[Dice.roll(0,4)],grade[getLuck()]);
		service.addCard(card);
		
		return card;
	}
}