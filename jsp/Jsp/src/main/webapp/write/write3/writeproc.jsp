<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
		String title = request.getParameter("title");
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			Statement st = con.createStatement();
			
			st.executeUpdate(String.format("insert into cat_board(title, id, content) value('%s', '%s', '%s')",title, id, content));
		}catch(Exception e){
			e.getStackTrace();
		}
		response.sendRedirect("list.jsp");
	%>
</body>
</html>