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
<h1>라이엇 전적 api창</h1>
<hr>
<h2>전적 api 보기</h2>
<form action="${cp}/riot/getTFTRecord">
<input name="playerID" placeholder="아이디">
<input name="playerTag" placeholder="태그">
<input type="submit" value = "api보기">
</form>
<a href="${cp}/riot/getTFTRecord?playerID=dbzld&playerTag=9476">내계정 api</a>
<h2>데이터 api보기</h2>
<form action="/riot/TFTApi">
<input name="version" placeholder="버전(ex.15.16.1)">
<input type="submit" value = "api보기">
</form>
<form action="/db/addAccount">
<input name="id" placeholder="아이디">
<input name="tag" placeholder="태그">
<input type="submit" value = "DB 추가">
</form>
<form action="/db/getAccount">
<input name="id" placeholder="아이디">
<input type="submit" value = "DB 받아오기">
</form>
<pre>패치 버전 목록
"15.16.1", "15.15.1", "15.14.1", "15.13.1", "15.12.1", "15.11.1",
"15.10.1", "15.9.1", "15.8.1", "15.7.1", "15.6.1", "15.5.1", 
"15.4.1", "15.3.1", "15.2.1", "15.1.1", "14.24.1", "14.23.1",
"14.22.1", "14.21.1", "14.20.1", "14.19.1", "14.18.1", "14.17.1",
"14.16.1", "14.15.1", "14.14.1", "14.13.1", "14.12.1", "14.11.1",
"14.10.1", "14.9.1", "14.8.1", "14.7.1", "14.6.1", "14.5.1",
"14.4.1", "14.3.1", "14.2.1", "14.1.1", "13.24.1", "13.23.1",
"13.22.1", "13.21.1", "13.20.1","13.19.1", "13.18.1", "13.17.1", 
"13.16.1", "13.15.1", "13.14.1", "13.13.1", "13.12.1", "13.11.1", 
"13.10.1", "13.9.1", "13.8.1", "13.7.1", "13.6.1", "13.5.1",
"13.4.1", "13.3.1", "13.1.1"
</pre>
<!-- <img class="tft-traits" src="https://ddragon.leagueoflegends.com/cdn/15.12.1/img/tft-trait/Trait_Icon_4_Slayer.png"> -->
</body>
</html>
