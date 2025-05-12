<%@page import="java.sql.ResultSet"%>
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
	String title = null;
	String id = null;
	String content = null;
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery("select*from cat_board where num = "+num);
		
		result.next();
		title = result.getString("title");
		id = result.getString("id");
		content = result.getString("content");
	}catch(Exception e){
		e.getStackTrace();
	}
	%>
	<form action="modifyproc.jsp" method="get">
	<input name = "num" type = "hidden" value = "<%=num%>">
		<input name = "title" value = "<%=title%>"> <br>
		<input name = "id" value = "<%=id%>"> <br>
		<textarea name = "content" ><%=content%></textarea> <br>
		<input type = "submit">
	</form>
</body>
</html>