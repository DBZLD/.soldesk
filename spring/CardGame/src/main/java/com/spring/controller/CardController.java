package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.CardService;

import lombok.Setter;

@RequestMapping("/card/*")
@Controller
public class CardController {
	
	@Setter(onMethod_ = @Autowired)
	private CardService service;	
	
	@RequestMapping("/play")			
	public void play() {
		service.getList();
	}				
}
