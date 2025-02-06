<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립팅 요소 연습</title>
</head>
<body>
	<%-- 이 방법은 JSP 주석 태그랍니다 --%>
	<%-- Scriptlet : 일반적인 자바 코드 --%>
	<%
		int sum = 0;
		for(int i = 0 ; i < 11; i++){
			sum += i;
		}
		//System.out.println(sum); // 콘솔 창에 표준출력한다.
		out.println("총합(1) : " + sum);
	%>
	<br>
	<%-- Expression : (화면에)출력 --%>
	<%=
		"총합(2) : " + sum
	%>
	<%-- Declaration : 선언(멤버 변수나 이런 것들) --%>
	<%!
		int visitCount = 0;
	%>
	<%! 
		public int sumNum(int a, int b){
			return a + b;
		}
	%>
	<%visitCount++;%>
	<br>
	<%= "조회수 : " + visitCount%>
	<%= "더하기 : " + sumNum(3,4) %>
</body>
</html>