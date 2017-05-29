package com.hb.framework03.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.framework03.model.UserDAO;
import com.hb.framework03.support.MyController;


public class SelectAll implements MyController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		try {
			List list = dao.selectAll();
			req.setAttribute("alist", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "list";
	}
	
}
