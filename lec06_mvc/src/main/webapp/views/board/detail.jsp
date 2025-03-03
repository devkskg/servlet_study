<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.gn.board.vo.Board,java.time.format.*" %>
<% Board board = (Board)request.getAttribute("boardYo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 화면</title>
<link href='<%=request.getContextPath()%>/resources/css/board/detail.css' rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="/views/include/header.jsp" %>
	<%@ include file="/views/include/nav.jsp" %>
	<section>	
		<div id="section_wrap">
			<div class="word">
				<h3>게시글 상세 정보</h3>
			</div>
			<div class="board_detail">
				<ul>
					<li>
						<!-- newName 말고 attachNo 쓸거다!! -->
						<!-- newName 말고 attachNo 쓸거다!! -->
						<!-- newName 말고 attachNo 쓸거다!! -->
						<%-- <%System.out.println("C:\\upload\\board\\" + board.getNewName()); %> --%>
						<!-- 왜 바로 쓰는 게 안되냐? -> 브라우저의 보안정책(same-origin-policy) 때문 -->
						<%-- <img src="C:\\upload\\board\\<%=board.getNewName()%>"> --%>
						<!-- UUID가 길어서 + 이름에 . 들어가있어서 url에 적용 안 될수도있다. -->
						<%-- <img src="<%=request.getContextPath()%>/filePath?new_name=<%=board.getNewName()%>"> --%>
						<!-- newName 말고 attachNo 쓸거다!! -->
						<!-- newName 말고 attachNo 쓸거다!! -->
						<!-- newName 말고 attachNo 쓸거다!! -->
						<img src="<%=request.getContextPath()%>/filePath?attach_no123=<%=board.getAttachNo()%>">
						<br>
						<!-- 위에는 이미지 보여주기, 아래 a태그는 다운로드 받을 수 있도록 -->
						<a href="<%=request.getContextPath()%>/fileDownload?attach_no321=<%=board.getAttachNo()%>">파일 다운로드</a>
					</li>
					<li>
						<table>
							<tr>
								<td>제목</td>
								<td>${boardYo.boardTitle}</td>
							</tr>
							<tr>
								<td>내용</td>
								<td>${boardYo.boardContent}</td>
							</tr>
							<tr>
								<td>작성자</td>
								<td><%=board.getMemberName() %></td>
							</tr>
							<tr>
								<%DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm"); %>
								<td>등록일</td>
								<td><%=board.getRegDate().format(dtf) %></td>
							</tr>
							<tr>
								<td>수정일</td>
								<td><%=board.getModDate().format(dtf) %></td>
							</tr>
						</table>
					</li>
				</ul>
				
			</div>
			
			<div class="buttons">
				<a href="">수정</a>
				<a href="">삭제</a>			
			</div>
		</div>
	</section>
</body>
</html>