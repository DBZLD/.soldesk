package com.spring.mapper;

import java.util.ArrayList;

import com.spring.dto.CardDto;

public interface CardMapper {
	public ArrayList<CardDto> getList();
	public void resetList();
	public void addCard(CardDto card);
}
