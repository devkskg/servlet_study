<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! int num = 1; %>
<%
	Cookie[] cookies = request.getCookies();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방문 횟수</title>
</head>
<body>
	<%
		/* JSP에서만 해결하려고 하니까 매우 어려움. Servlet에서 복잡한 코드 소화 필요할 듯. */
		String str = String.valueOf(num++);
		Cookie c = new Cookie("visit_count", str);
		c.setMaxAge(60*60*24);
		response.addCookie(c);
		
		
	%>
	<p>
	당신은 이 페이지를 
	<strong><%=str%></strong>번 방문했습니다.
	</p>
	<a id="remove" href="/removeCountServlet">초기화 고?</a>
</body>
</html>