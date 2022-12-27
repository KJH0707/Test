package com.practice.myself;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.extern.log4j.Log4j;

@Log4j
@Repository
public class practiceDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String mapper = "com.practice.myself.mapper";
	
	public void testDB() {
		sqlSession.insert(mapper+".test");
	}
	
	public String getRoom(ChatVO vo) {
		log.info(sqlSession.selectOne(mapper+".getRoom",vo));
		return sqlSession.selectOne(mapper+".getRoom",vo);
	}
	
	public String getRoom(Map<String, Object> hm) {
		
		return sqlSession.selectOne(mapper+".getRoom",hm);
	}
	
	public void recordMsg(Map<String, Object> hm) {
		sqlSession.insert(mapper+".recordMsg",hm);
	}
	
	public List getMsg(String bang_id) {
		return sqlSession.selectList(mapper+".getRecord",bang_id);
	}
}
