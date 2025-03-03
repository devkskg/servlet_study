<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- (1.2.5JSTL 코어 불러오는 방법! 버전 다르면 docs 보고 맞는 taglib 써야함!)
 라이브러리 안의 코드를 가지고 오는 방법 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
		// pageContext.setAttribute("test", "페이지 범위");
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
		${list2}
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
	<h2>1. 변수</h2>
	<!-- c:set은 단일태그, 일반태그 형식 둘 다 된다. -->
	<c:set var="n1" value="15"/>
	<c:set var="n2" value="20"/>
	<c:set var="result" value="${n1+n2 }"/>
	
	<c:out value="${result }"/>
	
	<!-- c:set이 20> 이런 거면 c:set result 에서 합쳐질때부터 오류가 뜬다. -->
	<!-- c:out을 쓰는 이유 : 특수문자를 자동으로 안전하게 문자열로 처리해준다. -->
	<c:set var="hello" value="<b>strong</b>"/>
	<c:out value="${hello }"/>
	<!-- 문자열 막아주는 거 없애고 태그로서 쓰고싶다면! escapeXml / 사실 자주 쓰진 않는다. 알고만 있자.-->
	<c:out value="${hello }" escapeXml="false"/>
	
	<h2>2. 조건문(if)</h2>
	<c:if test="${num1 le num2}">
		<p>num1이 num2보다 작거나 같다.</p>
	</c:if>
	
	<h2>3. 조건문(choose)</h2>
	<c:choose>
		<c:when test="${num1 gt 20 }">
			<p>num1이 20보다 크다!</p>
		</c:when>
		<c:when test="${num1 ge 10 }">
			<p>num1이 10보다 크거나 같다!</p>
		</c:when>
		<c:otherwise>
			<p>num1이 10보다 작다!</p>
		</c:otherwise>
	</c:choose>
	
	<h2>4. 반복문(forEach)</h2>
	<c:forEach var="i" begin="1" end="10" step="2">
		<p>JSTL 사용 / 반복 숫자 : ${i }</p>
	</c:forEach>
	<% for(int i = 1; i <= 10; i=i+2) {%>
		<p>예전 방식 / 반복 숫자 : <%=i %></p>
	<%} %>
	<%
		String[] colors = {"red", "green", "blue"};
		request.setAttribute("colors", colors);
	%>
	<ul>
		<c:forEach var="color" items="${colors}">
			<li style="color:${color}">${color}</li>		
		</c:forEach>
	</ul>
	<%
		String[] smaller = {"어디", "까지", "작아", "지는", "거에", "요?"};
		request.setAttribute("smaller", smaller);
	%>
	<%-- <c:forEach var="i" begin="1" end="6" items="${smaller}"> --%>
	<c:forEach var="i" begin="0" end="7">
	<!-- 인덱스가 설정된 값보다 초과하는데도 익셉션 안뜨네? -->
		<%-- <h${i}>어디까지 작아지는 거에요?</h> --%>
		<h${i+1}>${smaller[i]}</h>
	</c:forEach>
	
	<c:forEach var="num" begin="1" end="5" step="2" varStatus="vs159">
		<%-- <p <c:if test="${vs159.first}"> style="color:red"</c:forEach>> --%>
		<p>
			인덱스(begin부터 인덱스 출력) : ${vs159.index }<br>
			카운트(현재반복횟수) : ${vs159.count }<br>
			첫번째인가요?(true/false) : ${vs159.first }<br>
			마지막인가요?(true/false) : ${vs159.last }<br>
		</p>
	</c:forEach>
	<hr>
	<h1>JSTL Formatting Library</h1>
	<h2>1. formatNumber</h2>
	<fmt:formatNumber type="number" value="1000.156"/><br>
	<fmt:formatNumber type="number">1000.156</fmt:formatNumber><br>
	<fmt:formatNumber type="currency" value="1000.156"/><br>
	<fmt:formatNumber type="currency">1000.156</fmt:formatNumber><br>
	
	<!-- 지역 세팅 -> 앞의 통화기호 및 소수점 단위도 달라짐 -->
	<fmt:setLocale value="en_US"/>
	<fmt:formatNumber type="currency" value="1000.156"/><br>
	<fmt:formatNumber type="currency">1000.156</fmt:formatNumber><br>
	
	<fmt:formatNumber maxFractionDigits="5" type="percent" value="0.8759598498498"/>
	<fmt:formatNumber maxIntegerDigits="1" type="percent" value="0.8759598498498"/>
	<br><br><br>
	<fmt:formatNumber pattern="#,###.##" value="1234.567"/><br>
	<fmt:formatNumber pattern="00000.00" value="1234.5"/><br>
	<fmt:formatNumber pattern="0.0" value="1234.5"/>
	
	<h2>2. formatDate</h2>
	<c:set var="now" value="<%=new java.util.Date() %>"/>
	<fmt:formatDate value="${now }" type="date"/><br>
	<fmt:formatDate value="${now }" pattern="yy년MM월dd일 HH:mm"/><br>
	
	<!-- ParseDate, 얘는 출력X 세팅만 하는 애다. -->
	<fmt:parseDate value="2025-02-20" pattern="yyyy-MM-dd" var="parseDate"/>
	<fmt:formatDate value="${parseDate }" pattern="yy년MM월dd일이다~"/>
	
	
	<h1>JSTL Function Library</h1>
	<c:out value="${fn:contains('abc', 'c') }"/>
	<c:if test="${fn:contains('abc', 'c') }">
		<p>abc에 c가 있나요? 네~</p>
	</c:if>
	<c:set var="data" value="Hello~ i am fine!"/>
	<p>
		<c:out value="${fn:toUpperCase(data) }"/>
	</p>
	<p>
		<c:out value="${fn:replace(data, 'fine', 'apple') }"/>
	</p>
	<p>
		<c:out value="${fn:contains(data, 'fine') ? 'O' : 'X' }"></c:out>
	</p>
	<p>
		<c:out value="${fn:substring(data, 2, 4)}"></c:out>
	</p>
	
</body>
</html>