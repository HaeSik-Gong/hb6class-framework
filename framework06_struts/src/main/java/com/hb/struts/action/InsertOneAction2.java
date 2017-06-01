package com.hb.struts.action;

import org.apache.log4j.Logger;

import com.hb.struts.model.UserDAO;
import com.hb.struts.model.UserVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class InsertOneAction2 implements Action, ModelDriven, Preparable {
	Logger log = Logger.getLogger(this.getClass());
	UserVo bean;
	
	@Override
	public void prepare() throws Exception {
		bean = new UserVo();
	}
	
	@Override
	public Object getModel() {
		return bean;
	}

	@Override
	public String execute() throws Exception {
		UserDAO dao = new UserDAO();
//		int result = dao.insertOne(sabun, name, pay);
		int result = dao.insertOne(bean);
		
		log.debug(result);
		
		if(result > 0) return SUCCESS;
		else return INPUT;
	}
	
}
