package com.hb.action;

import com.hb.model.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class InsertOne extends ActionSupport {

	private int pay;
	private String name, nalja;
	
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
		int result = dao.insertOne(name, nalja, pay);
		
		if(result > 0) {
			return this.SUCCESS;
		} else {
			return this.ERROR;
		}
	}
	
}
