<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link href="<%=request.getContextPath()%>/resources/css/member/create.css" rel="stylesheet" type="text/css">
<script src="/resources/js/jquery-3.7.1.js"></script>
</head>
<body>
	<%@ include file="../include/header.jsp" %>
	<%@ include file="../include/nav.jsp" %>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>회원가입</h3>
				<br>
				<span>
					※아이디는 추후에 수정할 수 없습니다.※
					<br>🐥신중하게 선택해주세요.🐥
				</span>
			</div>
			<div class="create_member_form">
				<form action="/memberCreateEnd" name="create_member_form" method="post">
					<input type="text" name="member_id" placeholder="아이디">
					<br>
					<input type="password" name="member_pw" placeholder="비밀번호">
					<br>
					<input type="password" name="member_pw_check" placeholder="비밀번호 확인">
					<br>
					<input type="text" name="member_name" placeholder="이름">
					<br>
					<input type="button" value="회원가입" onclick="createMemberForm();">
				</form>
			</div>
			<div class="login">
				<a href="/memberLogin">로그인</a>
			</div>
		</div>
	</section>
	<script>
		const createMemberForm = function(){
			// 유효성 검사 할거다.
			// 자바의 새로운 기능 = document.querySelector("form[name=create_member_form][0]")
			// 근데 이게 name을 기준으로 접근하는 것인데 코드만 보고 name을 기준으로 접근하는 건지 확인하기 어렵다.
			const form = document.create_member_form;
			// falsy 쓰는 거다.
			// 와 이렇게도 쓸 수 있네. 이거 좋다
			if(!form.member_id.value){
				alert("아이디를 입력하세요.");
				form.member_id.focus();
			} else if(!form.member_pw.value){
				alert("비밀번호를 입력하세요.");
				form.member_pw.focus();
			} else if(!form.member_pw_check.value){
				alert("비밀번호 확인을 입력하세요.")
				form.member_pw_check.focus();
			} else if(form.member_pw.value != form.member_pw_check.value){
				alert("비밀번호가 일치하지 않습니다.")
				form.member_pw_check.focus();
			} else if(!form.member_name.value){
				alert("이름을 입력하세요.")
				form.member_name.focus();
			} else{
				// 25-02-13 어제는 그냥 submit으로 했다면 25-02-14 오늘은 ajax로 해보자
				// form.submit();
				
				// data : ajax 통신을 할 때 필요한 정보 중 요청을 보낼 때 서블릿에게 전달하는 정보 데이터
				// dataType : 이거는 데이터가 갔다 올 때 어느 타입으로 오는 지 설정
				// success의 data : 서블릿이 응답 해줄때 받아온 데이터
				$.ajax({
					url : "/memberCreateEnd",
					type : "post",
					data : {"member_id" : form.member_id.value,
						"member_pw" : form.member_pw.value,
						"member_name" : form.member_name.value},
					dataType : "JSON",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					success : function(data){
						// console.log(data);
						// res_msg를 alert창에 출력
						// 만약에 res_code가 200과 같다면
						// / 경로로 이동(location)
						alert(data.res_code)
						if(data.res_code == "200"){
							location.href="/views/member/create_success.jsp";
						} else{
							location.href="/views/member/create_fail.jsp";
						}
						/* else if(data.res_code == "500"){
							location.href="/sdfsdfsdf";
						} */
					}
				});
			}
		}
	</script>
</body>
</html>