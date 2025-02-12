package com.gn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/accountList")
public class AccountListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccountListServlet() {
        super();
    }

//	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 여기서는 JSON 방식의 데이터를 보내주면 된다.
		JSONObject o1 = new JSONObject();
		// DB에서 데이터 가져오는 것을 아래 코드로 대체
		o1.put("no", 1);
		o1.put("name", "관리자");
		// "{"no" : 1, "name" : 관리자}" 이런 모양이 된다.
		
//		배열 추가하기
//		배열 추가하기
//		배열 추가하기
		JSONObject o2 = new JSONObject();
		// put!
		o2.put("no", 2);
		o2.put("name", "철수킴");
		
		JSONArray arr = new JSONArray();
		// add!
		arr.add(o1);
		arr.add(o2);
		
		// 제이슨 전체를 ""? {}?로 묶어주기 위함?
		JSONObject obj = new JSONObject();
		obj.put("accountList", arr);
		// "{"accountList" : [{"no" : 1, "name" : 관리자},{"no" : 2, "name" : 철수킴}]}" 이런 모양이 된다.
//		배열 추가하기
//		배열 추가하기
//		배열 추가하기
		
		// response 해주기, 기존 쓰던거랑 앞쪽 다른다. 조심
		response.setContentType("application/json; charset=utf-8");
//		원래 우리 append 많이 썼는데 JSON은 print 쓴다
//		JSON과 print는 짝꿍
//		response.getWriter().append();
		
		//response.getWriter().print(o1);
		response.getWriter().print(obj);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
