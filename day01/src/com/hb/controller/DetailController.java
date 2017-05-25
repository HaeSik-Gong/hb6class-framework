package com.hb.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hb.model.SampleDAO;

public class DetailController {

	public String execute(HttpServletRequest req) {
		try {
			SampleDAO dao = new SampleDAO();
			Map<String, Object> map = dao.selectOne(Integer.parseInt(req.getParameter("idx")));
			req.setAttribute("bean", map);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return "/detail.jsp";
	}
	
}
