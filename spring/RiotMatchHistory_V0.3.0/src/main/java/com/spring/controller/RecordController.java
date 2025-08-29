package com.spring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.TFTRecordProcessor;
import com.spring.service.MatchInfosService;
import com.spring.service.TFTApiProcessor;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/riot/*")
@AllArgsConstructor
@RestController
public class RecordController {

	//
	MatchInfosService service;
	
	// 라이엇 id와 tag를 받아오고 플레이어의 TFT정보들이 들어있는 TFTRecordProcessor 반환
	@RequestMapping("/getTFTRecord")							
	public TFTRecordProcessor getTFTRecord(@RequestParam(value="playerID", defaultValue = "")
	String playerID, @RequestParam(value="playerTag", defaultValue = "")String playerTag, Model model) {
		TFTRecordProcessor trp = service.getTRP(playerID, playerTag);
		log.info("getTFTRecord");
		return trp;
	}
	
	// 버전을 받아오고 버전에 맞는 TFT 라이엇 api가 들어있는 TFTApiProcessor 반환
	@RequestMapping("/TFTApi")
	public TFTApiProcessor getTFTApi(@RequestParam(value="version", defaultValue = "15.16.1")String version) {
		return service.getTAP(version);
	}
}
