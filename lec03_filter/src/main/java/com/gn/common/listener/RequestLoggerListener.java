package com.gn.common.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class RequestLoggerListener implements ServletRequestListener {
	public RequestLoggerListener() {}
	
//	두번씩 찍히는 이유는 1. 서버 시작. 2. 인덱스.xml 진입할때.
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("🐧새로운 요청이 들어왔습니다!🐧");
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("🐣요청이 처리되었습니다.🐣");
	}

	
	
}
