package com.gn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsAjaxGet")
public class JavaScriptAjaxGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JavaScriptAjaxGetServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userusernamename");
		// 여기서 부터는 기존과 좀 다르다
		// 1. 응답할 문서 형태 선언
		response.setContentType("text/html; charset=utf-8");
		// 2. 연결통로 생성 후 문구 추가
		response.getWriter().append("<h2>"+userName+"님이 만든 첫번째 ajax응답</h2>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
