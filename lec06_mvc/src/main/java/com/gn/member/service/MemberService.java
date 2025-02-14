package com.gn.member.service;

import com.gn.member.dao.MemberDao;
import com.gn.member.vo.Member;
import static com.gn.common.sql.JDBCTemplate.getConnection;
import static com.gn.common.sql.JDBCTemplate.close;

import java.sql.Connection;

public class MemberService {
	MemberDao md = new MemberDao();
//	createMember 메소드
//	Member를 매개변수로 받아서
//	Connection 객체 생성
//	MemberDao에게 Connection과 Member 전달
//	int 반환
	public int createMember(Member m) {
//		md.createMember();
		Connection conn = getConnection();
		int result = md.createMember(conn, m);
		close(conn);
		return result;
		
	}
	public Member loginMember(String id, String pw) {
		Connection conn = getConnection();
		Member m = md.loginMember(conn, id, pw);
		close(conn);
		return m;
	}
	public int updateUserInfo(String name, String pw, String no) {
		Connection conn = getConnection();
		int result = md.updateUserInfo(conn, name, pw, no);
		close(conn);
		return result;
	}
}
