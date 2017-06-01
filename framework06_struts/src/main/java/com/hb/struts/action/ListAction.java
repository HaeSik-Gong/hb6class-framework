package com.hb.struts.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.hb.struts.model.UserDAO;
import com.hb.struts.model.UserVo;
import com.opensymphony.xwork2.Action;

public class ListAction implements Action {
	Logger log = Logger.getLogger(this.getClass());
	private List<UserVo> list;
	
	public List<UserVo> getList() {
		return list;
	}
	
	@Override
	public String execute() throws Exception {
		log.debug("¸®½ºÆ® Action Start");
		UserDAO dao = new UserDAO();
		list = dao.selectAll();
		
		return SUCCESS;
	}
	
}
