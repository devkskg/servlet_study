package com.gn.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import static com.gn.common.sql.SqlSessionTemplate.getSqlSession;

import com.gn.board.dao.BoardDao;
import com.gn.board.vo.Board;

public class BoardService {
	public List<Board> selectBoardList(){
		// SqlSession은 커넥션과 같은 역할. 데이터베이스에 연결하는 역할
		SqlSession session = getSqlSession();
		List<Board> resultList = new BoardDao().selectBoardList(session);
		session.close();
		return resultList;
	}
}
