<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기 통신</title>
<!-- 절대경로 쓰는법. jsp의 내장객체 request 의 메소드 getContextPath()사용 -->
<script src="<%= request.getContextPath()%>/resources/jquery-3.7.1.js"></script>
</head>
<body>
	<h1>JavaScript</h1>
	<a href="/jsAjaxPage">연습 화면 이동(JavaScript)</a>
	
	<h1>jQuery</h1>
	<a href="/views/jquery/sample.jsp">연습 화면 이동(jQuery)</a>
	
	<!-- Ajax와 JSON은 큰 관계 없다. -->
	<h1>JSON</h1>
	<input type="button" value="조회" id="jason_btn">
	<div id="result_div"></div>
	
	<script>
		$(function(){
			$('#jason_btn').click(function(){
				$.ajax({
					// 해당 url을 가지고 있는 Servlet으로 간다
					url : "/accountList",
					// get 방식으로
					type : "get",
					// dataType은 JSON
					dataType : "JSON",
					success : function(data){
						// 객체로 받기
						/* // 알아서 데이터 제이슨으로 읽어준다?
						console.log(data);
						// data를 객체로 보면 된다. 아래처럼 써서 원하는 모양으로 표현 가능
						console.log(data.no + " : " +data.name); */
						
						// 배열로 받기
						console.log(data);
						console.log(data.accountList);
						for(let i = 0; i < data.accountList.length; i++){
							$('#result_div').append("<p>"+data.accountList[i].name+"</p>");
						}
						
					},
					error : function(){
						alert('에러입니다~');
					}
				})
			});
		})
	</script>
	
	<h1>방명록(연습문제)</h1>
	<a href="/guestbookservlet">방명록으로 이동</a>
	
	
	<h1>장바구니 담기</h1>
	<a href="/productList">상품 목록</a>
	<a href="/cartList">장바구니</a>
</body>
</html>