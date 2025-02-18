package com.gn.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Board;

@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Board> resultList = new BoardService().selectBoardList();
//		System.out.println(resultList);
//		
//		RequestDispatcher view = request.getRequestDispatcher("/views/board/list.jsp");
//		request.setAttribute("ResultOfList", resultList);
//		view.forward(request, response);
		// 위에는 검색기능 없는 상태 / 이전 수업 내용
		// 위에는 검색기능 없는 상태 / 이전 수업 내용
		// 위에는 검색기능 없는 상태 / 이전 수업 내용
		
		// 검색 기능 넣는 수업 시작
		// 검색 기능 넣는 수업 시작
		// 검색 기능 넣는 수업 시작
		String boardTitle = request.getParameter("board_title");
		String nowPage = request.getParameter("nowPage");
		
		// 바구니 하나 만들어서 검색 타이틀 담자. 페이징도 할거야~
		Board option = new Board();
		if(nowPage != null) {
			option.setNowPage(Integer.parseInt(nowPage));
		}
//		boardTitle setter 사용시 왜 지맘대로 getParameter에서 "", "null" 두개가 다르게 오는겨?
//		-> 입장 하자마자 아래의 코드가 한번 돌아서 null인 값이 ""(=공값)을 가지게 된 상태로 시작된다.
//		-> if문이 없는 setter는 한번 돌면 없는 것을 참조하므로 null 값을 갖게 되고 그것을 보내주니까 "null"로 오게 되는 것이다.
//		내가 짠 코드
		if(boardTitle != null) {
			option.setBoardTitle(boardTitle);
		} else {
			option.setBoardTitle("");
		}
//		System.out.println();
//		option.setBoardTitle(boardTitle);
		
		// 전체 개수 조회. 페이징도 할거야~
		int totalData = new BoardService().selectBoardCount(option);
		// 조회된 개수 정보를 setTotalData에 보내줘서 calcPaging 함수 동작 -> 계산식 동작해서 필드값을 채워줌
		option.setTotalData(totalData);
		
		
		List<Board> resultList = new BoardService().selectBoardList(option);
//		System.out.println(resultList);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/board/list.jsp");
		request.setAttribute("ResultOfList", resultList);
		request.setAttribute("paging", option);
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
