<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<%@ page session="false" %>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${cp}/resources/common.css" >
	<title>Home</title>
</head>
<body>
<P>  The time on the server is ${serverTime}. </P>
<img alt="" src="${cp}/resources/cat.jpg"> <br>
<a href="${cp}/guest/getList">글 리스트</a>
</body>
</html>
