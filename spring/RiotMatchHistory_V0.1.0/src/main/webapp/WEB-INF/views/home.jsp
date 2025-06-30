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
<h1>전적 검색</h1>
<form action="/riot/getTFTRecord">
<input name="playerID" placeholder="아이디">
<input name="playerTag" placeholder="태그">
<input type="submit" value = "api보기">
</form>
<a href="${cp}/riot/getTFTRecord?playerID=dbzld&playerTag=9476">내계정 api</a>
<a href="${cp}/riot/TFTApi">번역 및 이미지 api목록</a>
<!-- <img class="tft-traits" src="https://ddragon.leagueoflegends.com/cdn/15.12.1/img/tft-trait/Trait_Icon_4_Slayer.png"> -->
</body>
</html>
