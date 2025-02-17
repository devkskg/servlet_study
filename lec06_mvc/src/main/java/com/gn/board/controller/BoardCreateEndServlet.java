package com.gn.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Attach;
import com.gn.board.vo.Board;

@WebServlet("/boardCreateEnd")
public class BoardCreateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardCreateEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		파일 업로드용 jar 필요 1) commons-fileupload-1.5, 2) commons-io-2.9.0 - 두가지 파일 끼리의 호환 여부를 잘 봐야함.
//		1. 요청시 전달된 데이터를 담을 바구니
		Board b = new Board();
		Attach a = new Attach();
		
//		2. 파일 업로드할 경로 설정
		String path = "C:\\upload\\board";
		File dir = new File(path);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
//		3. 파일을 업로드할 저장 공간 정보 세팅 - 여기부터 jar가 시키는 대로 해야함.
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(dir);
//		byte - KB - MB - GB - TB
//		여기서 byte 단위로 써야함. 1024byte -> 1KB / 1024KB -> 1MB / 1MB*10
		factory.setSizeThreshold(1024*1024*10); 
		// 이거 왜 제한보다 큰 파일도 들어감? 왜 내용 출력됨? 진짜 몰루겠음
		// 임시 파일 크기 지정하는 거래
		// 즉, 업로드를 차단하는 기능이 아니라 어디에 저장할지를 결정하는 기능이야.??
		
//		4. 요청을 통해 전달된 데이터 읽어오기 - 정해진 표현법으로 해야함
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// 읽어올 때 리스트로 온다?
			// commonsFile이 가지고 있는 객체 FileItem / 매개변수는 HttpServletRequest request // 파싱해서 FileItem 제네릭으로 List에 저장
			List<FileItem> items = upload.parseRequest(request);
			for(int i = 0; i < items.size(); i++) {
				FileItem fileItem = items.get(i);
				// getFieldName, getName 잘 구분 해야함.
//				두가지 케이스로 나뉨
				if(fileItem.isFormField()) {
					// isFormField() == true → 일반 입력 필드 (<input type="text"> 같은 것)
//					(1) 파일이 아닌 폼 내부 요소
					// System.out.println(fileItem.getFieldName()); // 키값(파라미터의 키값?)을 지칭하는 것 - fileItem.getFieldName()
					switch(fileItem.getFieldName()) {
						// Filter-Wrapper로 설정한 utf-8은 request.getParameter()에만 적용이 되므로 FileItem으로 객체화 하여 사용한 getString() 메소드의 매개변수로 "utf-8"이 필요함
						case "board_title" : b.setBoardTitle(fileItem.getString("utf-8")); break;
						case "board_content" : b.setBoardContent(fileItem.getString("utf-8")); break;
						case "board_writer" : b.setBoardWriter(Integer.parseInt(fileItem.getString("utf-8"))); break;
					}
					// for문 if문 써서 vo에 담아줘야하나?
				} else {
					// isFormField() == false → 파일 업로드 필드 (<input type="file">)
//					(2) 파일 형태의 폼 요소
					// System.out.println(fileItem.getName()); // fileItem.getName()
					if(fileItem.getSize() > 0) {
						// 파일 알맹이가 있을 경우만
						String oriName = fileItem.getName();
						// 파일명 숨기기 위해 파일명 바꿀거다.
						int idx = oriName.lastIndexOf(".");
						String ext = oriName.substring(idx);
						
						String uuid = UUID.randomUUID().toString().replace("-", "");
						String newName = uuid+ext;
						
						// 경로, 파일명 - 파일명을 가진 애가 비어있는 내용으로 생성.
						File uploadFile = new File(dir, newName);
						fileItem.write(uploadFile);
						
						a.setOriName(oriName);
						a.setNewName(newName);
						// C:\\upload\\board\\새로운이름.확장자 -> 이걸 메타데이터로서 attatch 테이블에 insert 되게 만들자 
						a.setAttachPath(path + "\\" + newName);
						
					}
				}
			}
			// 1. 바구니에 데이터 들어있는지 확인
			System.out.println(b);
			System.out.println(a);
			// 2. 지정한 경로에 파일 업로드 되었는지 확인
			int result = new BoardService().createBoard(b,a);
			// dao 에 게시글 인서트 -> 게시글의 PK를 같이 넣어서 첨부파일 인서트
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
