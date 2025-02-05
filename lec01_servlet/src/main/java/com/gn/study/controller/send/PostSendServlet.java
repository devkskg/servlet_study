package com.gn.study.controller.send;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Decoder;

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
//		1. 출력할 문서 형태 선언
		response.setContentType("text/html; charset=UTF-8");
//		2. 터널(스트림)
		PrintWriter out = response.getWriter();
//		3. 스트림을 통해 HTML 구문을 한줄씩 입력
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("<title>로그인 결과화면</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>반가워요 "+id+"님</h1>");
		out.println("<h2>비밀번호가 "+pw+"이시네요~</h2>");
		out.println("<a href=\"/\">홈페이지로 이동</a>");
		out.println("</body>");
		out.println("</html>");
//		4. 터널(스트림) 문 닫기
		out.flush();
	}

}
