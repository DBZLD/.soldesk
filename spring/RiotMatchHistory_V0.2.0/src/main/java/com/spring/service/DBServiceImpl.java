package com.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.DBMapper;
import com.spring.util.AccountDto;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service

public class DBServiceImpl implements DBService{

	@Setter(onMethod_ = @Autowired)
	private DBMapper mapper;	
	
	@Override
	public ArrayList<AccountDto> getAccount(String id, String tag) {
		// 빈 값을 입력
	    if ((id == null || id.isEmpty()) && (tag == null || tag.isEmpty())) {
	        return new ArrayList<>();
	    }
	    // id만 입력
	    if (tag == null || tag.isEmpty()) {
	        return mapper.getAccountID(id);
	    }
	    //id, tag 입력
	    return mapper.getAccount(id, tag);
	}
	
	@Override
	public void addAccount(String id, String tag, String icon, String regalia) {
		if(mapper.findAccount(id, tag).size() <= 0) {
			mapper.addAccount(id, tag, icon, regalia);			
		}else {
			log.info("already db");
		}
	}
}
