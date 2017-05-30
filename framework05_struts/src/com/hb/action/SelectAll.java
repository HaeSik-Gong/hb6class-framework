package com.hb.action;

import java.util.List;
import java.util.Map;

import com.hb.model.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class SelectAll extends ActionSupport {

	private List<Map<String, Object>> list;
	
	public List<Map<String, Object>> getList() {
		return this.list;
	}
	
	@Override
	public String execute() throws Exception {
		
		UserDAO dao = new UserDAO();
		list = dao.selectAll();
		
		return this.SUCCESS;
	}
	
}
