package com.gn.board.service;

import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.getConnection;
import static com.gn.common.sql.JDBCTemplate.rollback;
import static com.gn.common.sql.JDBCTemplate.commit;

import java.sql.Connection;

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
}
