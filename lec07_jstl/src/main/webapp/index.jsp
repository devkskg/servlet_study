<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL/JSTL연습</title>
</head>
<body>
	<h1>EL</h1>
	<!-- 가장 중요한 컨셉은 내장객체 -->
	<!-- EL은 꺼내오는 일만 하는애. 익스프레션태그 느낌이네 -->
	<h2>내장객체</h2>
	<%
		// 일부러 key값 똑같이 설정해서 EL 범위 테스트 해보자
		// 1. pageScope 설정
		pageContext.setAttribute("test", "페이지 범위");
		// 2. requestScope 설정
		request.setAttribute("test", "리퀘스트 범위");
		// 3. sessionScope 설정
		session.setAttribute("test", "세션 범위");
		// 4. applicationScope 설정
		application.setAttribute("test", "애플리케이션 범위");
	%>
	<h3>1. JSP 방식으로 꺼내오기</h3>
	<ul>
		<li><%=pageContext.getAttribute("test") %></li>
		<li><%=request.getAttribute("test") %></li>
		<li><%=session.getAttribute("test") %></li>
		<li><%=application.getAttribute("test") %></li>
	</ul>
	<h3>2. EL 방식으로 꺼내오기</h3>
	<!-- 그냥 키값 쓰면 가장 작은 범위를 가져옴 -->
	<p>${              test                                    }</p>
	<!-- ...Scope.키값 하면 해당하는 범주의 밸류를 가져옴 -->
	<p>${              requestScope.test                                    }</p>
	<h3>3. 객체 꺼내오기</h3>
		<%@ page import="com.gn.vo.Person" %>
		<%
			request.setAttribute("person", new Person("김철수", 77)); 
		%>
	<ol>
		<%-- <li>
			<% Person p = (Person)request.getAttribute("person"); %>
			JSP 방식 : <%=p.getName() + "(" + p.getAge()+")"%>
		</li> --%>
		<li>
			<!-- 
				0. setAttribute에서 썼던 key 값을 가져와서 . 붙여서 사용해야함.
				1. 다운캐스팅 X
				2. getter 알아서 실행됨(vo에 getter가 있긴 해야함)
				3. import와 객체 매개변수는 넣어줘야함
			 -->
			<!-- EL 방식은 사이에 + 못쓴다. -->
			EL 방식 : ${person.name} ( ${person.age})
		</li>
	</ol>
	
	<h2>EL의 연산자 연습</h2>
	<%@ page import="java.util.*" %>
	<%
		// 1. 숫자
		request.setAttribute("num1", 10);
		request.setAttribute("num2", 3);
		
		// 2. 문자
		request.setAttribute("str1", "사과");
		request.setAttribute("str2", "바나나");
		
		// 3. 객체
		request.setAttribute("p1", new Person("영희", 23));
		request.setAttribute("p2", null);
		
		// 4. 리스트
		request.setAttribute("list1", new ArrayList<String>());
		List<String> list2 = new ArrayList<String>();
		list2.add("오늘 날씨가 춥네요.");
		list2.add("저는 핫팩이 있어요.");
		request.setAttribute("list2", list2);
	%>
	<h3>1. 산술 연산</h3>
	<p>
		10 + 3 = ${num1+num2 }<br>
		10 - 3 = ${num1-num2 }<br>
		10 / 3 = ${num1 div num2 }<br>
		<!-- 이진 부동소수점 연산 때문에 값이 이상해짐. 예상 3.3334 -> 계산 했더니 3.3335 이렇게 나옴-->
		10 % 3 = ${num1 mod num2 }<br>
	</p>
	<h3>2. 문자열 연결</h3>
	<p>${str1 } : ${str2 }</p>
	<h3>3. 대소 비교</h3>
	<p>num1 : ${num1 }, num2 : ${num2 }</p>
	<p>num1이 num2보다 큰가요? : ${num1 gt num2}</p>
	<p>num1이 num2보다 작거나 같은가요? : ${num1 le num2}</p>
	<p>3이 3보다 크거나 같은가요? : ${3 ge 3}</p>
	<h3>4. 동등 비교</h3>
	<p>
		num1과 num2가 같나요? : ${num1 eq num2 }<br>
		num2과 3이 같은가요? : ${num2 eq 3 }<br>
		num2과 3이 다른가요? : ${num2 ne 3 }<br>
		문자 일치 : ${str1 eq str2 }<br>
		문자 불일치 : ${str1 ne str2 }
	</p>
	<h3>5. 비어있는지 확인</h3>
	<ol>
		<li>문자 비어있나요? : ${empty str1 }</li>
		<li>객체 비어있나요? : ${empty p2 }</li>
		<li>컬렉션1 비어있나요? : ${empty list1 }</li>
		<li>컬렉션1 들어있나요? : ${not empty list1 }</li>
		<li>컬렉션2 들어있나요? : ${not empty list2 }</li>
		<%-- <li>컬렉션1 비어있나요? : ${list1 empty }</li> --%>
	</ol>	
	<h3>6. 논리 연산자</h3>
	<p>
		${true and true }<br>
		${(num1 eq 10) and (num2 eq 3)}<br>
		${false or true }<br>
	</p>
	
	<hr>
	
	<h1>JSTL</h1>
</body>
</html>