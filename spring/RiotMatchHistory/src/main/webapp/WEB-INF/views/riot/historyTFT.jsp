<%@page import="com.spring.service.HisrotyInfosProcessor"%>
<%@page import="com.spring.dto.tft.MatchDto"%>
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
	<form action="${cp }/riot/historyTFT">
		<input name = "playerID" placeholder="아이디">#
		<input name = "playerTag" placeholder="태그">
		<input type = "submit" placeholder="검색">
	</form>
	<a href="${cp }/">메인 화면으로 돌아가기</a>
	<br>
	<%
	HisrotyInfosProcessor mat = (HisrotyInfosProcessor)request.getAttribute("matchInfos");
	%>
	<div class = "mainBoard">
		<div class = "leftBoard">
			<br><br>
			<%=mat.getPlayerName()%>
			<br><br><br>
			<%=mat.getPlayerRankInfo()%>
			<br><br><br>
			<%=mat.getPlayerDURankInfo()%>
			<br><br><br>
			<%=mat.getPlayerTRankInfo()%>
			<br>
		</div>
		<div class = "rightBoard">
			<%
			for(int i = 0; i < mat.matchInfos.size(); i++){
			%>
		<table>	
			<tr>
				<td>
					<%=mat.getMatchPlacement(i) %>|
					<%=mat.getMatchType(i) %>|
					<%=mat.getMatchTime(i)%>|
					<%=mat.getMatchDate(i)%>
				</td>
			</tr>
			<tr>
				<td>
					ㅡㅡㅡㅡㅡ
				</td>
				<td>
					ㅡㅡㅡㅡㅡ
				</td>
			</tr>
		</table>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>