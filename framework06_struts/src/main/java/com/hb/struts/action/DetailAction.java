package com.hb.struts.action;

import com.hb.struts.model.UserDAO;
import com.hb.struts.model.UserVo;
import com.opensymphony.xwork2.Action;

public class DetailAction implements Action {
	private int sabun;
	private UserVo bean;
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	
	public void setBean(UserVo bean) {
		this.bean = bean;
	}
	
	public UserVo getBean() {
		return bean;
	}
	
	@Override
	public String execute() throws Exception {
	
		bean = new UserDAO().selectOne(sabun);
		
		return SUCCESS;
	}
	
}
