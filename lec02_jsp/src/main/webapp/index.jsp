<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 홈화면</title>
</head>
<body>
	<!-- html 파일 대신에 jsp를 대신 쓸 수 있다. 가 아니라
	html 안에 Java 코드를 쓸 가능성이 있으니 jsp를 쓰는 것이다. -->
	<h1>1. JSP Scripting Element</h1>
	<a href="views/element/scripting.jsp">
		스크립팅 요소 연습
	</a>
	<h1>2. Directive Tag(page)</h1>
	<a href="views/element/pageTag.jsp">
		페이지 태그 연습
	</a>
	<h1>3. Directive Tag(include)</h1>
	<a href="views/element/includeTag.jsp">
		include 태그 연습
	</a>
	<h1>4. 응답화면으로 JSP 써보기</h1>
	<a href="views/pizzaOrder.jsp">
		피자 주문하기
	</a>
	<h1>과제 1번 / 도서 대출 시스템</h1>
	<a href="views/homework/bookReservation.jsp">
		도서 대출하기
	</a>
</body>
</html>