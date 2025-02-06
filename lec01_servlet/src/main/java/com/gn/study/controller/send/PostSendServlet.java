package com.gn.study.controller.send;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginMember")
public class PostSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostSendServlet() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		처음부터 인코딩 작업이 필요하다
		request.setCharacterEncoding("UTF-8");
//		처음부터 인코딩 작업이 필요하다
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
//		여기는 JSP 방식
//		여기는 JSP 방식
//		여기는 JSP 방식
//		RequestDispatcher Servlet에서 JSP로 역할을 넘겨줄때 호출하는 객체?
//		응답할 JSP의 위치정보를 매개변수로 사용
		RequestDispatcher view = request.getRequestDispatcher("views/loginSuccess.jsp");
//		setAttribute JSP에 정보를 넘겨주는 역할 / 가져올때는 get
//		loginSuccess.jsp에 id, pw 보내주기
		request.setAttribute("userId", id);
		request.setAttribute("userPw", pw);
//		RequestDispatcher 에게 결과 표시해~ 라고 요청
		view.forward(request, response);
//		여기는 JSP 방식
//		여기는 JSP 방식
//		여기는 JSP 방식
		
		
		
		
//		여기는 Servlet 방식
//		여기는 Servlet 방식
//		여기는 Servlet 방식
////		1. 출력할 문서 형태 선언
//		response.setContentType("text/html; charset=UTF-8");
////		2. 터널(스트림)
//		PrintWriter out = response.getWriter();
////		3. 스트림을 통해 HTML 구문을 한줄씩 입력
//		out.println("<html lang='en'>");
//		out.println("<head>");
//		out.println("<meta charset=\"UTF-8\">");
//		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
//		out.println("<title>로그인 결과화면</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>반가워요 "+id+"님</h1>");
//		out.println("<h2>비밀번호가 "+pw+"이시네요~</h2>");
//		out.println("<a href=\"/\">홈페이지로 이동</a>");
//		out.println("</body>");
//		out.println("</html>");
////		4. 터널(스트림) 문 닫기
//		out.flush();
//		여기는 Servlet 방식
//		여기는 Servlet 방식
//		여기는 Servlet 방식

	}

}
