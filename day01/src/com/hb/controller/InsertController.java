package com.hb.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.hb.engine.FrontInter;
import com.hb.model.SampleDAO;

public class InsertController implements FrontInter {

	@Override
	public String execute(HttpServletRequest req) {
		try {
			SampleDAO dao = new SampleDAO();
			int sabun = Integer.parseInt(req.getParameter("sabun"));
			String name = req.getParameter("name");
			int pay = Integer.parseInt(req.getParameter("pay"));
			dao.insertOne(sabun, name, pay);
			dao.closeAll();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "list.do";
	}

}
