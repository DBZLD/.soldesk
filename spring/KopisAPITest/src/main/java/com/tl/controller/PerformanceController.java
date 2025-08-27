package com.tl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tl.dto.PerformanceRequestDto;
import com.tl.service.PerformanceInfoProcessor;
import com.tl.service.PerformanceInfosService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/tl/*")
@AllArgsConstructor
@RestController
public class PerformanceController {

	PerformanceInfosService service;
	
	// 호출 시 PerformanceInfoProcessor 반환
	@RequestMapping("/getPerformanceList")
	public PerformanceInfoProcessor getPerformanceList(PerformanceRequestDto requestDto) {
	    return service.getPIP(requestDto);
	}
}
