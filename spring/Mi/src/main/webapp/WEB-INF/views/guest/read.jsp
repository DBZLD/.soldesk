<%@page import="com.spring.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		Object obj = request.getAttribute("read");
		GuestDto read = (GuestDto)obj;
		Long bno = read.getBno();
		String btext = read.getBtext();
	%>
		<%=bno %> <br>
		<%=btext %>
</body>
</html>