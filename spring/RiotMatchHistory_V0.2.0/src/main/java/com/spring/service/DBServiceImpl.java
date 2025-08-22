package com.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.DBMapper;
import com.spring.util.AccountDto;
import com.spring.util.SearchDto;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service

public class DBServiceImpl implements DBService{

	//자동 setter메서드 생성, autowired로 bean 자동 주입된 DBMapper 변수(DB 연동 관련 함수 보유)
	@Setter(onMethod_ = @Autowired)
	private DBMapper mapper;	
	
	
	//id, tag를 받아와서 id, tag의 값 유무, 일치 여부에 따라서 알맞는 SearchDto 배열을 반환
	@Override
	public ArrayList<SearchDto> getSearchDB(String id, String tag) {
		// id, tag가 빈 값일 때
	    if ((id == null || id.isEmpty()) && (tag == null || tag.isEmpty())) {
	        return new ArrayList<>();
	    }
	    
	    // tag가 빈 값일 때
	    if (tag == null || tag.isEmpty()) {
	        return mapper.getSearchDBbyID(id);
	    }
	    
	    // 빈 값이 없을 때
	    return mapper.getSearchDB(id, tag);
	}
	
	//id, tag icon, regalia를 받아서 일치하는 id, tag값을 가진 정보 유무를 확인 후 기존에 없는 정보면 SearchDB에 저장
	@Override
	public void addSearchDB(String id, String tag, String icon, String regalia) {
		//일치하는 id, tag값이 존재하지 않을 때
		if(mapper.findSearchDB(id, tag).size() <= 0) {
			mapper.addSearchDB(id, tag, icon, regalia);			
		//일치하는 id, tag값이 존재할 때
		}else {
			log.info("already db");
		}
	}
	
	//id, pw, email, riotAccount를 받아서 AccountDB에 저장
	@Override
	public void addAccountDB(String id, String pw, String email, String riotAccount) {
		mapper.addAccountDB(id, pw, email, riotAccount);
	}
	
	//id를 받아와서 일치하는 id를 가진 정보 유무 boolean으로 반환(true: 존재, false: 비존재)
	@Override
	public boolean findAccountDBbyID(String id) {
		//일치하는 id를 가진 정보가 없을 때
		if(mapper.findAccountDBbyID(id) == null) {
			return false;
		}
		//일치하는 id를 가진 정보가 있을 때
		return true;
	}
	
	//id, pw를 받아와서 일치하는 id, pw를 가진 정보를 반환
	@Override
	public AccountDto findAccountDB(String id, String pw) {
		return mapper.findAccountDB(id, pw);
	}
}
