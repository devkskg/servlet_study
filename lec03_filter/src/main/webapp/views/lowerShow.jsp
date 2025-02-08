<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sizeLower = (String)request.getAttribute("sizeLower");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소문자 테스트</title>
</head>
<body>
	<h1>소문자 테스트</h1>
	<p>
		<%= sizeLower %>
	</p>
</body>
</html>