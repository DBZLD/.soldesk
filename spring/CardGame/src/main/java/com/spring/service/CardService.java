package com.spring.service;

import java.util.ArrayList;

import com.spring.dto.CardDto;

public interface CardService {
	public ArrayList<CardDto> getList();
	public void resetList();
	public void addCard(CardDto card);
}
