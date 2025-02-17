package com.gn.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boardCreate")
public class BoardCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardCreateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		SPA : Single Page Application - 인덱스 페이지 코드만 있고 나머지는 가운데 섹션을 두고 가운데만 바꾸는 느낌(HTML 코드만 계속 갈아끼는 느낌)
//		이거 매우 어렵다. 동기/비동기 방식의 이점을 모두 잃게 된다. / ajax를 쓴다고 SPA가 아니다.
//		MPA : Multiple Page Application - 우리가 계속 했던 동기/비동기 방식
		RequestDispatcher view = request.getRequestDispatcher("/views/board/create.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
