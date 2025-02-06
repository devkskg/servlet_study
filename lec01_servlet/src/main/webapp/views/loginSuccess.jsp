<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 위에 디렉티브 태그가 다른다. 이게 달라야 JSP? 사용가능? -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과화면</title>
</head>
<body>
	<!-- 이런 방식으로 자바 코드르 작성할 수 있다. -->
	<h1>반가워요! <%= request.getAttribute("userId")%> 님</h1>
	<h2>비밀번호가 <%= request.getAttribute("userPw") %>이시네요~</h2>
	<a href="/">홈페이지로 이동하기~</a>
</body>
</html>