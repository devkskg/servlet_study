package com.gn.account.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gn.account.vo.Account;

@WebServlet("/loginEnd")
public class LoginEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountId = request.getParameter("account_id");
		String accountPw = request.getParameter("account_pw");
		String rememberId = request.getParameter("remember_id");
		System.out.println("아이디 : " + accountId + "\n비밀번호 : " + accountPw + "\n아이디 저장 유무 : " + rememberId);
//		크게는 두가지 할거다.
//		1. 아이디, 비밀번호 일치하는 데이터 있는지 확인 // 수업중이니 service, dao 안 나누고 그냥 하자.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account account = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/login_project";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "select * from account where (account_id = ?) and (account_pw = ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountId);
			pstmt.setString(2, accountPw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				account = new Account();
				account.setAccountNo(rs.getInt("account_no"));
				account.setAccountId(rs.getString("account_id"));
				account.setAccountPw(rs.getString("account_pw"));
				account.setAccountName(rs.getString("account_name"));
			}
//			select
//			기준 아이디와 비밀번호 일치(Like X)
//			전체 정보 조회 -> account 객체에 담기
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(account != null) {
//		2-1. 있으면O
//				-> 사용자의 정보(번호, 아이디, 비밀번호, 이름) 담고 있는 객체 Session에 저장
			HttpSession session = request.getSession();
			if(session.isNew() || session.getAttribute("account") == null) {
				session.setAttribute("account", account);
				session.setMaxInactiveInterval(5);
			}
//				-> 아이디 정보 저장 O : Cookie에 아이디 저장
			if(rememberId != null) {
//				account에서 정보를 뽑는 이유 = 검증이 된, 검증이 끝난 데이터를 쓰는 것이다.
				Cookie cookie = new Cookie("remember_id", account.getAccountId());
				cookie.setMaxAge(60*60*24*7);
				response.addCookie(cookie);
			} else {
//				사용자가 어느날 체크박스를 해제하고 이용하는 경우.
				Cookie cookie = new Cookie("remember_id", "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
//				->              X : 저장X
//				-> 홈 화면 이동 : 로그인한 사용자 정보 노출
			response.sendRedirect("/");
//			System.out.println(account);
		} else {
//		2-2. 없으면X
//				-> 로그인 페이지 다시 요청
//			System.out.println("로그인 실패");
			response.sendRedirect("/login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // utf 소문자로 써도 됨?
		doGet(request, response);
	}

}
