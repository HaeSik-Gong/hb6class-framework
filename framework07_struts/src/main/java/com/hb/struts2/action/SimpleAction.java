package com.hb.struts2.action;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.hb.struts2.model.SimpleDAO;
import com.hb.struts2.model.SimpleVo;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class SimpleAction implements ModelDriven<SimpleVo>, Preparable {
	Logger log = Logger.getLogger(this.getClass());
	private SimpleDAO dao = new SimpleDAO();
	private List<SimpleVo> list;
	private SimpleVo bean;
	private int sabun;
	private String msg;
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	
	public List<SimpleVo> getList() {
		return list;
	}

	public void setList(List<SimpleVo> list) {
		this.list = list;
	}
	
	public SimpleVo getBean() {
		return bean;
	}
	
	public void setBean(SimpleVo bean) {
		this.bean = bean;
	}
	
	public String execute() {
		return "errors";
	}
	
	public String list() {
		log.debug("list() start");
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public String add() {
		return "success";
	}
	
	public String insert() throws SQLException {
		dao.insertOne(bean);
		return "success";
	}
	
	public String delete() {
		int result = 0;
		try {
			result = dao.deleteOne(sabun);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result > 0) return "success";
		else return "input";
	}
	
	public String detail() {
		log.debug("detail() start - sabun : " + sabun);
		try {
			bean = dao.selectOne(sabun);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public String update() {
		log.debug("update() start - bean : " + bean);
		int result = 0;
		try {
			result = dao.updateOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result > 0) return "success";
		else return "input";
	}
	
	@Override
	public SimpleVo getModel() {
		return bean;
	}

	@Override
	public void prepare() throws Exception {
		bean = new SimpleVo();
	}
}
