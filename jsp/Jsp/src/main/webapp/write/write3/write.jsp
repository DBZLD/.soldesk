<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	글 쓰기 <br>
	<form action="writeproc.jsp" method="get">
	제목 : <input name = "title"> <br>
	작성자 : <input name = "id"><br>
	내용 : <textarea name = "content" rows = "5" cols = "30"></textarea><br>
	</form>
</body>
</html>