package com.gn.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import static com.gn.common.sql.SqlSessionTemplate.getSqlSession;

import com.gn.board.dao.BoardDao;
import com.gn.board.vo.Board;

public class BoardService {
	public List<Board> selectBoardList(Board option){
		// SqlSession은 커넥션과 같은 역할. 데이터베이스에 연결하는 역할
		SqlSession session = getSqlSession();
		List<Board> resultList = new BoardDao().selectBoardList(session, option);
		session.close();
		return resultList;
	}
	
//	하드코딩한 boardNo를 받아서 DB 조회 -> Board형태로 반환하는 메소드
	public Board selectBoardOne(int boardNo) {
		SqlSession session = getSqlSession();
		Board board = new BoardDao().selectBoardOne(session, boardNo);
		session.close();
		return board;
	}
	public Board selectBoardTwo(Map<String, String> param) {
		SqlSession session = getSqlSession();
		Board board = new BoardDao().selectBoardTwo(session, param);
		session.close();
		return board;
	}

	public Board selectBoardThree(Board b) {
		SqlSession session = getSqlSession();
		Board board = new BoardDao().selectBoardThree(session, b);
		session.close();
		return board;
	}

	public int updateBoard(Board board) {
		SqlSession session = getSqlSession();
		int result = new BoardDao().updateBoard(session, board);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int deleteBoard(int boardNo) {
		SqlSession session = getSqlSession();
		int result = new BoardDao().deleteBoard(session, boardNo);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int insertBoard(Board b) {
		SqlSession session = getSqlSession();
		int result = new BoardDao().insertBoard(session, b);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int insertMany(List<Board> list) {
		SqlSession session = getSqlSession();
		int result = new BoardDao().insertMany(session, list);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
}
