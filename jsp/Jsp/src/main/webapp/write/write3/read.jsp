<%@page import="java.sql.ResultSet"%>
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
	String num = request.getParameter("num");
	
	try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
	Statement st = con.createStatement();
	ResultSet result = st.executeQuery("select*from cat_board where num = "+num);
	
	result.next();
	String title = result.getString("title");
	String id = result.getString("id");
	String content = result.getString("content");
%>
	�� ��ȣ : <%=num %> �� ���� : <%=title %> �ۼ��� : <%=id %> <br> <%=content %> <br>
<%
	
	}catch(Exception e){
		e.getStackTrace();
	}	
%>
<a href="delproc.jsp?num=<%=num%>">�� �����ϱ�</a> <br>
<a href="modify.jsp?num=<%=num%>">�� �����ϱ�</a>
</body>
</html>