<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키, 세션</title>
</head>
<body>
	<h1>쿠키 연습하기</h1>
	<ul>
		<li>
			<a href="/createCookie">생성하기</a>
		</li>
		<li>
			<% 
			String userId = "쿠키없음";
			if(cookies != null){
				for(Cookie c : cookies){
					if("user_id".equals(c.getName())){
						userId = c.getValue();
					}
				}
			} %>
			아이디 : <%=userId %>
		</li>
		<li>
			<a href="/editCookie">수정하기</a>		
		</li>
		<li>
			<a href="/removeCookie">삭제하기</a>
		</li>
	</ul>
	<a href="/changePage">화면 전환(방문횟수 연습문제)</a>
	
	<h2>세션 연습하기</h2>
	<ol>
		<li>
			<a href="/createSession">
				생성하기
			</a>
		</li>
		<li>
			<% 
				String memberId = "세션 없음";
				// 세션은 JSP의 내장객체다.
				// HttpSession session = new 연산자를 써서 이미 인스턴스화 했다.
				// JSP 들어가는 순간 이미 session은 null이 아니다.
				if(session != null){
					if(session.getAttribute("member_id") == null){
						memberId = "세션 없음";
					} else{
					memberId = (String)session.getAttribute("member_id");
					}
				}
			%>
			<%= memberId%>
		</li>
	</ol>
	
	<!-- 다이나믹 페이지 만든거다 -> 사용자 로그인 여부에 따라 다른 화면 -->
	<%if(session.isNew() || session.getAttribute("account") == null){%>
		<a href="/login">로그인</a>
	<%} else{%>
		<a href="/logout">로그 아웃</a>
	<%} %>
	
	
</body>
</html>