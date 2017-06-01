package com.hb.struts.action;

import com.hb.struts.model.UserVo;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction2 extends ActionSupport {

	private UserVo bean = new UserVo();
	
	public UserVo getBean() {
		return bean;
	}
	
	public void setBean(UserVo bean) {
		this.bean = bean;
	}
	
	@Override
	public void validate() {
		if(bean.getSabun()==0) addFieldError("sabun", "��� �Է�");
		if("".equals(bean.getName())) addFieldError("name", "�̸� �Է�");
		if(bean.getPay()==0) addFieldError("pay", "�ݾ� �Է�");
	}
	
	@Override
	public String execute() throws Exception {
		
		System.out.println("name : " +bean.getName());
		this.addFieldError("name", "�̸� �Է�");
		return super.execute();
	}
	
}
