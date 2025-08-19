package com.spring.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.spring.util.AccountDto;

public interface DBMapper {
	public ArrayList<AccountDto> getAccount(@Param("id")String id, @Param("tag")String tag);
	public void addAccount(@Param("id")String id, @Param("tag")String tag);
}
