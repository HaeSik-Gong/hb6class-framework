package com.hb.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hb.model.SampleDAO;

public class ListController {
	
	public String execute(HttpServletRequest req) {
		try {
			SampleDAO dao = new SampleDAO();
			List alist = dao.selectAll();
			req.setAttribute("alist", alist);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/list.jsp";
	}
	
}
