package com.practice.myself;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class practiceService {
	
	@Inject
	practiceDAO dao;
	
	public void test() {
		dao.testDB();
	}
}
