<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제이쿼리 Ajax</title>
<!-- 아래 처럼 상대경로를 쓰면 쓰려는 jsp마다 위치를 바꿔야 한다. 그래서 밑밑의 절대 경로를 쓰자 -->
<!-- <script src="../../resources/jquery-3.7.1.js"></script> -->
<!-- 절대경로 쓰는법. jsp의 내장객체 request 의 메소드 getContextPath()사용 -->
<script src="<%= request.getContextPath()%>/resources/jquery-3.7.1.js"></script>
</head>
<body>
	<input type="text" id="userId" name="user_id" placeholder="아이디 입력">
	<button type="button" id="get_btn">Get방식</button>
	<button type="button" id="post_btn">Post방식</button>
	
	<div id="result_div">
		
	</div>
	<script>
		$(document).ready(function(){
			// get 방식
			$('#get_btn').click(function(){
				// alert('버튼 동작 확인');
				
				const userId = $('#userId').val();
				$.ajax({
					// 필요한 속성 정보를 객체 형태(key:value[,key:value])
					url : "/jQueryAjaxGet?userId="+userId,
					type : "get",
					// success는 value값이 function이다.(보통 매개변수 이름은 data라고 한다.)
					success : function(data){
						console.log("======success======");
						console.log(data);
						$('#result_div').append(data);
					},
					// 에러도 value function 주로 쓰나?(보통 매개변수 3개 쓴다.)
					// 어제 JS했던 기반으로 생각해보면 request는 xhr, error는 에러
					error : function(request, status, error){
						console.log("======error======");
						console.log(request);
						console.log(status);
						console.log(error);
					}
				});
			});
			
			// post 방식
			$('#post_btn').click(function(){
				// $.ajax({});
				const userId = $("#userId").val();
				$.ajax({
					url : "/jQueryAjaxGet",
					type : "post",
					// Http 통신 규약?, JS에서 xhr.setRequestHeader("~") 이 부분이다
					contentType : "application/x-www-form-urlencoded; charset=UTF-8",
					// 보낼 데이터 {String 키값 : const userId위에 있는 변수[, 여러개 : 가능]}
					data : {userId : userId},
					success : function(data){
						$('#result_div').append("<p>======post======</p>");
						$('#result_div').append(data);
					},
					error : function(){
						alert("서버 요청 중 오류 발생!");
					}
				});
			})
			
		})
	</script>
</body>
</html>