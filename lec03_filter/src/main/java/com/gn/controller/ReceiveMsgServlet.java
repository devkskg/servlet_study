package com.gn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/receive/msg")
@WebServlet(name="receiveMsgServlet", urlPatterns="/receive/msg")
public class ReceiveMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReceiveMsgServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== 확인 ===");
//		Filter에서 납치되고 온 다음에 온 것이기 때문에 이미 toUpperCase()가 적용되어있다.
		String msg = request.getParameter("msg");
		System.out.println("msg입니다 : " + msg);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/msgShow.jsp");
		request.setAttribute("msg", msg);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
