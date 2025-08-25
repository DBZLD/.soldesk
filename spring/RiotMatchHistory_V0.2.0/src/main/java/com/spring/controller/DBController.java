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

	// ������ null ���� ���� Ȯ���ϰ� �˸´� DBMapper�� �Լ��� ȣ���ϴ� DBService Ŭ���� ����
	DBService service;
	
	//���̵�, �±� �޾ƿͼ� SearchDB�� ����� �����߿� ���̵�, �±� ������ ���Ե� ���� ��ȯ
	@RequestMapping("/getSearchDB")
	public ArrayList<SearchDto> getSearchDB(@RequestParam(value="id", defaultValue = "")String id,
	@RequestParam(value="tag", defaultValue = "")String tag) {
		return service.getSearchDB(id, tag);
	}
	
	// SearchDto(id, tag, icon, realia) �޾ƿͼ� SearchDB�� ����
	@PostMapping("/addSearchDB")
	public void addSearchDB(@RequestBody SearchDto search) {
		service.addSearchDB(search.id, search.tag, search.icon, search.regalia);
		log.info("id:" + search.id + " tag:" + search.tag);
	}
	
	// ����Ʈ ���� id �޾ƿͼ� ��ġ�ϴ� id �ִ��� boolean�������� ��ȯ(�ߺ� ���̵� ����)(true : �ߺ� ����, false : �ߺ� ����)
	@RequestMapping("/findAccountDBbyID")
	public boolean findAccountDBbyID(@RequestParam(value="id", defaultValue = "")String id) {
		return service.findAccountDBbyID(id);
	}
	
	// ����Ʈ ���� id, pw �޾ƿͼ� id�� pw�� ��� ��ġ�ϴ� ���� �ִ��� Ȯ���ϰ� AccountDto ��ȯ(�α���)
	@RequestMapping("/findAccountDB")
	public AccountDto findAccountDB(@RequestParam(value="id", defaultValue = "")String id,
	@RequestParam(value="pw", defaultValue = "")String pw) {
		return service.findAccountDB(id, pw);
	}
	
	// AccountDto(id, pw, email, riotAccount) �޾ƿͼ� AccountDB�� ����
	@PostMapping("/addAccountDB")
	public void addAccountDB(@RequestBody AccountDto account) {
		service.addAccountDB(account.id, account.pw, account.email, account.riotAccount);
		log.info("id:" + account.id + " pw:" + account.pw);
	}
}
