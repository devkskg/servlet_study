package com.gn.study.controller.send;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/joinMember")
public class GetSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetSendServlet() {
        super();
    }
    
//    request란 정보를 담고 있는 곳
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. text 타입
		String userName = request.getParameter("userName");
//		2. radio 타입
		String userGender = request.getParameter("userGender");
//		3. number 타입 -> vsCode 생각해보면 input type=number라도 넘어오는 정보는 문자열 이었다.
		int userAge = Integer.parseInt(request.getParameter("userAge"));
//		4. checkbox 타입
		String[] hobby = request.getParameterValues("hobby");
		
		System.out.println("이름 : " + userName);
//		System.out.println("성별 : " + userGender);
//		성별 정보가 1 -> 남성, 그 외에 여성
		if("1".equals(userGender)) {
			System.out.println("성별 : 남성");
		} else {
			System.out.println("성별 : 여성");
		}
		System.out.println("나이 : " + userAge);
//		System.out.println("취미 : " + hobby);
//		취미 정보 -> ,로 연결해서 야구, 농구, 축구
//		취미 정보 없으면 취미 : 없음
		
//		Map을 사용한 강사님 풀이
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("1", "야구");
//		map.put("2", "농구");
//		map.put("3", "축구");
		
		if(hobby == null) {
			System.out.println("취미 : 없음");
		} else {
//			List는 내 풀이
			List<String> arr = new ArrayList<String>();
			for(int i = 0; i < hobby.length; i++) {
				if("1".equals(hobby[i])) {
					arr.add("야구");
				} else if("2".equals(hobby[i])) {
					arr.add("농구");
				}  else if("3".equals(hobby[i])) {
					arr.add("축구");
				} 
			}
			String str = String.join(",", arr);
			System.out.println("취미 : " + str);
			
//			String[] arr = new String[hobby.length];
//			System.arraycopy(hobby, 0, arr, 0, hobby.length); // 깊은 복사
//			for(int i = 0; i < arr.length; i++) {
//				arr[i] = map.get(arr[i]);
//			}
//			System.out.println("취미 : " + String.join(",", arr));
		}
		
//		1. 출력할 문서 형태 선언
		response.setContentType("text/html; charset=UTF-8");
//		2. 터널(스트림)
		PrintWriter out = response.getWriter();
//		3. 스트림을 통해 HTML 구문을 한줄씩 출력
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("<title>회원가입 결과화면</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>"+userName+"님, 환영합니다</h1>");
		out.println("<h2>앞으로도 자주 와주실꺼죠?</h2>");
		out.println("<a href='/'>홈페이지로 이동</a>");
		out.println("</body>");
		out.println("</html>");
//		4. 터널(스트림) 문 닫기
		out.flush();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
