package com.gn.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

//	어노테이션 방식 두가지
//	1. 별명방식 WebFilter(servletNames = "receiveDataServlet"), DataFilter를 이용하기 위해 Servlet에서 작성한 이름 가져와서 쓴다.
//@WebFilter(servletNames = "receiveDataServlet")
//	2. url 방식
@WebFilter("/receive/data")

//	두가지 방식의 차이
//	url을 정규식(패턴) 처럼 사용하는 경우가 많아서???? (별명 방식을 많이 쓰나? url 방식을 많이 쓰나?)
//	하위 경로 포함하는 방법
//	1) /* 은 전부!
//@WebFilter("/*")
//	2) /receive/* < receive의 바로 하위만
//@WebFilter("/receive/*")
//	3) /receive/** < receive의 하위 전부
//	근데 이거는 어노테이션방식에서 지원 안 한다던데?

public class DataFilter extends HttpFilter implements Filter {

//	시리얼
	private static final long serialVersionUID = 1L;
	
//	보기 좋게 작업 순서대로 정렬해보자. 메소드는 순서 섞여도 문제 안됨.
//	1. 기본 생성자
	public DataFilter() {
		System.out.println("[DataFilter] 기본 생성자 생성됨");
	}

//	2. init()
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("[DataFilter] init() : 필터 초기화");
	}

//	3. doFilter() 요청/응답 가로챈다. || 제일 중요! init과 destroy 없어도 기능 자체는 doFilter에서 하기 떄문에 중요한 부분이다!
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
//		요청을 가로채는 코드
		System.out.println("[DataFilter] 요청 가로챔");
		
//		이걸 기준으로 위(요청 가로챔), 아래(응답 가로챔)에 작성 한다.
//		이거 호출 안하면 서블릿으로 요청이 들어가지 않는다.
//		요청 필터링 한 것을 서블릿으로 보내주는 역할??
		chain.doFilter(req, res);
		
//		응답을 가로채는 코드
		System.out.println("[DataFilter] 응답 가로챔");
	}
	
//	destroy() 필터 종료(죽이기)
	@Override
	public void destroy() {
//		얘는 리스타트 눌러보면 아주 잠깐 확인 가능함
		System.out.println("[DataFilter] 필터 종료");
	}
	


	
	
	

}
