package com.gn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ReceiveLowerServlet", urlPatterns = "/receive/lower")
public class ReceiveLowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReceiveLowerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sizeLower = request.getParameter("sizeLower");
		RequestDispatcher view = request.getRequestDispatcher("/views/lowerShow.jsp");
		request.setAttribute("sizeLower", sizeLower);
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
