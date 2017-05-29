package com.hb.framework03.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.framework03.model.UserDAO;
import com.hb.framework03.model.UserVo;
import com.hb.framework03.support.MyController;

public class EditForm implements MyController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("title", "¼öÁ¤");
		req.setAttribute("nxtURI", "update.do");
		
		String idx = req.getParameter("idx");
		
		UserDAO dao = new UserDAO();
		try {
			UserVo vo = dao.selectOne(Integer.parseInt(idx));
			req.setAttribute("bean", vo);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		return "form";
	}
	
}
