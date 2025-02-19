package com.gn.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Attach;

@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileDownloadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1,2,3 까지는 FilePathServlet과 똑같음.
		// 1. 읽어올 파일명 전달 받기
		int attachNo = Integer.parseInt(request.getParameter("attach_no321"));
		Attach a = new BoardService().selectAttachOne(attachNo);
		
		// 2. 파일명이 비어있는지 확인
		String filePath = a.getAttachPath();
		if(filePath == null || filePath.trim().equals("")) {
			// 400에러 발생 -> 잘못된 요청
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		// 3. 파일 경로에 파일이 존재하는지 확인
		File file = new File(filePath);
		if(!file.exists()) {
			// 404에러 발생 -> 요청 파일 찾을 수 없는 경우
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
//		여기서부터 달라진다
//		여기서부터 달라진다
//		여기서부터 달라진다
		// 4. 파일 다운로드 응답 헤더 설정(파일 다운로드는 헤드 부분에서 관리한다.)
//		어떤 형태인지
		response.setContentType("application/octet-stream");
//		파일이 크기
		response.setContentLength((int)file.length());
		
		// 5. 파일명 설정(인코딩 방식도 확인 해줘야한다.)(ori_name으로 돌려주기)
		String encodedFileName = URLEncoder.encode(a.getOriName(), "UTF-8").replaceAll("\\+", "%20"); // 매개변수로 원래이름, "UTF-8", 역슬래시 두개 있을 수 있으니 약속된 기호 %20으로 바꾼다.
		// 머리 부분에 알려준다. 키=밸류 // 키값이 파일의 명칭을 쓰는 부분 // 파일 이름은 쌍따옴표 사이에 들어와야한다.역슬래시필요
		response.setHeader("Content-Disposition", "attachment; filename=\""+ encodedFileName +"\"");
		
		// 6. 파일 데이터를 클라이언트에게 전송(다운로드)
		try(FileInputStream fis = new FileInputStream(file); OutputStream out = response.getOutputStream();) {
			byte[] buffer = new byte[1024];
			int byteRead;
			while((byteRead = fis.read(buffer)) != -1) {
				out.write(buffer, 0, byteRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		달라졌다
//		달라졌다
//		달라졌다
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
