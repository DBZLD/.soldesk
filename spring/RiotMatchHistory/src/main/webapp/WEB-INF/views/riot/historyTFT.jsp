<%@page import="com.spring.service.HistoryInfosProcessor"%>
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
	<a href="${cp }/searchTFT">TFT 메인 화면으로 돌아가기</a>
	<br>
	<%

	HistoryInfosProcessor mat = (HistoryInfosProcessor)request.getAttribute("matchInfos");
	%>
	<div class = "mainBoard">
		<div class = "leftBoard">
			<%=mat.getPlayerName()%><br><br><br>
			랭크<br><%=mat.getPlayerRankInfo("RANKED_TFT")%><br><br>
			더블 업<br><%=mat.getPlayerRankInfo("RANKED_TFT_DOUBLE_UP")%><br><br>
			초고속 모드<br><%=mat.getPlayerRankInfo("RANKED_TFT_TURBO")%>
		</div>
		<div class = "rightBoard">
			<%
			for(int i = 0; i < mat.matchInfos.size(); i++){
			%>
		<table>	
			<tr>
				<td colspan="4">
					<%=mat.getMatchPlacement(i) %>|
					<%=mat.getMatchType(i) %>|
					<%=mat.getMatchTime(i)%>|
					<%=mat.getMatchDate(i)%>
				</td>
			</tr>
			<tr class="tft-table">
				<td class="tft-table-level">
					레벨
				</td>
				<td class="tft-table-trait">
					특성
				</td>
				<td class="tft-table-champion">
					챔피언
				</td>
				<td class="tft-table-player">
					유저
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