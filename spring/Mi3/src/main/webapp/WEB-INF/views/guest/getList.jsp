<%@page import="com.spring.dto.GuestDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//Model 에 "list" 라는 키로 넣은 객체를 request 내장객체에서 빼올 수 있음.
	
	Object obj = request.getAttribute("list");
	ArrayList<GuestDto> list = (ArrayList<GuestDto>)obj;
	
	for(int i=0;i<list.size();i++){
		Long bno = list.get(i).getBno();
		String btext = list.get(i).getBtext();
%>		
		<%=bno %>	
		<%=btext %>	
		<hr>  
<%		
	}

%>
</body>
</html>