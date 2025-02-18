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
		
		// 바구니 하나 만들어서 검색 타이틀 담자.
		Board option = new Board();
		option.setBoardTitle(boardTitle);
		
		
		List<Board> resultList = new BoardService().selectBoardList(option);
//		System.out.println(resultList);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/board/list.jsp");
		request.setAttribute("ResultOfList", resultList);
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
