package com.spring.service;

import com.spring.dto.GuestDto;

public interface GuestService {
	public BoardListProcessor getList(int startIndex);
	public GuestDto read(Long bno);
	public void del(Long bno);
	public void write(GuestDto dto);
	public void modify(GuestDto dto);
}
