package com.gn.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.gn.member.service.MemberService;
import com.gn.member.vo.Member;

@WebServlet(name="memberCreateEndServlet", urlPatterns = "/memberCreateEnd")
public class MemberCreateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberCreateEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("member_id");
		String pw = request.getParameter("member_pw");
//		String pw_check = request.getParameter("member_pw_check");
		String name = request.getParameter("member_name");
		
//		System.out.println("아이디 : " + id + ", 비밀번호 : " + pw + ", 닉네임 : " + name);
		
		Member mem = new Member();
		mem.setMemberId(id);
		mem.setMemberPw(pw);
		mem.setMemberName(name);
		
//		 25-02-13 어제는 그냥 submit으로 했다면 25-02-14 오늘은 ajax로 해보자
//		 25-02-13 어제는 그냥 submit으로 했다면 25-02-14 오늘은 ajax로 해보자
//		 25-02-13 어제는 그냥 submit으로 했다면 25-02-14 오늘은 ajax로 해보자
//		Service에 데이터 전달
//		int result = new MemberService().createMember(mem);
//		RequestDispatcher 를 일단 실패했다고 가정하고 성공하면 view의 방향(url)을 바꿔준다.
		// 이것들을 Ajax로 처리해보자
		
//		RequestDispatcher view = request.getRequestDispatcher("/views/member/create_fail.jsp");
//		if(result > 0) {
////			System.out.println("업데이트 완료");
//			view = request.getRequestDispatcher("/views/member/create_success.jsp");
//		}
//		view.forward(request, response);
//		 25-02-13 어제는 그냥 submit으로 했다면 25-02-14 오늘은 ajax로 해보자
//		 25-02-13 어제는 그냥 submit으로 했다면 25-02-14 오늘은 ajax로 해보자
//		 25-02-13 어제는 그냥 submit으로 했다면 25-02-14 오늘은 ajax로 해보자
		
		
//		25-02-14 ajax방식으로 해보기
		int result = new MemberService().createMember(mem);
		JSONObject obj = new JSONObject();
//		문제 상황 가정해서 작성한 부분
		obj.put("res_code", "500");
		obj.put("res_msg", "회원가입중 오류가 발생하였습니다.");
		
		if(result > 0) {
			obj.put("res_code", "200");
			obj.put("res_msg", "정상적으로 회원가입되었습니다.");
		}
		response.setContentType("application/json; charset=utf-8");
		// 터널 뚫기
		response.getWriter().print(obj);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
