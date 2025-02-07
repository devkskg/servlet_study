package com.gn.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//	상속받는 리스너에 따라서 어떤 상황에서 할지 결정 되므로 어노테이션에 url이나 이름 안 쓴다.
//@WebListener
//	web.xml 방식으로 적용했음.
public class AppListener implements ServletContextListener {
//	두번씩 찍히는 이유는 1. 서버 시작. 2. 인덱스.xml 진입할때.
	
//	1. 기본 생성자
	public AppListener() {}

//	웹 애플리케이션 시작 시점
	@Override
	public void contextInitialized(ServletContextEvent sce) {
//		ServletContextListener.super.contextInitialized(sce);
		System.out.println("=== 웹 애플리케이션 시작 ===");
//		데이터베이스 연결 로직, 프로그램 시작화면 등을 넣는다.
	}
	
//	웹 애플리케이션 종료 시점
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
//		ServletContextListener.super.contextDestroyed(sce);
		System.out.println("=== 웹 애플리케이션 종료 ===");
	}
	
}
