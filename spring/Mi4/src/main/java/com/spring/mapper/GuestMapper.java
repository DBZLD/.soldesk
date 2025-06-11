package com.spring.mapper;

import java.util.ArrayList;

import com.spring.dto.GuestDto;

public interface GuestMapper {
	public ArrayList<GuestDto> getList(int startIndex);
	public int getCount();
	public int getCountW();
	public GuestDto read(Long bno);
	public void del(Long bno);
	public void write(GuestDto dto);
	public void modify(GuestDto dto);
}
