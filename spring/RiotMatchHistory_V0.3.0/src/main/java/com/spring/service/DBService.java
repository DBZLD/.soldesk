package com.spring.service;

import java.util.ArrayList;

import com.spring.util.AccountDto;
import com.spring.util.SearchDto;

public interface DBService {
	// id, tag �޾ƿ��� id, tag�������� �����ϴ� SearchDB�� ���� �迭�� ��ȯ
	public ArrayList<SearchDto> getSearchDB(String id, String tag);
	
	//id, tag, icon, regalia �޾ƿ��� SearchDB�� ����
	public void addSearchDB(String id, String tag, String icon, String regalia);

	//id �޾ƿ��� id�� ��ġ�ϴ� AccountDB ���� ���� ���� ��ȯ(true: ����, false: ������)
	public boolean findAccountDBbyID(String id);
	
	//id, pw �޾ƿ��� id,pw�� ��ġ�ϴ� AccountDB ���� ��ȯ
	public AccountDto findAccountDB(String id, String pw);
	
	//id, pw, email, riotAccount �޾ƿ��� AccountDB�� ����
	public void addAccountDB(String id, String pw, String email, String riotAccount);
}
