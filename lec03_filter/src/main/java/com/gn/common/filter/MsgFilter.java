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

import com.gn.common.wrapper.MsgRequestWrapper;

//@WebFilter()
//	이번에 web.xml 사용해서 할거다.
//	web.xml을 사용 - 여기 호출 - utf-8적용 - web.xml에서 적용한 범위만큼 적용 되는듯?
public class MsgFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	public MsgFilter() {
        super();
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("[MsgFilter] 요청 가로챔");
//		ServletRequest가 HttpServletRequest의 부모 클래스라서 강제 형변환(다운캐스팅) 통해서 매개변수로 넣었음
		MsgRequestWrapper mrw = new MsgRequestWrapper((HttpServletRequest)request);
//		request 부분에 객체화 한 MsgRequestWrapper Class를 보내준다
		chain.doFilter(mrw, response);
//		chain.doFilter(request, response);
		System.out.println("[MsgFilter] 응답 가로챔");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("[MsgFilter] init() : 필터 초기화");
	}

}
