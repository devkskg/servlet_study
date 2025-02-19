<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<link href='<%=request.getContextPath()%>/resources/css/board/create.css' 
rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.7.1.js"></script>
</head>
<body>
	<%@ include file="/views/include/header.jsp" %>
	<%@ include file="/views/include/nav.jsp" %>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>게시글 등록</h3>
			</div><br>
			<div class="create_board_form">
				<form action='/boardCreateEnd' name="create_board_form" method="post" enctype="multipart/form-data">
				<!-- enctype="multipart/form-data" form태그의 이 속석은 안에 input의 type=file 있으면 꼭 써야함 -->
				<!-- 
					확장자 제한하는 방법 수업 할거다. = 특정 확장자 차단하는 방법
					- accept 속성을 사용해서 특정 확장자만 선택하게 제한 가능(강제 제한이 아니므로 다른 파일로 변경하여 업로드 가능)
					- 우리는 JavaScript를 이용해서 확장자 검사 - 허용되지 않은 파일이라면 별도로 차단해보자. (추가로 서버쪽에서 거르는 방법도 있다.)
					 -->	
					<input type="text" name="board_title" placeholder="제목을 입력하세요."> <br>
					<input type="text" name="board_content" placeholder="내용을 입력하세요."><br>
					<!-- 원래 쓰던 익스프레션태그를 JSTL 방법으로 바꿔보자 -->
					<%-- <input type="hidden" name="board_writer" value="<%=m.getMemberNo()%>"> --%>
					<input type="hidden" name="board_writer" value="<c:out value="${member.memberNo}"/>">
					<!-- <input type="file" name="board_file"> --> <!-- 이게 원본 -->
					<!-- 1번 -->
					<input type="file" name="board_file" accept=".png, .jpg, .jpeg">
					<br>
					<input type="button" value="등록" onclick="createBoardForm();"> 
					<input type="reset" value="취소">
				</form>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		const createBoardForm = function() {
			let form = document.create_board_form;	
			if(!form.board_title.value){
				alert("제목을 입력하세요.");
				form.board_title.focus();
			} else if(!form.board_content.value){
				alert("내용을 입력하세요.");
				form.board_content.focus();
			} else if (!form.board_file.value) {
				// 여기는 이미지 파일이 없을 때
				alert('이미지 파일을 선택하세요.');
				form.board_file.focus();	
			} else if(form.board_file.value){ 
				// 여기가 2번. 이미지 파일이 있을 때
				const val = form.board_file.value;
				const idx = val.lastIndexOf('.');
				const type = val.substring(idx + 1, val.length);
				if(type == 'jpg' || type == 'png' || type == 'jpeg'){
					// form.submit();
					// console.log(val);
					// input type=file 태그 있을 경우 ajax 조금 다르게 해줘야함
					const sendData = new FormData(form);
					$.ajax({
						url : '/boardCreateEnd',
						type : 'post',
						// 캐시(브라우저에 지나간 흔적 남는 것, 고의로 흘리지 않아도 남음)
						// enctype, cache, async 얘네 모두 짝꿍이다. file 할때는 동기 방식으로 해야한다. 
						// 파일을 해체할 수 없어서? 기본적인 방식으로 해야한다? 우리 단계에서는 동기 방식으로 하는 것이 맞다.
						// processType(데이터 잘라서 넘기기), contentType - post 방식으더라도 이걸 false로 바꿔줘야한다.
						
						// 괄호 안의 form은 위에 선언한 변수 let form이다.
						enctype : 'multipart/form-data',
						cache : false,
						async : false,
						contentType : false,
						processData : false,
						// FormData 는 매개변수의 값을 키:밸류 형식으로 감싸는 객체
						data : sendData,
						dataType : 'JSON',
						success : function(data){
							alert(data.res_msg);
							if(data.res_code == 200){
								location.href = "/boardList";
							}
						}
						
					})
				} else{
					alert('이미지 파일만 선택할 수 있습니다.');
					form.board_file.value = '';
					// form.board_file_focus(); // 이거까지 써야하나?
				}
			}
		}
	</script>
</body>
</html>