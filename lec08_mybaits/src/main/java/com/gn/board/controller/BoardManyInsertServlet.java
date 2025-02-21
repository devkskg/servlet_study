package com.gn.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Board;

@WebServlet("/boardManyInsert")
public class BoardManyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardManyInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Board> list = new ArrayList<Board>();
		list.add(Board.builder().boardTitle("a").boardContent("b").boardWriter(5).build());
		list.add(Board.builder().boardTitle("가").boardContent("남").boardWriter(5).build());
		list.add(Board.builder().boardTitle("다").boardContent("람").boardWriter(5).build());
		
		int result = new BoardService().insertMany(list);
		if(result > 0) {
			System.out.println("많이 넘기기 성공");
		} else {
			System.out.println("많이 넘기기 실패");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
