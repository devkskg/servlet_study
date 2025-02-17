package com.gn.board.dao;

import static com.gn.common.sql.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	public List<Board> selectBoardList(Connection conn) {
		// 게시글 번호(board_no)
		// 게시글 제목(board_title)
		// 게시글 내용(board_content)
		// 게시글 작성자의 닉네임(member 테이블 member_name) - 방법 : vo필드확장
		// 게시글 등록일(reg_date)
		// 게시글 수정일(mod_date)
		List<Board> resultList = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select b.*, m.member_name from board b join member m on b.board_writer = m.member_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			
			while(rs.next()) {
				Board b = new Board();
				b.setBoardNo(rs.getInt("board_no"));
				b.setBoardTitle(rs.getString("board_title"));
				b.setBoardContent(rs.getString("board_content"));
				b.setBoardWriter(rs.getInt("board_writer"));
				b.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				b.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				b.setMemberName(rs.getString("member_name"));
				
				resultList.add(b);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return resultList;
	}
}
