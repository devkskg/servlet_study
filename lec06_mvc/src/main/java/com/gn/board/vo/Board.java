package com.gn.board.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.gn.common.vo.Paging;

// 페이징 상속 받은 것!!
public class Board extends Paging{
//	1번 바구니
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardWriter;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	private String memberName;
	
	
	
//	파일 띄우는 거 수업 중
//	newName 말고 attchNO로 하는 방법이다!
//	private String newName;
	private int attachNo;
	
	public int getAttachNo() {
		return attachNo;
	}
	public void setAttachNo(int attachNo) {
		this.attachNo = attachNo;
	}
	//	public String getNewName() {
//		return newName;
//	}
//	public void setNewName(String newName) {
//		this.newName = newName;
//	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Board() {
		super();
	}
	public Board(int boardNo, String boardTitle, String boardContent, int boardWriter, LocalDateTime regDate,
			LocalDateTime modDate) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(int boardWriter) {
		this.boardWriter = boardWriter;
	}

	
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	
	
//	public String getRegDate() {
//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH:mm:SS");
//	return dtf.format(regDate);
//}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	
	
	
	public LocalDateTime getModDate() {
		return modDate;
	}
	public void setModDate(LocalDateTime modDate) {
		this.modDate = modDate;
	}
	@Override
	public String toString() {
		return "[게시글 번호=" + boardNo + ", 제목=" + boardTitle + ", 내용=" + boardContent
				+ ", 닉네임=" + memberName + ", 등록일=" + regDate + ", 수정일=" + modDate + "]";
	}
	
	
}
