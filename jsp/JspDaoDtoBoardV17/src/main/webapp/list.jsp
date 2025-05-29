<%@page import="db.BoardListProcessor"%>
<%@page import="db.Board"%>
<%@page import="db.Dto"%>
<%@page import="db.Dao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
글번호, 제목, 작성자<hr>
<a href="write.jsp">쓰기</a><hr><hr>
<%

BoardListProcessor blp =(BoardListProcessor)request.getAttribute("blp"); 
ArrayList<Dto> posts = blp.posts;

for(int i = 0; i < posts.size(); i++){
%>

<%=posts.get(i).no%>
<a href="/board/read?no=<%=posts.get(i).no%>"><%=posts.get(i).title%></a>
<%=posts.get(i).id%>
<hr>
<%
}
%>
</body>
</html>