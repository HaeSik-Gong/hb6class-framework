package com.hb.struts.action;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {

	private int sabun, pay;
	private String name;
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSabun() {
		return sabun;
	}
	
	@Override
	public String execute() throws Exception {
		
		return this.INPUT;
	}
	
}
