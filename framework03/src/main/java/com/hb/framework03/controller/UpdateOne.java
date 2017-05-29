package com.hb.framework03.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.framework03.model.UserDAO;
import com.hb.framework03.support.MyController;

public class UpdateOne implements MyController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(!"POST".equals(req.getMethod())) {
			return "err";
		}
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String nalja = req.getParameter("nalja");
		int sabun = Integer.parseInt(req.getParameter("sabun"));
		int pay = Integer.parseInt(req.getParameter("pay"));
		
		UserDAO dao = new UserDAO();
		int result = 0;
		try {
			result = dao.updateOne(sabun, name, nalja, pay);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result > 0) {
			return "redirect:edit.do?idx=" + sabun;
		} else {
			return "redirect:list.do";
		}
	}
	
}
