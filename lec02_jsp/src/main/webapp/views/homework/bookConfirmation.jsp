<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String libName = (String)request.getAttribute("libName");
	String libPhone = (String)request.getAttribute("libPhone");
	String libEmail = (String)request.getAttribute("libEmail");
	String bookName = (String)request.getAttribute("bookName");
	String libDate = (String)request.getAttribute("libDate");
	int totalPrice = (int)request.getAttribute("totalPrice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 대출 내역</title>
</head>
<body>
	<h1>도서 대출 내역</h1>
	<h4>[고객 정보]</h4>
	<ul>
		<li>고객명 : <%=libName %></li>
		<li>전화번호 : <%=libPhone %></li>
		<li>이메일 : <%=libEmail %></li>
	</ul>
	<h4>[대출 정보]</h4>
	<ul>
		<li>도서 제목 : <%=bookName %></li>
		<li>대출 기간 : <%=libDate %></li>
	</ul>
	<h4>대출 금액 : <%=totalPrice %>원</h4>
	<h3>도서를 즐겁게 읽으세요!</h3>
</body>
</html>