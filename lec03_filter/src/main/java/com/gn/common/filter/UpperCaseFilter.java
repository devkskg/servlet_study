package com.gn.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import com.gn.common.wrapper.StringUpperWrapper;

//@WebFilter("/UpperCaseFilter") web.xml 방식으로 /* 전부 해줄거라서 주석처리
public class UpperCaseFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	public UpperCaseFilter() {
        super();
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		String allUnit = request.getParameter("allUnit");
		System.out.println("[Uper] 요청 가로채기");
		StringUpperWrapper suw = new StringUpperWrapper((HttpServletRequest)request);
		chain.doFilter(suw, response);
		System.out.println("[Uper] 응답 가로채기");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
