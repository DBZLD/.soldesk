package com.spring.service;

import java.util.ArrayList;

import com.spring.dto.GuestDto;
import com.spring.mapper.GuestMapper;

public class BoardListProcessor {
	ArrayList<GuestDto> post;
	GuestMapper mapper;
	String htmlText = "";
	int totalIndex = 0;
	int totalPage = 0;
	int totalBlock = 0;
	int nowBlock = 0;
	int startPage = nowBlock*5 + 1;
	int prevBlockPage = 0;
	int nextBlockPage = 0;
	boolean hasNext;
	boolean hasPrev;
	public BoardListProcessor(int currentPage, GuestMapper mapper) {
		htmlText = "";
		this.mapper = mapper;
		this.totalPage = (int)Math.ceil((double)totalIndex/5);
		this.totalBlock = (int)Math.ceil((double)totalPage/5);
		this.nowBlock = (int)Math.ceil((double)currentPage/5);
		this.startPage = nowBlock*5 + 1;
	}
	public void hasPrevNext() {
		if(totalBlock == nowBlock) {
			hasNext = false;
		}else {
			hasNext = true;
			nextBlockPage = (nowBlock+1)*5 +1;
		}
		if(nowBlock <= 1) {
			hasPrev = false;
		}else {
			hasPrev = true;
			nextBlockPage = (nowBlock-1)*5 +1;
		}
	}
	public void pagingBlock(int currentPage, int totalIndex) {
		if(hasPrev == true) {
			htmlText += String.format("<a href='/guest/getList?currentPage=%d'>이전</a>", nextBlockPage);
		}
		for(int i = startPage; i < startPage + 5; i++) {
			htmlText += String.format("<a href='/guest/getList?currentPage=%d'>%d</a>", i, 1+i-startPage);
		}
		
		if(hasNext == true) {
			htmlText += String.format("<a href='/guest/getList?currentPage=%d'>다음</a>", prevBlockPage);
		}	
	}
}
