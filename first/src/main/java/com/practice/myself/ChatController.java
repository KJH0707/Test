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
	public void chat(Model model) {
		String bang_id = service.getRoom();
		
		if (bang_id==null) {
            for (int i = 0; i < 15; i++) {
                char upperCh = (char)((int)(Math.random()*25) + 97);
                bang_id += upperCh;
            }
		}
		model.addAttribute("bang_id",bang_id);
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
