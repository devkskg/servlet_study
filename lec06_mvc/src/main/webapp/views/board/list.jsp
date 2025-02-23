<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.gn.board.vo.Board, java.util.*, java.time.format.*"%>
<%-- <%@ page import = "java.util.*" %> --%>
<% 
	List<Board> list = (List<Board>)request.getAttribute("ResultOfList"); 
	Board paging = (Board)request.getAttribute("paging");
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>게시판</title>

<link href='<%=request.getContextPath()%>/resources/css/board/list.css' rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/include/paging.css" rel="stylesheet" type="text/css">
<%-- <script src="<%=request.getContextPath()%>/resources/js/jquery-3.7.1.js"></script> --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%> <!-- 이거 nav에 있는데 nav 불러오면 해결되는 거 아님? 안되는데? = include nav 아래로 내렸다! 된다! 아오 또 안되는데? -->
<%-- <script src='<c:url value="/resources/js/jquery-3.7.1.js"/>'></script> --%>

</head>
<body>
	<%@ include file="/views/include/header.jsp" %>
	<%@ include file="/views/include/nav.jsp" %>
<script src='<c:url value="/resources/js/jquery-3.7.1.js"/>'></script>
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
				<p>1. Scriptlet : <%=paging.getBoardTitle() %></p>
				<p>2. EL : ${paging.boardTitle }</p>
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
							<%List<Board> list2 = (List<Board>)request.getAttribute("ResultOfList"); %>
							<%DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-MM-dd a hh:mm"); %>
							<%-- <% for(int i = 0; i < list.size(); i++){ %>
								<!-- 눌렀을 때 상세보기! 커스텀 데이터 속성! -->
								<tr data-board-no="<%=list.get(i).getBoardNo()%>">
									<td><%=list.get(i).getBoardNo() %></td>
									<td><%=(paging.getNowPage()-1)*paging.getNumPerPage()+(i+1) %></td>
									<td><%=list.get(i).getBoardTitle() %></td>
									<td><%=list.get(i).getMemberName() %></td>
									<td><%=list.get(i).getRegDate().format(dtf) %></td>
								</tr>
							<% } %> --%>
							<!-- 강사님 풀이 -->
							<c:choose>
								<c:when test="${not empty ResultOfList }">
									<c:forEach items="${ResultOfList }" var="b" varStatus="vs">
										<tr data-board-no="${b.boardNo }">
											<td>${(paging.nowPage-1) * paging.numPerPage + (vs.index+1)}</td>
											<td>${b.boardTitle }</td>
											<td>${b.memberName }</td>
											<%-- <td>${b.regDate }</td> --%>
											<fmt:parseDate value="${b.regDate }" pattern="yyyy-MM-dd'T'HH:mm:ss" var="strRegDate"/>
											<td><fmt:formatDate value="${strRegDate}" pattern="yy년MM월dd일 출력확인~"/></td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="4">
											조회된 데이터가 없습니다.
										</td>
									</tr>
								</c:otherwise>
							</c:choose>
							<!-- 아래는 내 풀이 -->
							<%-- <c:forEach var="list3" items="${ResultOfList}" varStatus="vs">
								<tr data-board-no="${list3.boardNo }">
									<td>${(paging.nowPage-1) * paging.numPerPage + (vs.index+1)}</td>
									<td>${list3.boardTitle}</td>
									<td>${list3.memberName}</td>
									<td>${list3.regDate}</td>
								</tr>
							</c:forEach> --%>
							
					</tbody>
				</table>
			</div>
		</div>
	</section>	
	<%-- <%if(paging != null){ %> --%>
	<c:if test="${not empty paging}">
		<div class="center">
			<div class="pagination">
				<%-- <%if(paging.isPrev()){ %>
					<!-- 이거 5번 페이지 가는 게 맞음? -->
					<a href="/boardList?nowPage=<%=(paging.getPageBarStart() - 1)%>&board_title=<%=paging.getBoardTitle() == null ? "" : paging.getBoardTitle()%>">&laquo;</a>
					<a href="/boardList?nowPage=<%=(paging.getPageBarStart() - 1)%>&board_title=<%=paging.getBoardTitle()%>">&laquo;</a>
					<a href="/boardList?nowPage=<%=(paging.getPageBarStart() - 1)%>">&laquo;</a>
				<%} %> --%>
				<c:if test="${paging.prev}">
					<%-- <a href="/boardList?nowPage=${paging.pageBarStart - 1}&board_title=${paging.boardTitle}">&laquo;</a> --%>
					<!-- c:url 사용해보자! -->
					<c:url var="testUrl" value="/boardList">
						<c:param name="nowPage" value="${paging.pageBarStart - 1}"/>
						<c:param name="board_title" value="${paging.boardTitle}"/>
					</c:url>
					<a href="${testUrl}">&laquo;</a>
				</c:if>
				
				
				<%-- <%for(int i = paging.getPageBarStart(); i <= paging.getPageBarEnd(); i++ ) {%>
					<a href="/boardList?nowPage=<%=i%>&board_title=<%=paging.getBoardTitle() == null ? "" : paging.getBoardTitle()%>"><%=i %></a>
					<a href="/boardList?nowPage=<%=i%>&board_title=<%=paging.getBoardTitle()%>"><%=i %></a>
				<% }%> --%>
				<c:forEach begin="${paging.pageBarStart }" end="${paging.pageBarEnd }" varStatus="vs">
					<a href="/boardList?nowPage=${vs.index }&board_title=${paging.boardTitle}">${vs.index }</a>
				</c:forEach>
				
				
				<%-- <%if(paging.isNext()){ %>
					<!-- 이거 6번 페이지 가는 게 맞음? -->
					<a href="/boardList?nowPage=<%=(paging.getPageBarEnd() + 1) %>&board_title=<%=paging.getBoardTitle() == null ? "" : paging.getBoardTitle()%>">&raquo;</a>
					<a href="/boardList?nowPage=<%=(paging.getPageBarEnd() + 1) %>&board_title=<%=paging.getBoardTitle()%>">&raquo;</a>
				<%} %> --%>
				<c:if test="${paging.next }">
					<a href="/boardList?nowPage=${paging.pageBarEnd + 1}&board_title=${paging.boardTitle}">&raquo;</a>
				</c:if>
			</div>
		</div>
	<%-- <%} %> --%>
	</c:if>
	
	
	
	
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