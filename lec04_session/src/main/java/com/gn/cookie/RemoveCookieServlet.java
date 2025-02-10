package com.gn.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/removeCookie")
public class RemoveCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveCookieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		유효기간 0으로 하면 대부분 쿠키 삭제됨.
//		브라우저마다 쿠키 삭제 방법이 조금 다름.
//		그래서 둘 다 때려박음 순서주의!(비어있는 문자열 넣기 -> 유효기간 0으로 하기)
		Cookie c = new Cookie("user_id","");
		c.setMaxAge(0);
		response.addCookie(c);
		response.sendRedirect("/");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
