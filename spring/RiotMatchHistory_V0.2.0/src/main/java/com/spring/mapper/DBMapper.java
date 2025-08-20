package com.spring.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.spring.util.AccountDto;

public interface DBMapper {
	public ArrayList<AccountDto> getAccount(@Param("id")String id, @Param("tag")String tag);
	public ArrayList<AccountDto> findAccount(@Param("id")String id, @Param("tag")String tag);
	public ArrayList<AccountDto> getAccountID(String id);
	public void addAccount(@Param("id")String id, @Param("tag")String tag, 
			@Param("icon")String icon, @Param("regalia")String regalia);
}
