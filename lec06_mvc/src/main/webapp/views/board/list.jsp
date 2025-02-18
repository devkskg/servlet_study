<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.gn.board.vo.Board, java.util.*, java.time.format.*" %>
<%-- <%@ page import = "java.util.*" %> --%>
<% 
	List<Board> list = (List<Board>)request.getAttribute("ResultOfList"); 
	Board paging = (Board)request.getAttribute("paging");
%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href='<%=request.getContextPath()%>/resources/css/board/list.css' rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/include/paging.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.7.1.js"></script>
</head>
<body>
	<%@ include file="/views/include/header.jsp" %>
	<%@ include file="/views/include/nav.jsp" %>
	<section>
		<div id="section_wrap">
		<!-- 검색어 부분 -->
		<!-- 검색어 부분 -->
		<!-- 검색어 부분 -->
		<div class="search">
			<form action="/boardList" name="search_board_form" method="get">
				<%-- <input type="text" name="board_title" placeholder="검색하고자 하는 게시글 제목을 입력하세요." value="<%=paging.getBoardTitle() == null ? "" : paging.getBoardTitle()%>"> --%>
				<input type="text" name="board_title" placeholder="검색하고자 하는 게시글 제목을 입력하세요.">
				<input type="submit" value="검색">
			</form>	
		</div>
		<!-- 검색어 부분 -->
		<!-- 검색어 부분 -->
		<!-- 검색어 부분 -->
		
			<div class="word">
				<h3>게시글 목록</h3>
			</div><br>
			<div class="board_list">
				<table>
					<colgroup>
						<col width="10%">
						<col width="50%">
						<col width="20%">
						<col width="20%">
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일시</th>
						</tr>
					</thead>
					<tbody>
						<!-- 여기는 내 풀이 -->
						<%-- <%if(list.size() > 0){ 
							for(int i = 0; i < list.size(); i++){ %>
								<tr>
									<td><%= list.get(i).getBoardNo() %></td>
									<td><%= list.get(i).getBoardTitle() %></td>
									<td><%= list.get(i).getMemberName() %></td>
									<td><%= list.get(i).getRegDate() %></td>
								</tr>
							<%}
						} %> --%>
						<!-- 아래는 강사님 풀이 -->
						<%	
							List<Board> list2 = (List<Board>)request.getAttribute("ResultOfList");
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-MM-dd a hh:mm");
							for(int i = 0; i < list.size(); i++){ %>
								<!-- 눌렀을 때 상세보기! 커스텀 데이터 속성! -->
								<tr data-board-no="<%=list.get(i).getBoardNo()%>">
									<%-- <td><%=list.get(i).getBoardNo() %></td> --%>
									<td><%=(paging.getNowPage()-1)*paging.getNumPerPage()+(i+1) %></td>
									<td><%=list.get(i).getBoardTitle() %></td>
									<td><%=list.get(i).getMemberName() %></td>
									<td><%=list.get(i).getRegDate().format(dtf) %></td>
								</tr>
							<% } %>
					</tbody>
				</table>
			</div>
		</div>
	</section>	
	<%if(paging != null){ %>
		<div class="center">
			<div class="pagination">
				<%if(paging.isPrev()){ %>
					<!-- 이거 5번 페이지 가는 게 맞음? -->
					<%-- <a href="/boardList?nowPage=<%=(paging.getPageBarStart() - 1)%>&board_title=<%=paging.getBoardTitle() == null ? "" : paging.getBoardTitle()%>">&laquo;</a> --%>
					<a href="/boardList?nowPage=<%=(paging.getPageBarStart() - 1)%>&board_title=<%=paging.getBoardTitle()%>">&laquo;</a>
					<%-- <a href="/boardList?nowPage=<%=(paging.getPageBarStart() - 1)%>">&laquo;</a> --%>
				<%} %>
				
				
				<%for(int i = paging.getPageBarStart(); i <= paging.getPageBarEnd(); i++ ) {%>
					<%-- <a href="/boardList?nowPage=<%=i%>&board_title=<%=paging.getBoardTitle() == null ? "" : paging.getBoardTitle()%>"><%=i %></a> --%>
					<a href="/boardList?nowPage=<%=i%>&board_title=<%=paging.getBoardTitle()%>"><%=i %></a>
				<% }%>
				
				
				<%if(paging.isNext()){ %>
					<!-- 이거 6번 페이지 가는 게 맞음? -->
					<%-- <a href="/boardList?nowPage=<%=(paging.getPageBarEnd() + 1) %>&board_title=<%=paging.getBoardTitle() == null ? "" : paging.getBoardTitle()%>">&raquo;</a> --%>
					<a href="/boardList?nowPage=<%=(paging.getPageBarEnd() + 1) %>&board_title=<%=paging.getBoardTitle()%>">&raquo;</a>
				<%} %>
			</div>
		</div>
	<%} %>
	<script>
		$(function(){
			$('.board_list tbody tr').click(function(){
				const boardNo = $(this).data('board-no');
				location.href="/boardDetail?board_no="+boardNo;
			});
		})
	</script>
</body>
</html>