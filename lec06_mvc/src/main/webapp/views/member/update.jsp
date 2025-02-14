<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import = "com.gn.member.vo.Member" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정 수정 화면</title>
<link href="/resources/css/member/update.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="/views/include/header.jsp" %>
	<!-- include 하면 해당 파일의 import, session 등을 가져와서 쓸 수 있다. 하나의 jsp로 컴파일 된다? 그래서다~ / 장점은 이렇게 쓸 수 있는데 단점으로 충돌 나는 것 주의  -->
	<%@ include file="/views/include/nav.jsp" %>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>계정 수정</h3>
			</div>
			<br>
			<%-- Member m = (Member)session.getAttribute("member"); --%>
			<div class="update_member_form">
				<form action='/memberUpdateEnd' name="update_member_form" method="post">
					<input type="hidden" name="member_no" value="<%=m.getMemberNo()%>">
					<!-- disabled 쓰면 데이터가 백엔드 뒤로 가지 않는다. + 사용자가 못 쓰는 칸 -->
					<input type="text" name="member_id" value="<%=m.getMemberId()%>" readonly disabled> <br>
					<input type="password" name="member_pw" placeholder="수정 비밀번호"> <br>
					<input type="password" name="member_pw_check" placeholder="수정 비밀번호 확인"> <br>
					<input type="text" name="member_name" value="" placeholder="닉네임"> <br>
					<input type="button" value="수정" onclick="updateMemberForm();">
				</form>
			</div>
		</div>	
	</section>	
	<script>
	const updateMemberForm = function(){
		const form = document.update_member_form;
		if(!form.member_id.value){
			alert('아이디를 입력하세요');
			form.member_id.focus();
		}else if(!form.member_pw.value){
			alert('비밀번호를 입력하세요.');
			form.member_pw.focus();
		} else if(!form.member_pw_check.value){
			alert('비밀번호 확인을 입력하세요.');
			form.member_pw_check.focus();
		} else if(!form.member_name.value){
			alert('닉네임을 입력하세요.');
			form.member_name.focus();
		} else{
			// form.submit();
			// 1. 경로 : /memberUpdateEnd
			// 2. 타입 : post
			// 3. 응답 방식 : JSON
			// 4. 요청 데이터 : member_pw, member_name, member_no
			// 5. 응답 성공 : 
			//				1) res_msg를 alert창에 출력 
			//				2) res_code가 200일때 /로 이동
			$.ajax({
				url : "/memberUpdateEnd",
				type : "post",
				data : {
					"member_pw" : form.member_pw.value,
					"member_name" : form.member_name.value,
					"member_no" : form.member_no.value
					},
				dataType : "JSON",
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				success : function(data){
					alert("코드번호:" + data.res_code + "\n내용:" + data.res_msg);
					if(data.res_code == "200"){
						location.href="/";
					}
				}
			});
		}
	}
	</script>
</body>
</html>