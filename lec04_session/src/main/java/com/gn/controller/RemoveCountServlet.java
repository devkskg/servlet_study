package com.gn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveCountServlet
 */
@WebServlet("/removeCountServlet")
public class RemoveCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveCountServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie c = new Cookie("visit_count","");
		c.setMaxAge(0);
		response.addCookie(c);
//		Cookie c2 = new Cookie("visit_count","1");
//		response.addCookie(c2);
		response.sendRedirect("/views/countPage.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
