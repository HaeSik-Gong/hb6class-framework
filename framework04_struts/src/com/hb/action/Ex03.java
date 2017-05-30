package com.hb.action;

import com.opensymphony.xwork2.ActionSupport;

public class Ex03 extends ActionSupport {

	private String msg;
	
	@Override
	public String execute() throws Exception {
		msg = "이렇게 전달합니다.";
		
		return this.SUCCESS;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return this.msg;
	}
	
}
