package com.hb.action;

import java.util.Map;

import com.hb.model.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class EditForm extends ActionSupport {

	private Map<String, Object> bean;
	private int sabun;
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	
	public Map<String, Object> getBean() {
		return bean;
	}
	
	@Override
	public String execute() throws Exception {
		UserDAO dao = new UserDAO();
		bean = dao.selectOne(sabun);
		
		return this.SUCCESS;
	}
	
}
