<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link href="<%=request.getContextPath()%>/resources/css/member/create.css" rel="stylesheet" type="text/css">
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
				<a href="#">로그인</a>
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
				form.submit();
			}
		}
	</script>
</body>
</html>