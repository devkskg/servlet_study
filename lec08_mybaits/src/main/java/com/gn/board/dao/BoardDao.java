package com.gn.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.gn.board.vo.Board;

public class BoardDao {
	public List<Board> selectBoardList(SqlSession session, Board option){
		// 매개변수 : mapper의 *(namespace.쿼리문의id)* / mapper이름.쿼리문이름
		return session.selectList("boardMapper.boardList", option);
	}
	
	public Board selectBoardOne(SqlSession session, int boardNo) {
		return session.selectOne("boardMapper.boardOne", boardNo);
	}
	public Board selectBoardTwo(SqlSession session, Map<String, String> param) {
		return session.selectOne("boardMapper.boardTwo", param);
	}

	public Board selectBoardThree(SqlSession session, Board b) {
		return session.selectOne("boardMapper.boardThree", b);
	}

	public int updateBoard(SqlSession session, Board board) {
		return session.update("boardMapper.boardUpdate", board);
	}

	public int deleteBoard(SqlSession session, int boardNo) {
		return session.delete("boardMapper.boardDelete", boardNo);
	}

	public int insertBoard(SqlSession session, Board b) {
		System.out.println("실행전 : " + b);
		int result = session.insert("boardMapper.boardInsert", b);
		System.out.println("실행후 : " + b);
		return result;
	}

	public int insertMany(SqlSession session, List<Board> list) {
		int result = session.insert("boardMapper.insertMany", list);
		return result;
	}
}
