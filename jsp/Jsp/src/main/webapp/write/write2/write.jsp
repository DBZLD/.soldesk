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
		�� ���� : <input name = "title"><br>
		�ۼ��� : <input name = "id"><br>
		�� ���� : <textarea name = "content" rows="5" cols="30"></textarea><br>
		<input type = "submit" value = "�� ����">
	</form>
</body>
</html>