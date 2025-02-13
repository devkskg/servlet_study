package com.gn.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
//		Service에 데이터 전달
		int result = new MemberService().createMember(mem);
		if(result > 0) {
			System.out.println("업데이트 완료");
		} else {
			System.out.println("실패~");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
