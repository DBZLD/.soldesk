package com.tl.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberVO {
	public String memberName;
	public String memberId;
	public String memberPw;
	public String role;
	public Timestamp createdAt;	
}
