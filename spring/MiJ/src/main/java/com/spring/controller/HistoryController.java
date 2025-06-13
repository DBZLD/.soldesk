package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.service.MatchInfosService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/riot/*")
@AllArgsConstructor
@Controller
public class HistoryController {

	MatchInfosService service;
	@RequestMapping("/historyTFT")							
	public void matchHistory(@RequestParam("playerID")String playerID, @RequestParam("playerTag")String playerTag, Model model) {
		model.addAttribute("matchInfos", service.getMIP(playerID, playerTag));
	}
	@RequestMapping("/searchTFT")
	public void searchTFT() {
		
	}
}
