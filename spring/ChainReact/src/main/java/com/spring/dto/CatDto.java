package com.spring.dto;

import java.util.ArrayList;

import lombok.Data;

@Data
public class CatDto {
	public String name;
	public int age;
	public ArrayList<String> hobby = new ArrayList<>();
	public ArrayList<SkillDto> skills = new ArrayList<>();

	public CatDto(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public CatDto() {
	}
}
