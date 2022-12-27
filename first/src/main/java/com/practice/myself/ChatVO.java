package com.practice.myself;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ChatVO {
	private	String buyer_id;
	private	String seller_id;
	private	String bang_id;
	private	String message;
	private	int goods_no;
}
