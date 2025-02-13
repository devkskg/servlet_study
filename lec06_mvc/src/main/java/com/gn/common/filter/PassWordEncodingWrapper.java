package com.gn.common.filter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class PassWordEncodingWrapper extends HttpServletRequestWrapper {

	public PassWordEncodingWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		// ??member_pw_check 도 같이 wrapper 해버리기 위해 equals 말고 contains 쓴 거다.??
		if(name.contains("member_pw")) {
			String ori = super.getParameter(name);
			System.out.println("암호화 전 : " + ori);
			String enc = getSHA512(ori);
			System.out.println("암호화 후 : " + enc);
			return enc;
		}
		return super.getParameter(name);
	}

//	단방향 암호화 메소드
	private String getSHA512(String str) {
//		1. 암호화 처리 클래스 선언, 밖에서도 쓰려고 null로 할당
		MessageDigest md = null;
		try {
//			2. 적용할 알고리즘 선택해서 인스턴스화
//			SHA-512 알고리즘을 사용하여 단방향 암호화를 할거다~ 라고 선언.
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
//		3. String을 byte[]로 자름
//		md의 update 메소드의 매개변수가 byte[] 배열 형태로 필요함.
		byte[] strByte = str.getBytes();
//		4. 자른 데이터를 암호화 처리
//		md의 update메소드는 암호화 하는 것
		md.update(strByte);
//		5. 암호화 처리된 값을 byte[]로 가져온다.
//		md의 digest메소드는 암호화 한 결과를 byte[] 배열로 받아오는 것
		byte[] encryptByte = md.digest();
//		6. Base64의 인코더로 byte[]을 String으로 변환 후 반환
		return Base64.getEncoder().encodeToString(encryptByte);
	}
	
}
