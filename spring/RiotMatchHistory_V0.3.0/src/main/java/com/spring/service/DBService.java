package com.spring.service;

import java.util.ArrayList;

import com.spring.util.AccountDto;
import com.spring.util.SearchDto;

public interface DBService {
	// id, tag 받아오고 id, tag내용으로 시작하는 SearchDB의 정보 배열을 반환
	public ArrayList<SearchDto> getSearchDB(String id, String tag);
	
	//id, tag, icon, regalia 받아오고 SearchDB에 저장
	public void addSearchDB(String id, String tag, String icon, String regalia);

	//id 받아오고 id가 일치하는 AccountDB 정보 존재 여부 반환(true: 존재, false: 비존재)
	public boolean findAccountDBbyID(String id);
	
	//id, pw 받아오고 id,pw가 일치하는 AccountDB 정보 반환
	public AccountDto findAccountDB(String id, String pw);
	
	//id, pw, email, riotAccount 받아오고 AccountDB에 저장
	public void addAccountDB(String id, String pw, String email, String riotAccount);
}
