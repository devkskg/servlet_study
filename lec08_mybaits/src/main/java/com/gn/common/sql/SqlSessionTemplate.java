package com.gn.common.sql;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		try {
			// 1. mybatis-config.xml의 설정 정보 읽어오기
			String path = "/mybatis-config.xml";
			InputStream is = Resources.getResourceAsStream(path);
			// 2. SqlSessionFactoryBuilder 객체 생성
			SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
			// 3. SqlSessionFactory 객체 생성
			SqlSessionFactory sf = sfb.build(is);
			// 4. SqlSession 객체 생성
			// 트랜잭션 처리 하고싶으면?
			// 매개변수 -> AutoCommit 여부 지정 -> default = true
			// AutoCommit 끌때 -> false
			// -> openSession(false) 해야한다.
			session = sf.openSession();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
