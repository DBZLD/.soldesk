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
			�� ��ȣ :<%=num%> �� ���� :<a href="read.jsp?num=<%=num %>"><%=title%></a> �ۼ��� : <%=id%> <br>	
<%
		}	
	}catch(Exception e){
		e.getStackTrace();
	}
%>
<a href="write.jsp">�� ��������</a>
</body>
</html>