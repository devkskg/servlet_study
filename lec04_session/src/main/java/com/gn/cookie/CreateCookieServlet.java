package com.gn.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createCookie")
public class CreateCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateCookieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		a태그는 doGet으로만 온다.
		System.out.println("=== 연결 확인 ===");
//		1. 쿠키 생성
		Cookie c = new Cookie("user_id", "user01");
//		Age 정하기
		c.setMaxAge(60*60*24);
//		response에 얹어준다.
		response.addCookie(c);
//		개발자도구 - Application - Cookies에서 delete로 삭제 가능.
//		2. root 경로 이동
//		쿠키 만든다고 sendRedirect 하는 거 아니다. 그냥 결과 확인을 빠르게 하려고 하는 것이다.
		response.sendRedirect("/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
