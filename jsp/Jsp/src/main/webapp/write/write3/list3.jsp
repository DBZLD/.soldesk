<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery("select*from cat_board");
		while(result.next()){
			String title = result.getString("title");
			String id = result.getString("id");
			String num = result.getString("num");
%>
			글 번호 :<%=num%> 글 제목 :<a href="read.jsp?num=<%=num %>"><%=title%></a> 작성자 : <%=id%> <br>	
<%
		}	
	}catch(Exception e){
		e.getStackTrace();
	}
%>
<a href="write.jsp">글 쓰러가기</a>
</body>
</html>