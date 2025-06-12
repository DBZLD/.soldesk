<%@page import="com.spring.service.HisrotyInfosProcessor"%>
<%@page import="com.spring.dto.MatchDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${cp}/resources/common.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<h1>TFT 전적 검색</h1>
	<br>
	<a href="${cp }/riot/searchTFT">검색으로 돌아가기</a>
	<br>
	<%
	HisrotyInfosProcessor mat = (HisrotyInfosProcessor)request.getAttribute("matchInfos");
	%>
	<div class = "mainBoard">
		<div class = "rightBoard">
			<br><br><br>
			닉네임 : <%=mat.getPlayerName()%>
			<br><br><br>
			랭크 : <%=mat.getPlayerRank()%>
			<br>
			승 : <%=mat.getPlayerRankInfo().wins %>
			패 : <%=mat.getPlayerRankInfo().losses %>
			<br><br><br>
			더블업 랭크 : <%=mat.getPlayerDURank()%>
			<br>
			승 : <%=mat.getPlayerDURankInfo().wins %>
			패 : <%=mat.getPlayerDURankInfo().losses %>
			<%=mat.matchInfos.get(3).info.tft_game_type %>
			
		</div>
		<div class = "leftBoard">
		<table>	
			<%
			for(int i = 0; i < mat.matchInfos.size(); i++){
			%>
			<tr>

				<td>
					등수 : <%=mat.getMatchType(0) %>
				</td>
				<td>
					ㅡㅡㅡㅡㅡ
				</td>
			</tr>
			<tr>
				<td>
					ㅡㅡㅡㅡㅡㅡ
				</td>
				<td>
					ㅡㅡㅡㅡㅡ
				</td>
			</tr>
			<%
			}
			%>
		</table>
		</div>
	</div>
</body>
</html>