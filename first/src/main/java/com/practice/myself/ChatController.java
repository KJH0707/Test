package com.practice.myself;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ChatController {
	
	@Inject
	practiceService service;
	
	@GetMapping("/chat")
	public void chat() {
		
	}
	
	@GetMapping("/login")
	public void login() {
	}
	
	@GetMapping("/main")
	public void main() {
	}
	
	@PostMapping("/login")
	public String loginPOST(MemberVO vo, HttpSession session) {
		
		session.setAttribute("id", vo.getId());
		
		return "redirect:main";
	}
	
	@GetMapping("/test")
	public void test() {
		service.test();
	}
}
