<%@page import="com.spring.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Object obj = request.getAttribute("read");
		GuestDto read = (GuestDto)obj;
		Long bno = read.getBno();
		String btext = read.getBtext();
	%>
		글 번호 : <%=bno %> <br>
		글 내용 : <%=btext %>
		
		<hr><br> <a href = "${cp}/guest/del?bno=<%=bno %>">글 삭제</a>
		<br> <a href = "${cp}/guest/modify?bno=<%=bno %>">글 수정</a>
		<br> <a href = "${cp}/guest/getList">글 리스트로</a>
</body>
</html>