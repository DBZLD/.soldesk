<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${cp}/resources/common.css" rel="stylesheet" >
<title>Insert title here</title>
</head>
<body>
	<h1>TFT 전적검색</h1>
	<form action="${cp}/riot/historyTFT">
		<input name = "playerID" placeholder="아이디">#
		<input name = "playerTag" placeholder="태그">
		<input type = "submit" placeholder = "검색">
	</form>
</body>
</html>