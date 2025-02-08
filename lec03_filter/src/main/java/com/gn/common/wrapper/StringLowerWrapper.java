package com.gn.common.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class StringLowerWrapper extends HttpServletRequestWrapper {

	public StringLowerWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getParameter(String name) {
		
		return super.getParameter(name).toLowerCase();
	}
	
	

}
