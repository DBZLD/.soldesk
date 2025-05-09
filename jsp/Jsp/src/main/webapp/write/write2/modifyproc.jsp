<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String num = request.getParameter("num");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String id = request.getParameter("id");
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		String sql = String.format("update cat_board set title = '%s', id = '%s', content = '%s' where num = %s", title, id, content, num);
		st.executeUpdate(sql);
	}catch(Exception e){
		e.getStackTrace();
	}
	response.sendRedirect("list.jsp");
%>
</body>
</html>