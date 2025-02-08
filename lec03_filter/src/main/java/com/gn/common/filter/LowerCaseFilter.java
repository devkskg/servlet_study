package com.gn.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import com.gn.common.wrapper.StringLowerWrapper;

@WebFilter("/receive/lower")
public class LowerCaseFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		StringLowerWrapper slw = new StringLowerWrapper((HttpServletRequest)req);
		chain.doFilter(slw, res);
		
	}

	
	@Override
	public void destroy() {
	}
	

}
