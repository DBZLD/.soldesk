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
	GuestDto read = (GuestDto)request.getAttribute("read");
	long bno = read.getBno();
	String btext = read.getBtext();
%>	

글번호:<%=bno %><br>
글내용:	
	
	<form action="${cp}/guest/modify" method="post">
		<input type="hidden" name='bno' value='<%=bno %>' >
		<textarea name='btext'>
			<%=btext %>
		</textarea>
		<input type="submit" value="수정하기">
	</form>
</body>
</html>