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

	MatchInfosService service;
	@RequestMapping("/getTFTRecord")							
	public TFTRecordProcessor getTFTRecord(@RequestParam(value="playerID", defaultValue = "")
	String playerID, @RequestParam(value="playerTag", defaultValue = "")String playerTag, Model model) {
		TFTRecordProcessor hrp = service.getMIP(playerID, playerTag);
		return hrp;
	}
	
	@RequestMapping("/getTFTApi")
	public TFTApiProcessor getTFTApi() {
		TFTApiProcessor tap = new TFTApiProcessor();
		return tap;
	}
}
