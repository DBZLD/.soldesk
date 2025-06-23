package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.CardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class CardServiceImpl implements CardService{

	@Setter(onMethod_ = @Autowired)
	private CardMapper mapper;

	@Override
	public int getList() {
		int n = mapper.getList();
		return n;
	}	
}