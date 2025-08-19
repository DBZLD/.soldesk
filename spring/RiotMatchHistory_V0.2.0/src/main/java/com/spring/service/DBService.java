package com.spring.service;

import java.util.ArrayList;

import com.spring.util.AccountDto;

public interface DBService {
	public ArrayList<AccountDto> getAccount(String id, String tag);
	public void addAccount(String id, String tag);
}
