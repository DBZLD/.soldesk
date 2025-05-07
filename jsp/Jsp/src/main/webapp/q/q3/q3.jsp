<%@page import="java.util.ArrayList"%>
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
	ArrayList<String> a = new ArrayList<>();
	a.add("고양이");
	a.add("개");
	a.add("너굴맨");
	
	for(int i = 0; i < 3; i++){ %>
		<%=a.get(i) %>
	<% }%>
	
</body>
</html>