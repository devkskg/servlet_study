package com.gn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/receive/data")
//	1. 별명방식 @WebServlet(name="별명", urlPatterns="url"), DataFilter를 이용하기 위해 써보자.
@WebServlet(name="receiveDataServlet", urlPatterns = "/receive/data")
public class ReceiveDataServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public ReceiveDataServlet() {}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8"); // 데이터 흐름보다 위쪽이면 doGet, doPost 어디에 써도 상관 없다.
		System.out.println("=== 확인 ===");
		String testData = req.getParameter("test_data");
		System.out.println("데이터 : " + testData);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); // 데이터 흐름보다 위쪽이면 doGet, doPost 어디에 써도 상관 없다.
		doGet(req, resp);
	}
	
	

}
