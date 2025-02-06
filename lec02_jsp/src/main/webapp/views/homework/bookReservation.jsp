<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가남 도서관</title>
</head>
<body>
	<h1>도서 대출</h1>
	<!-- <form action="/borrow" method="get"> -->
	<form action="/borrow" method="post">
		<fieldset>
			<legend>고객 정보</legend>
			<label for="libName">고객명 : </label>
			<input name="libName" id="libName" type="text">
			<label for="libPhone">전화번호 : </label>
			<input name="libPhone" id="libPhone" type="text">
			<label for="libEmail">E-mail : </label>
			<input name="libEmail" id="libEmail" type="email">
		</fieldset>
		<fieldset>
			<legend>도서 선택</legend>
			<label>도서 : </label>
			<select name="bookName">
				<option value="0">선택하세요.</option>
				<option value="1">자바 프로그래밍 입문</option>
				<option value="2">웹 개발의 기초</option>
				<option value="3">데이터베이스 시스템</option>
			</select>
		</fieldset>
		<fieldset>
			<legend>대출 기간</legend>
			<label for="libDate">대출 기간 (일) : </label>
			<input name="libDate" id="libDate" type="number">
		</fieldset>
		<button>대출하기</button>
	</form>
</body>
</html>