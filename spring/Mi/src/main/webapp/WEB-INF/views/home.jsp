<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="/mi/test/getOnePlusTwo">1+2 결과 보러가기</a>
<br><br>
<a href="/mi/guest/getList">방명록</a>
<br><br>
<a href="/mi/guest/read?bno=1">1번 글</a>
<br><br>
<a href="/mi/guest/write">글 쓰기</a>
</body>
</html>
