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
		String boardTitle = request.getParameter("board_title");
		String boardContent = request.getParameter("board_content");
		String memberName = request.getParameter("member_name");
		
		String orderType = request.getParameter("order_type");
		// Lombok이 가지고 있는 기능! Builder
		Board option = Board.builder()
				.boardTitle(boardTitle)
				.boardContent(boardContent)
				.memberName(memberName)
				.orderType(orderType)
				.build();
		
		
		
		
		List<Board> resultList = new BoardService().selectBoardList(option);
		System.out.println(resultList);
//		System.out.println(resultList);
		// 이제 위같은 구식 안 쓴다.
		
		// SqlSessionTemplate 참고
		// jdbc를 쉽게 쓰도록 *도와주는* FrameWork
		// MyBatis 공장 가동 준비 해보자. 원자재(jar)필요!
		// src/main/resources 소스폴더 생성!
		// SqlSessionTemplate 참고
		request.setAttribute("resultList", resultList);
		RequestDispatcher view = request.getRequestDispatcher("/views/board/list.jsp");
		view.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
