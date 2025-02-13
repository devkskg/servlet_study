package com.gn.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gn.member.vo.Member;

public class MemberDao {
//	createMember 메소드
//	매개변수로 Connection, Member 받아서
//	DB에 INSERT(member_id, member_pw, member_name)
//	ResultSet(X), executeUpdate(O)
//	결과를 int로 반환
	public int createMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "insert into member(member_id, member_pw, member_name) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, m.getMemberId());
			pstmt.setNString(2, m.getMemberPw());
			pstmt.setNString(3, m.getMemberName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				try {
					if(pstmt != null) pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}
}
