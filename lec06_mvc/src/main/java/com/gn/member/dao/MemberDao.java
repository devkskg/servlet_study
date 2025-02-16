package com.gn.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.gn.common.sql.JDBCTemplate.close;

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
			close(pstmt);
		}
		return result;
	}

	public Member loginMember(Connection conn, String id, String pw) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
//		Member m = new Member();
		try {
			String sql = "select * from member where (member_id = ?) and (member_pw = ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				m = new Member(rs.getInt("member_no"), rs.getString("member_id"), rs.getString("member_pw"), rs.getString("member_name"));
//				m.setMemberNo(rs.getInt("member_no"));
//				m.setMemberId(rs.getString("member_id"));
//				m.setMemberPw(rs.getString("member_pw"));
//				m.setMemberName(rs.getString("member_name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}

	public int updateUserInfo(Connection conn, String name, String pw, String no) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "update member set member_name = ?, member_pw = ? where member_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pw);
			pstmt.setString(3, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public Member fixMemberInfoByNo(Connection conn, String no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		
		try {
			String sql = "select * from member where member_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				m = new Member(rs.getInt("member_no"), rs.getString("member_id"), rs.getString("member_pw"), rs.getString("member_name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return m;
	}
}
