<%@page import="com.spring.service.BoardListProcessor"%>
<%@page import="com.spring.dto.GuestDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${cp}/resources/common.css">
<title>방명록 - 글 목록</title>
</head>
<body>
<h1>방명록</h1>
<h2>글목록</h2>
<a href="${cp}/guest/write">새글 쓰기</a>
<br><br>
<table>
	<tr>
		<td>번호</td>
		<td>내용</td>
	</tr>
	
<%
	Object obj = request.getAttribute("blp");
	BoardListProcessor blp = (BoardListProcessor)obj;
	for(int i=0;i<blp.getPost().size();i++){
		Long bno = blp.getPost().get(i).getBno();
		String btext = blp.getPost().get(i).getBtext();
%>	
	<tr>
		<td><%=bno %></td>
		<td><a href="${cp}/guest/read?bno=<%=bno%>"> <%=btext %> </a></td>
	<tr>
<%		
	}
%>
</table>
<br><br>
<%=blp.pagingBlock() %>

</body>
</html>