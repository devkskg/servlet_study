package com.gn.common.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MsgRequestWrapper extends HttpServletRequestWrapper {

//	상속 받을 때 매개변수 생성자가 필요한 경우가 있다. 지금 같은 경우
	public MsgRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
//		폼 요소의 데이터 속성명이 msg와 같다면 -gn- 붙이겠다.
		if(name.equals("msg")) {
			return super.getParameter(name)+"-gn-";
		} else {
			return super.getParameter(name);
		}
	}
	
	

}
