package com.gn.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Board;

@WebServlet("/boardCreate")
public class BoardCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardCreateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardTitle = request.getParameter("board_title");
		String boardContent = request.getParameter("board_content");
		String temp = request.getParameter("board_writer");
		int boardWriter = 0;
		if(temp != null) boardWriter = Integer.parseInt(temp);
		Board b = new Board();
		b.setBoardTitle(boardTitle);
		b.setBoardContent(boardContent);
		b.setBoardWriter(boardWriter);
		System.out.println(b);
		
		
		int result = new BoardService().insertBoard(b);
		
		if(result > 0) {
			System.out.println("등록 성공~");
		} else {
			System.out.println("등록 실패!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
