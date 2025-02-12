package com.gn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/changePage")
public class ChangePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangePageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		이건 내 풀이
//		response.sendRedirect("/views/countPage.jsp");
		
//		아래는 강사인 풀이
		RequestDispatcher view 
//		이거는 원래 쓰던거. / 슬래시 쓰고 써야한다.
//		= request.getRequestDispatcher("/views/countPage.jsp");
//		아래는 새로운 거. 서블릿에 들어있는 메소드. 절대 경로를 찾아줌.
//		절대 경로를 찾아줌.절대 경로를 찾아줌.절대 경로를 찾아줌.절대 경로를 찾아줌.절대 경로를 찾아줌.절대 경로를 찾아줌.
//		앞에 / 슬래시 써야하는 건 똑같지만 위에거는 슬래시 없는 경로로 가지지만 아래거는 오류가 뜬다.
		= getServletContext().getRequestDispatcher("/views/countPage2.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
