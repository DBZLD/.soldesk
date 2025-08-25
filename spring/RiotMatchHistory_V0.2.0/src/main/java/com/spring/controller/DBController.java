package com.spring.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.DBService;
import com.spring.util.AccountDto;
import com.spring.util.SearchDto;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/db/*")
@AllArgsConstructor
@RestController
public class DBController {

	// 정보의 null 여부 등을 확인하고 알맞는 DBMapper의 함수를 호출하는 DBService 클래스 생성
	DBService service;
	
	//아이디, 태그 받아와서 SearchDB에 저장된 정보중에 아이디, 태그 내용이 포함된 정보 반환
	@RequestMapping("/getSearchDB")
	public ArrayList<SearchDto> getSearchDB(@RequestParam(value="id", defaultValue = "")String id,
	@RequestParam(value="tag", defaultValue = "")String tag) {
		return service.getSearchDB(id, tag);
	}
	
	// SearchDto(id, tag, icon, realia) 받아와서 SearchDB에 저장
	@PostMapping("/addSearchDB")
	public void addSearchDB(@RequestBody SearchDto search) {
		service.addSearchDB(search.id, search.tag, search.icon, search.regalia);
		log.info("id:" + search.id + " tag:" + search.tag);
	}
	
	// 사이트 계정 id 받아와서 일치하는 id 있는지 boolean형식으로 반환(중복 아이디 방지)(true : 중복 있음, false : 중복 없음)
	@RequestMapping("/findAccountDBbyID")
	public boolean findAccountDBbyID(@RequestParam(value="id", defaultValue = "")String id) {
		return service.findAccountDBbyID(id);
	}
	
	// 사이트 계정 id, pw 받아와서 id와 pw가 모두 일치하는 정보 있는지 확인하고 AccountDto 반환(로그인)
	@RequestMapping("/findAccountDB")
	public AccountDto findAccountDB(@RequestParam(value="id", defaultValue = "")String id,
	@RequestParam(value="pw", defaultValue = "")String pw) {
		return service.findAccountDB(id, pw);
	}
	
	// AccountDto(id, pw, email, riotAccount) 받아와서 AccountDB에 저장
	@PostMapping("/addAccountDB")
	public void addAccountDB(@RequestBody AccountDto account) {
		service.addAccountDB(account.id, account.pw, account.email, account.riotAccount);
		log.info("id:" + account.id + " pw:" + account.pw);
	}
}
