package com.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.GuestDto;
import com.spring.mapper.GuestMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class GuestServiceImpl implements GuestService{

	@Setter(onMethod_ = @Autowired)
	private GuestMapper mapper;	
	
	@Override
	public ArrayList<GuestDto> getList() {
		log.info("비지니스 계층===========");
		return mapper.getList();
	}
	@Override
	public GuestDto read(Long bno) {
		log.info("read 실행");
		return mapper.read(bno);
	}
	@Override
	public void del(Long bno) {
		log.info("del 실행");
		mapper.del(bno);
	}
	@Override
	public void write(GuestDto dto) {
		log.info("write 실행");
		mapper.write(dto);
	}
	@Override
	public void modify(GuestDto dto) {
		log.info("modify 실행");
		mapper.modify(dto);
	}
}
