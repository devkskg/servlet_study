<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
</head>
<body>
	<!-- <header> <nav> <section>섹션은 어떤 정보를 담고있냐 이런 모양이 반복 될때 include 태그를 사용하자?-->
	<!-- 웹컨텍스트패스 안써도 되는 이유는 인덱스 위치가 위치인만큼 -->
	<%@ include file="/views/include/header.jsp" %>
	<%@ include file="/views/include/nav.jsp" %>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>HOME</h3>
			</div>
		</div>
	</section>
</body>
</html>