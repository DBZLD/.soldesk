package com.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.DBMapper;
import com.spring.util.AccountDto;
import com.spring.util.SearchDto;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service

public class DBServiceImpl implements DBService{

	//�ڵ� setter�޼��� ����, autowired�� bean �ڵ� ���Ե� DBMapper ����(DB ���� ���� �Լ� ����)
	@Setter(onMethod_ = @Autowired)
	private DBMapper mapper;	
	
	
	//id, tag�� �޾ƿͼ� id, tag�� �� ����, ��ġ ���ο� ���� �˸´� SearchDto �迭�� ��ȯ
	@Override
	public ArrayList<SearchDto> getSearchDB(String id, String tag) {
		// id, tag�� �� ���� ��
	    if ((id == null || id.isEmpty()) && (tag == null || tag.isEmpty())) {
	        return new ArrayList<>();
	    }
	    
	    // tag�� �� ���� ��
	    if (tag == null || tag.isEmpty()) {
	        return mapper.getSearchDBbyID(id);
	    }
	    
	    // �� ���� ���� ��
	    return mapper.getSearchDB(id, tag);
	}
	
	//id, tag icon, regalia�� �޾Ƽ� ��ġ�ϴ� id, tag���� ���� ���� ������ Ȯ�� �� ������ ���� ������ SearchDB�� ����
	@Override
	public void addSearchDB(String id, String tag, String icon, String regalia) {
		//��ġ�ϴ� id, tag���� �������� ���� ��
		if(mapper.findSearchDB(id, tag).size() <= 0) {
			mapper.addSearchDB(id, tag, icon, regalia);			
		//��ġ�ϴ� id, tag���� ������ ��
		}else {
			log.info("already db");
		}
	}
	
	//id, pw, email, riotAccount�� �޾Ƽ� AccountDB�� ����
	@Override
	public void addAccountDB(String id, String pw, String email, String riotAccount) {
		mapper.addAccountDB(id, pw, email, riotAccount);
	}
	
	//id�� �޾ƿͼ� ��ġ�ϴ� id�� ���� ���� ���� boolean���� ��ȯ(true: ����, false: ������)
	@Override
	public boolean findAccountDBbyID(String id) {
		//��ġ�ϴ� id�� ���� ������ ���� ��
		if(mapper.findAccountDBbyID(id) == null) {
			return false;
		}
		//��ġ�ϴ� id�� ���� ������ ���� ��
		return true;
	}
	
	//id, pw�� �޾ƿͼ� ��ġ�ϴ� id, pw�� ���� ������ ��ȯ
	@Override
	public AccountDto findAccountDB(String id, String pw) {
		return mapper.findAccountDB(id, pw);
	}
}
