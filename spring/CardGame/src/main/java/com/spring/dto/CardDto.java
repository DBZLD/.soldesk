package com.spring.dto;

import lombok.Data;

@Data
public class CardDto {
	private Long no;
	private String job;
	private String grade;
	private String id;
	public CardDto() {
		
	}
	public CardDto(String job, String grade) {
		this.job = job;
		this.grade = grade;
	}
	
	
}