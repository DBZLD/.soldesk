<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
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
	<%
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery("select*from cat_board");
		
		while(result.next()){
			String num = result.getString("num");
			String title = result.getString("title");
			String id = result.getString("id");
			%>
			글 번호 <%=num%> 글 제목 <%=title%> 작성자 <%=id%> <br>
<%
		}
	} catch (Exception e){
		e.printStackTrace();
	}
%>
<br> <a href="write.jsp">글 쓰기</a>
</body>
</html>