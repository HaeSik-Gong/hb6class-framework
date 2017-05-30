package com.hb.action;

import com.opensymphony.xwork2.ActionSupport;

public class Ex04 extends ActionSupport {

	private String msg2;
	
	@Override
	public String execute() throws Exception {
		System.out.println(msg2);
		return this.SUCCESS;
	}

	public void setMsg(String msg2) {
		this.msg2 = msg2;
	}

	public String getMsg() {
		return this.msg2;
	}
	
}
