package com.gn.common.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class StringUpperWrapper extends HttpServletRequestWrapper {

	public StringUpperWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
//		String upName = name.toUpperCase();
		System.out.println("!!!UpperWrapper!!!");
		return super.getParameter(name).toUpperCase();
	}
	
	
}
