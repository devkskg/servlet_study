package com.gn.board.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Lombok 쓰는 법!
// 이거할때 window-showview-outline 꼭 확인해봐야댐!!!
// 이거할때 outline 꼭 확인해봐야댐!!!
// 이거할때 outline 꼭 확인해봐야댐!!!
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
// Builder = 매개변수 생성자를 입맛대로 조정 가능하다.
// toString 내용 바꾸고싶을때는 어케함?
// 이거할때 outline 꼭 확인해봐야댐!!!
// 이거할때 outline 꼭 확인해봐야댐!!!
// 이거할때 window-showview-outline 꼭 확인해봐야댐!!!

public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardWriter;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	private String memberName;
	private String orderType;
	
	
	

//	@Override
//	public String toString() {
//		return "[번호=" + boardNo + ", 제목=" + boardTitle 
//				+ ", 내용=" + boardContent
//				+ ", 작성자=" + boardWriter 
//				+ ", 등록일=" + regDate + ", 수정일=" + modDate + "]";
//	}
}
