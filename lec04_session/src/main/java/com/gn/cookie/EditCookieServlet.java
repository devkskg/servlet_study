package com.gn.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editCookie")
public class EditCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditCookieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		쿠키 수정하는 방법은 새로운 게 있는 게 아니라. 똑같은 키값으로 새로운 정보(Value) 추가하면 된다.
		Cookie c = new Cookie("user_id", "admin");
//		setMaxAge 안하면 원래 거 따라간다. 새로 설정하면 새로 시작
		response.addCookie(c);
		response.sendRedirect("/");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
