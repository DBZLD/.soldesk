package com.spring.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.spring.util.AccountDto;
import com.spring.util.SearchDto;

public interface DBMapper {
	//id, tag�޾ƿ��� id, tag�� �������� ���۵Ǵ� SearchDB�� ���� �迭 ��ȯ
	public ArrayList<SearchDto> getSearchDB(@Param("id")String id, @Param("tag")String tag);
	
	//id, tag�޾ƿ��� id, tag�� ��ġ�ϴ� SearchDB�� ���� �迭 ��ȯ
	public ArrayList<SearchDto> findSearchDB(@Param("id")String id, @Param("tag")String tag);
	
	//id �޾ƿ��� id�� �������� ���۵Ǵ� SearchDB�� ���� �迭 ��ȯ
	public ArrayList<SearchDto> getSearchDBbyID(String id);
	
	//id, tag, icon, regalia �޾ƿ��� SearchDB�� ����
	public void addSearchDB(@Param("id")String id, @Param("tag")String tag, 
			@Param("icon")String icon, @Param("regalia")String regalia);
	
	//id �޾ƿ��� id�� ��ġ�ϴ� AccountDB�� ������ ��ȯ
	public AccountDto findAccountDBbyID(String id);
	
	//id, pw �޾ƿ��� id, pw�� ��ġ�ϴ� AccountDB�� ������ ��ȯ
	public AccountDto findAccountDB(@Param("id")String id, @Param("pw")String pw);
	
	//id, pw, email, riotAccount �޾ƿ��� AccountDB�� ����
	public void addAccountDB(@Param("id")String id, @Param("pw")String pw, 
			@Param("email")String email, @Param("riotAccount")String riotAccount);
	
}
