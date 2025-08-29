package com.spring.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.spring.util.AccountDto;
import com.spring.util.SearchDto;

public interface DBMapper {
	//id, tag받아오고 id, tag의 내용으로 시작되는 SearchDB의 정보 배열 반환
	public ArrayList<SearchDto> getSearchDB(@Param("id")String id, @Param("tag")String tag);
	
	//id, tag받아오고 id, tag가 일치하는 SearchDB의 정보 배열 반환
	public ArrayList<SearchDto> findSearchDB(@Param("id")String id, @Param("tag")String tag);
	
	//id 받아오고 id의 내용으로 시작되는 SearchDB의 정보 배열 반환
	public ArrayList<SearchDto> getSearchDBbyID(String id);
	
	//id, tag, icon, regalia 받아오고 SearchDB에 저장
	public void addSearchDB(@Param("id")String id, @Param("tag")String tag, 
			@Param("icon")String icon, @Param("regalia")String regalia);
	
	//id 받아오고 id가 일치하는 AccountDB의 정보를 반환
	public AccountDto findAccountDBbyID(String id);
	
	//id, pw 받아오고 id, pw가 일치하는 AccountDB의 정보를 반환
	public AccountDto findAccountDB(@Param("id")String id, @Param("pw")String pw);
	
	//id, pw, email, riotAccount 받아오고 AccountDB에 저장
	public void addAccountDB(@Param("id")String id, @Param("pw")String pw, 
			@Param("email")String email, @Param("riotAccount")String riotAccount);
	
}
