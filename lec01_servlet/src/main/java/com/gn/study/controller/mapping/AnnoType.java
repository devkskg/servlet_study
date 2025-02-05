package com.gn.study.controller.mapping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// extends HttpServlet	일반 클래스를 서블릿으로 쓸 수 있다.
@WebServlet("/mapping/anno")
public class AnnoType extends HttpServlet {
	
//	시리얼 아이디 넣기. 클래스이름 노란줄 있을 때 마우스 올리면 자동완성기능 사용
	private static final long serialVersionUID = 1L;

//	클래스의 주소값을 매핑(@@WebServlet(url)) 해서 get으로 가져올 수 있게 된다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("user_id");
		System.out.println(userId);
//		이렇게 가져와서 DB에 있는 정보인지 확인하는 절차 쓰고 그렇게 한다.
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
