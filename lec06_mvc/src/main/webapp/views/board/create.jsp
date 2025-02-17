<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<link href='<%=request.getContextPath()%>/resources/css/board/create.css' 
rel="stylesheet" type="text/css">
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
					<input type="hidden" name="board_writer" value="<%=m.getMemberNo()%>">
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
					form.submit();
					// console.log(val);
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