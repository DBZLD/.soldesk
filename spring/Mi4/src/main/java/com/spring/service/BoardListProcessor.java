package com.spring.service;

import java.util.ArrayList;

import com.spring.dto.GuestDto;
import com.spring.mapper.GuestMapper;

public class BoardListProcessor {
	ArrayList<GuestDto> post;
	GuestMapper mapper;
	String word = "";
	String htmlText = "";
	int currentPage = 0;
	int totalIndex = 0;
	int totalPage = 0;
	int totalBlock = 0;
	int nowBlock = 0;
	int startPage = 0;
	int nowIndex = 0;
	boolean hasNext = false;
	boolean hasPrev = false;
	public BoardListProcessor(GuestMapper mapper, int currentPage, String word) {
		htmlText = "";
		this.mapper = mapper;
		this.word = word;
		nowIndex = (currentPage-1)*5;
		this.currentPage = currentPage;
		this.post = mapper.getList(nowIndex);
		this.totalIndex = mapper.getCount();
		this.totalPage = (int)Math.ceil((double)totalIndex/5);
		this.totalBlock = (int)Math.ceil((double)totalPage/5);
		this.nowBlock = (int)Math.ceil((double)currentPage/5);
		this.startPage = (nowBlock-1)*5 + 1;
		setVar();
	}
	public void setVar() {
		if(totalBlock == nowBlock) {
			hasNext = false;
		}else {
			hasNext = true;
		}
		if(nowBlock <= 1) {
			hasPrev = false;
		}else {
			hasPrev = true;
		}
	}
	public String pagingBlock() {
		htmlText = "";
		
		if(hasPrev == true) {
			htmlText += String.format("<a href='/guest/getList?currentPage=%d'>���� </a>", startPage-1);
		}
		
		if(totalBlock == nowBlock) {
			for(int i = 0; i < totalPage%5; i++) {
				if(currentPage == startPage + i) {
					htmlText += String.format(" %d", startPage + i);									
				}else {
					htmlText += String.format("<a href='/guest/getList?currentPage=%d'> %d</a>", startPage + i, startPage + i);									
				}
			}
		}else {
			for(int i = 0; i < 5; i++) {
				if(currentPage == startPage + i) {
					htmlText += String.format(" %d", startPage + i);									
				}else {
					htmlText += String.format("<a href='/guest/getList?currentPage=%d'> %d</a>", startPage + i, startPage + i);					
				}
			}			
		}
		
		if(hasNext == true) {
			htmlText += String.format("<a href='/guest/getList?currentPage=%d'> ����</a>", startPage+5);
		}
		return htmlText;
	}
	public ArrayList<GuestDto> getPost(){
		return post;
	}
}
