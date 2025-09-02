package com.spring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.TFTRecordProcessor;
import com.spring.service.LOLApiProcessor;
import com.spring.service.LOLRecordProcessor;
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
	
	// ���̾� id�� tag�� �޾ƿ��� �÷��̾��� TFT�������� ����ִ� TFTRecordProcessor ��ȯ
	@RequestMapping("/getTFTRecord")							
	public TFTRecordProcessor getTFTRecord(@RequestParam(value="playerID", defaultValue = "")
	String playerID, @RequestParam(value="playerTag", defaultValue = "")String playerTag, Model model) {
		TFTRecordProcessor trp = service.getTRP(playerID, playerTag);
		log.info("getTFTRecord");
		return trp;
	}
	
	// ������ �޾ƿ��� ������ �´� TFT ���̾� api�� ����ִ� TFTApiProcessor ��ȯ
	@RequestMapping("/TFTApi")
	public TFTApiProcessor getTFTApi(@RequestParam(value="version", defaultValue = "15.16.1")String version) {
		return service.getTAP(version);
	}
	
	// ���̾� id�� tag�� �޾ƿ��� �÷��̾��� LOL�������� ����ִ� LOLRecordProcessor ��ȯ
	@RequestMapping("/getLOLRecord")							
	public LOLRecordProcessor getLOLRecord(@RequestParam(value="playerID", defaultValue = "")
	String playerID, @RequestParam(value="playerTag", defaultValue = "")String playerTag, Model model) {
		LOLRecordProcessor lrp = service.getLRP(playerID, playerTag);
		log.info("getLOLRecord");
		return lrp;
	}
	
	// ������ �޾ƿ��� ������ �´� LOL ���̾� api�� ����ִ� LOLApiProcessor ��ȯ
	@RequestMapping("/LOLApi")
	public LOLApiProcessor getLOLApi(@RequestParam(value="version", defaultValue = "15.16.1")String version) {
		return service.getLAP(version);
	}
}
