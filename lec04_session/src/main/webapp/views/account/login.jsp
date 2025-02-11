<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<form action="/loginEnd" method="post">
		<label for="accountId">아이디 : </label>
		<input type="text" id="accountId" name="account_id">
		<br>
		<label for="accountPw">비밀번호 : </label>
		<input type="text" id="accountPw" name="account_pw">
		<br>
		<input type="checkbox" id="rememberId" name="remember_id">
		<label for="rememberId">아이디 기억하기</label>
		<button>로그인</button>
	</form>
</body>
</html>