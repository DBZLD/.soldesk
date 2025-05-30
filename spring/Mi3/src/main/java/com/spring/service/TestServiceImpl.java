package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.TestMapper;
import com.spring.dto.TestDto;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class TestServiceImpl implements TestService{

	@Setter(onMethod_ = @Autowired)
	private TestMapper mapper;	
	
	@Override
	public String getOne() {
		log.info("test===========");
		TestDto tvo = mapper.getData1();
		String one = tvo.getStr_data();
		return one;
	}

	@Override
	public String getTwo() {
		log.info("test===========");
		TestDto tvo = mapper.getData2();
		String two = tvo.getStr_data();
		return two;
	}
	
	@Override
	public void updateVisitantCount() {
		mapper.updateVisitantCount();
	}	
	
	@Override
	public void insertDoodle() {
		mapper.insertDoodle();
	}	
	
	@Override
	public void delTest() {
		mapper.delTest();
	}

}
