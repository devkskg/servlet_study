package com.gn.homework.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/borrow")
public class BookReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookReservationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		String libName = request.getParameter("libName");
//		String libPhone = request.getParameter("libPhone");
//		String libEmail = request.getParameter("libEmail");
////		이거 value로 들어온다.
//		String bookName = request.getParameter("bookName");
//		String libDate = request.getParameter("libDate");
//		
//		
//		int overDate = Integer.parseInt(libDate) - 1;
//		int basicPrice = 0;
//		
//		if("1".equals(bookName)) {
//			bookName = "자바 프로그래밍 입문";
//			basicPrice = 1500;
//		} else if("2".equals(bookName)) {
//			bookName = "웹 개발의 기초";
//			basicPrice = 1800;
//		} else if("3".equals(bookName)) {
//			bookName = "데이터베이스 시스템";
//			basicPrice = 2000;
//		} else {
//			
//		}
//		
//		int totalPrice = basicPrice;
//		for(int i = 0; i < overDate; i++) {
//			totalPrice += 500;
//		}
//		
//		RequestDispatcher rd = request.getRequestDispatcher("/views/homework/bookConfirmation.jsp");
//		request.setAttribute("libName", libName);
//		request.setAttribute("libPhone", libPhone);
//		request.setAttribute("libEmail", libEmail);
//		request.setAttribute("bookName", bookName);
//		request.setAttribute("libDate", libDate);
//		request.setAttribute("totalPrice", totalPrice);
//		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		String libName = request.getParameter("libName");
		String libPhone = request.getParameter("libPhone");
		String libEmail = request.getParameter("libEmail");
//		이거 value로 들어온다.
		String bookName = request.getParameter("bookName");
		String libDate = request.getParameter("libDate");
		
		int overDate = -1;
		if(!libDate.equals("")) {
			overDate = Integer.parseInt(libDate) - 1;
		}
		int basicPrice = 0;
		
		if("1".equals(bookName)) {
			bookName = "자바 프로그래밍 입문";
			basicPrice = 1500;
		} else if("2".equals(bookName)) {
			bookName = "웹 개발의 기초";
			basicPrice = 1800;
		} else if("3".equals(bookName)) {
			bookName = "데이터베이스 시스템";
			basicPrice = 2000;
		} else {
			
		}
		
		int totalPrice = basicPrice;
		for(int i = 0; i < overDate; i++) {
			totalPrice += 500;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/homework/bookConfirmation.jsp");
		request.setAttribute("libName", libName);
		request.setAttribute("libPhone", libPhone);
		request.setAttribute("libEmail", libEmail);
		request.setAttribute("bookName", bookName);
		request.setAttribute("libDate", libDate);
		request.setAttribute("totalPrice", totalPrice);
		rd.forward(request, response);
		
	}

}
