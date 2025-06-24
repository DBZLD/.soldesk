package com.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.CardDto;
import com.spring.service.CardService;

import lombok.Setter;

@RequestMapping("/card/*")
@RestController
public class CardController {
	
	@Setter(onMethod_ = @Autowired)
	private CardService service;	
	
	@RequestMapping("/getList")			
	public ArrayList<CardDto> getCardList() {
		ArrayList<CardDto> n = service.getList();
		System.out.println("==== ÃÑ Ä«µå ¼ö:"+n.size());
		
		return n;
	}
	@RequestMapping("/resetList")
	public String reset() {
		service.resetList();
		return "Reset Success";
	}
}
