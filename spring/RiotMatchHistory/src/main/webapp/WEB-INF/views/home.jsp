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
<a href="${cp}/riot/searchTFT">TFT 전적 검색</a>
<img class="tft-traits" src="https://ddragon.leagueoflegends.com/cdn/15.12.1/img/tft-trait/Trait_Icon_4_Slayer.png">
</body>
</html>
