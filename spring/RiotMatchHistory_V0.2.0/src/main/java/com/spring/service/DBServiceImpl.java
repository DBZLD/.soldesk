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
	public void addAccount(String id, String tag) {
		mapper.addAccount(id, tag);
	}
	@Override
	public ArrayList<AccountDto> getAccount(String id, String tag) {
		return mapper.getAccount(id, tag);
	}
}
