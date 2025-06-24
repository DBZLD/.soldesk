package com.spring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.HisrotyInfosProcessor;
import com.spring.service.MatchInfosService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/riot/*")
@AllArgsConstructor
@RestController
public class HistoryController {

	MatchInfosService service;
	@RequestMapping("/historyTFT")							
	public HisrotyInfosProcessor matchHistory(@RequestParam("playerID")String playerID, @RequestParam("playerTag")String playerTag, Model model) {
		HisrotyInfosProcessor his = service.getMIP(playerID, playerTag);
		log.info(his);
		return his;
	}
}
