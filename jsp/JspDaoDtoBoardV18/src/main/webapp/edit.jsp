<%@page import="db.Dto"%>
<%@page import="db.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String no = (String)request.getAttribute("no");
Dao dao = new Dao();
Dto dto = dao.read(no);
%>



<form action="/board/edit_proc">
	<input type="hidden" name="no" value="<%=no%>"> 
	제목 <input name="title" value="<%=dto.title%>">
	내용 <input name="text" value="<%=dto.text%>">
	<input type="submit" value="수정">
</form>
<a href="/borad/list">리스트로</a>
</body>
</html>