package com.spring.service;

public class LOLApiProcessor {
	public String version;	// 버전
	
	// version을 매개 변수로 받는 생성자 함수
	public LOLApiProcessor(String version) {
		this.version = version;	// 매개 변수로 받은 version을 this.version으로 설정
	}
}
