package com.hb.action;

import com.hb.model.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateOne extends ActionSupport {

	private int sabun, pay;
	private String name, nalja;
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNalja(String nalja) {
		this.nalja = nalja;
	}

	@Override
	public String execute() throws Exception {
		UserDAO dao = new UserDAO();
		int result = dao.updateOne(sabun, name, nalja, pay);
		
		if(result > 0) return this.SUCCESS;
		else return this.ERROR;
	}
 	
}
