package com.practice.myself;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class practiceService {
	
	@Inject
	practiceDAO dao;
	
	public void test() {
		dao.testDB();
	}
	
	public String getRoom(ChatVO vo) {
		log.info(dao.getRoom(vo));
		return dao.getRoom(vo);
	}
	
	public String getRoom(Map<String, Object> hm) {
		return dao.getRoom(hm);
	}
	
	public void recordMsg(Map<String, Object> hm) {
		dao.recordMsg(hm);
	}
	
	public List getMsg(String bang_id) {
		return dao.getMsg(bang_id);
	}
}
