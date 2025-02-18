package com.gn.board.service;

import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.commit;
import static com.gn.common.sql.JDBCTemplate.getConnection;
import static com.gn.common.sql.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.gn.board.dao.BoardDao;
import com.gn.board.vo.Attach;
import com.gn.board.vo.Board;

public class BoardService {
//	BoardDao dao = new BoardDao();
	
	public int createBoard(Board b, Attach a) {
		Connection conn = getConnection();
		int result = 0;
		try {
			
			conn.setAutoCommit(false);
			
			int boardNo = new BoardDao().insertBoard(b,conn);
			a.setBoardNo(boardNo); // auto_increment 된 게시글 PK를 가져와서 넣어준 것
			int attachNo = new BoardDao().insertAttach(a, conn);
			// 판단의 기준점을 통일하기 위해 attachNo 쓴다.
			
//			작업 결과 따라 커밋,롤백
			if(boardNo != 0 && attachNo != 0) {
				// 둘 다 인서트 되고, auto_increment된 값이 잘 넘어왔다는 뜻
				result = 1;
				commit(conn);
			} else {
				// 뭐가 잘 안되면(exception 일어나지 않아도 안되는 경우 있으니깐)
				rollback(conn);
			}
			
//			conn.setAutoCommit(true); - commit 또는 rollback 작동하면 autocommit(true) 자동으로 돌아온다.
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
		}
		close(conn);
		return result;
	}

	// 검색어 입력, 미입력 둘 다 받아서 List에 담아오는 방법.
	public List<Board> selectBoardList(Board option) {
		Connection conn = getConnection();
		List<Board> resultList = new ArrayList<Board>(); 
		resultList = new BoardDao().selectBoardList(conn, option);
		close(conn);
		return resultList;
	}
	
	// 현재 option에 해당하는 개수 조회
	public int selectBoardCount(Board option) {
		Connection conn = getConnection();
		int result = new BoardDao().selectBoardCount(conn, option);
		close(conn);
		return result;
	}

	public Board selectBoardOne(int boardNo) {
		Connection conn = getConnection();
		Board board = new BoardDao().selectBoardOne(conn, boardNo);
		return board;
	}
}
