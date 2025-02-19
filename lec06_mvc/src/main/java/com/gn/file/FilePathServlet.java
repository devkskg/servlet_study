package com.gn.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Attach;

@WebServlet("/filePath")
public class FilePathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FilePathServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 읽어올 파일명 전달받기 - 정석 방법은 attach_no 보내는 것이다.
//		detail.jsp에서 쓰기로 한 키값 // <img src="<%=request.getContextPath()%>/filePath?new_name=<%=board.getNewName()%>">
		int attachNo = Integer.parseInt(request.getParameter("attach_no123"));
		System.out.println("attachNo : " +attachNo);
		Attach a = new BoardService().selectAttachOne(attachNo);
		
		// 2. 파일명이 비어있는지 확인
		String filePath = a.getAttachPath();
//		문자열 검사할때는 trim을 한 후에 비어있는 값과 비교!
		if(filePath == null || filePath.trim().equals("")) {
//			400(잘못된 요청(클라이언트의 유효하지않은 요청)) 오류 발생 시키자 + 중단 시켜버리기
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		// 3. 파일 경로에 파일이 존재하는지 확인
//		메타 데이터를 가져와서 실제 파일을 읽으려고 하는 중이다. 메타 데이터는 있는 데 실제 파일이 없는 경우가 있을 수 있으니 확인 필요
		File file = new File(filePath);
		if(!file.exists()) {
//			404 오류 발생 시키자(요청한 파일을 찾을 수 없을 경우) 발생
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		// 4. MIME 타입 감지(우선 모든 형태의 파일이 가능하도록 작업 해보자)
		String mimeType = getServletContext().getMimeType(filePath);
		if(mimeType == null) {
			mimeType = "application/octet-stream"; // 모든 타입을 읽어올 수 있는 밈 타입이다.
		}
		response.setContentType(mimeType);
		
		// 5. 파일을 읽어서(In), 클라이언트 전송(Out) / 업로드에 있는 파일을 자바로 끌고와서 클라이언트 쪽으로 전송
		// 왜 FileOutputStream 안쓰는 가? -> response가 getOutputStream 밖에 없어서.. 부모 클래스인 OutputStream 쓰는 것이다..
		try(FileInputStream fis = new FileInputStream(file); OutputStream out = response.getOutputStream();) {
			byte[] buffer = new byte[1024]; // 1kb씩 가지고 올거다. 바가지!
			int byteRead;
			// -1이 아니면 계속 읽고 -1이면(다 읽어서 더 읽어올 게 없으면) 중단.
			while((byteRead = fis.read(buffer)) != -1) {
				// byteRead가 품고 있는 애를 output 해준다는 느낌?
				out.write(buffer, 0, byteRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
