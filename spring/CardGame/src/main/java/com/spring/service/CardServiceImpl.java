package com.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.CardDto;
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
	public ArrayList<CardDto> getList() {
		ArrayList<CardDto> n = mapper.getList();
		return n;
	}	
	@Override
	public void resetList() {
		mapper.resetList();
	}
	@Override
	public void addCard(CardDto card) {
		mapper.addCard(card);
	}
}