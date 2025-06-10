<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${cp}/resources/common.css" rel="stylesheet" >
	<title>Home</title>
</head>
<body>
<P>  The time on the server is ${serverTime}. </P>
<img alt="" src="${cp}/resources/cat.jpg"> <br>
<a href="${cp}/guest/getList">글 리스트</a>
</body>
</html>
