package com.hb.action;

import com.opensymphony.xwork2.ActionSupport;

public class Ex03 extends ActionSupport {

	private String msg;
	
	@Override
	public String execute() throws Exception {
		msg = "�̷��� �����մϴ�.";
		
		return this.SUCCESS;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return this.msg;
	}
	
}
