package com.gn.board.dao;

import static com.gn.common.sql.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.gn.board.vo.Attach;
import com.gn.board.vo.Board;

public class BoardDao {
	
	public int insertBoard(Board b, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int boardNo = 0;
		try {
			String sql = "insert into `board`(board_title, board_content, board_writer) values(?,?,?)";
			// 부모(Statement)가 가진 static한 필드값을 쓴다.
//			(1) 매개 변수 추가
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setInt(3, b.getBoardWriter());
			
			boardNo = pstmt.executeUpdate();
			
//			(2) 생성된 키 반환
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
//				boardNo = rs.getInt("board_no");
				boardNo = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardNo;
	}
	
	public int insertAttach(Attach a, Connection conn) {
		// 1. board_no
		// 2. ori_name
		// 3. new_name
		// 4. attch_path
		// 5. attach_no 반환
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int attachNo = 0;
		try {
			String sql = "insert into `attach`(board_no, ori_name, new_name, attach_path) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, a.getBoardNo());
			pstmt.setString(2, a.getOriName());
			pstmt.setString(3, a.getNewName());
			pstmt.setString(4, a.getAttachPath());
			attachNo = pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				attachNo = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return attachNo;
	}
}
