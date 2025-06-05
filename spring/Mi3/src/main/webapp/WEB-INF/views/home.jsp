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
<a href="/mi/guest/getList">글 리스트</a>
<br><br>
<a href="/mi/guest/write">글 쓰기</a>
<br><br>
<a href="/mi/guest/read?bno=1">1번 글 읽기</a>
<br><br>
<a href="/mi/guest/modify?bno=1">1번 글 수정</a>
</body>
</html>
