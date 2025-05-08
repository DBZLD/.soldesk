<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="writeproc.jsp" method="get">
		글 제목 : <input name = "title"><br>
		작성자 : <input name = "id"><br>
		글 내용 : <textarea name = "content" rows="5" cols="30"></textarea><br>
		<input type = "submit" value = "글 쓰기">
	</form>
</body>
</html>