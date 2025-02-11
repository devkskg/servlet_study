package com.gn.shopping.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gn.shopping.vo.Product;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddToCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		여기서 DB 접근해서 where = value 로 Product 객체를 갖는 List를 세션으로 서버에 정보 저장하고 cart에서 보여주는 느낌으로 원하시는 걸까?
		
//		List<Product> resultList = (List<Product>) request.getAttribute("resultList");
		String cart = request.getParameter("product");
		System.out.println(cart);
//		System.out.println(resultList.size() + "비어있나요?");
		HttpSession session = request.getSession();
		if(session.isNew() || session.getAttribute("cart") == null) {
//			List<Product> resultList = new ArrayList<Product>();
//			resultList.add(new Product());
//			session.setAttribute("sessionList", resultList);
			session.setAttribute("cart", cart);
			session.setMaxInactiveInterval(60*30);
		} 
//		response.sendRedirect("/views/shopping/cart.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
