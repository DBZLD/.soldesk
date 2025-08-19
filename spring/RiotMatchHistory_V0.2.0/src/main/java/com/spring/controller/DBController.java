package com.spring.controller;

import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.DBService;
import com.spring.util.AccountDto;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/db/*")
@AllArgsConstructor
@RestController
public class DBController {

	DBService service;
	
	@RequestMapping("/addAccount")							
	public void addAccount(@RequestParam(value="id", defaultValue = "")String id,
	@RequestParam(value="tag", defaultValue = "")String tag, Model model) {
		service.addAccount(id, tag);
	}
	@RequestMapping("/getAccount")
	public ArrayList<AccountDto> getAccount(@RequestParam(value="id", defaultValue = "")String id,
	@RequestParam(value="tag", defaultValue = "")String tag) {
		return service.getAccount(id, tag);
	}
}
