package com.practice.myself;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.log4j.Log4j;


@Log4j
@Component
public class ChattingHandler extends TextWebSocketHandler{
	
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		sessionList.add(session);
		log.info(session);
		
		String id = (String)session.getAttributes().get("id");
		
		for (WebSocketSession s : sessionList) {
			s.sendMessage(new TextMessage(id+"님이 입장하셨습니다."));
		}
		
		
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		log.info("#ChattingHandler, handleMessage");
		log.info(message.getPayload().toString());
		String id = (String)session.getAttributes().get("id");
		
		for(WebSocketSession s : sessionList) {
			s.sendMessage(new TextMessage(id+" : "+message.getPayload().toString()));
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		
		String id = (String)session.getAttributes().get("id");
		
		for (WebSocketSession s : sessionList) {
			if (!(id.equals(s.getAttributes().get("id")))) {
				s.sendMessage(new TextMessage(id+"님이 퇴장하셨습니다."));
			}
		}
		
		
		sessionList.remove(session);
		
		log.info(id+" 퇴장");
	}

	

	
	
}
