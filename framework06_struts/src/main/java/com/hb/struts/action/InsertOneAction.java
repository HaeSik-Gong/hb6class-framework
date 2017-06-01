package com.hb.struts.action;

import com.hb.struts.model.UserDAO;
import com.hb.struts.model.UserVo;
import com.opensymphony.xwork2.Action;

public class InsertOneAction implements Action {

//	private int sabun, pay;
//	private String name;
//	
//	public void setSabun(int sabun) {
//		this.sabun = sabun;
//	}
//
//	public void setPay(int pay) {
//		this.pay = pay;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	UserVo bean = new UserVo();
	
	public UserVo getBean() {
		return bean;
	}

	public void setBean(UserVo bean) {
		this.bean = bean;
	}

	@Override
	public String execute() throws Exception {
		UserDAO dao = new UserDAO();
//		int result = dao.insertOne(sabun, name, pay);
		int result = dao.insertOne(bean);
		
		if(result > 0) return SUCCESS;
		else return INPUT;
	}
	
}
