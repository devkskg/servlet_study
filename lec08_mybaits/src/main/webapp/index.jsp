<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈화면</title>
</head>
<body>
	<ol>
		<li>
			<a href="/boardList">목록 조회</a>
		</li>
		<!-- 하드코딩해서 흐름을 살펴보자 -->
		<li>
			<c:url value="/boardDetail" var="url">
				<c:param name="board_no" value="7"/>
			</c:url>
			<a href="<c:url value='/boardDetail?board_no=7'/>">상세조회</a>
			<!-- 위 아래 똑같은 거다 -->
			<a href="${url }">상세조회(게시판 번호 7번 하드코딩) 이걸로 수정 해보자~</a>
		</li>
		<li>
			<c:url value="/boardDetail" var="detailUrl">
				<c:param name="board_title" value="제목"/>
				<c:param name="board_content" value="내용"/>
			</c:url>
				<a href="${detailUrl}">상세조회(2)(맵, vo 로 조회해보기)</a>
		</li>
		<li>
			<a>수정</a>
		</li>
		<li>삭제</li>
		<li>
			<form action="<c:url value='/boardCreate'/>" method="post">
				<fieldset>
					<legend>게시글</legend>
					<input type="text" name="board_title" placeholder="제목"><br>
					<input type="text" name="board_content" placeholder="내용"><br>
					<input type="number" name="board_writer" placeholder="회원번호"><br>
					<input type="submit" value="등록">
				</fieldset>
			</form>
		</li>
		<li>
			<a href="<c:url value='/boardManyInsert'/>">
				여러개 한번에 insert하기
			</a>
		</li>
	</ol>
</body>
</html>