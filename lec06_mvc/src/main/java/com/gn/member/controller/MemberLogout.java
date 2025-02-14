package com.gn.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/memberLogout")
public class MemberLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLogout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		매개변수 false로 쓰는 것 중요!
		HttpSession session = request.getSession(false);
//		조건문도 항상 잘 생각해보자. 세션이 있으면서, member라는 세션 정보가 있다면~
		if(session != null && session.getAttribute("member") != null) {
			session.removeAttribute("member");
//			세션에 회원정보 밖에 없기 때문에 그냥 invalidate를 썼다. 다른 세션이 있다면 쓰면 안될 것이다.??
			session.invalidate();
		}
//		세션 만료 후 새로고침 하는 느낌으로 메인 화면 보내버린다.
		response.sendRedirect("/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
