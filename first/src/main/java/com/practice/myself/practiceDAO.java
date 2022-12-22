package com.practice.myself;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class practiceDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String mapper = "com.practice.myself.mapper";
	
	public void testDB() {
		sqlSession.insert(mapper+".test");
	}
}
