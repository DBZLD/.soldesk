<%@page import="board.Dto"%>
<%@page import="board.Dao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
글 번호 | 글 제목 | 작성자 <br>
<%
	String pageNum = request.getParameter("pageNum");
	if(pageNum == null){
		pageNum = "1";	
	}
	Dao dao = new Dao();
	ArrayList<Dto> post = new ArrayList<>();
	post = dao.list(pageNum);
	for(int i = 0; i < post.size(); i++){
%>
	<%=post.get(i).no %> <%=post.get(i).title %> <%=post.get(i).id%> <br>
<%
	}
%>
</body>
</html>