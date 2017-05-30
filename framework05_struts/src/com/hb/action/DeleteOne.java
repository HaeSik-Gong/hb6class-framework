package com.hb.action;

import com.hb.model.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteOne extends ActionSupport {

	private int sabun;
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	@Override
	public String execute() throws Exception {
		UserDAO dao = new UserDAO();
		int result = dao.deleteOne(sabun);
		
		if(result > 0) return this.SUCCESS;
		else return this.ERROR;
	}
	
}
