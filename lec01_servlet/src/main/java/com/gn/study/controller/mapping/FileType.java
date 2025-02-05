package com.gn.study.controller.mapping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	서블릿으로 탈바꿈 하는 방법 -> 상속 받자
public class FileType extends HttpServlet {

//	시리얼 아이디 넣기. 클래스이름 노란줄 있을 때 마우스 올리면 자동완성기능 사용
	private static final long serialVersionUID = 1L;

//	get 방식으로 받는 것
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("요청 전달 확인");
//		file.html -> 이름을 받아오기 위해 이렇게 쓴다
		String userName = req.getParameter("user_name");
		System.out.println(userName);
	}

//	post 방식으로 받는 것
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
	
}
