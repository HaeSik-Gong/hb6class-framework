package com.hb.day01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.day01.model.UserDAO;

public class DetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		UserDAO dao = new UserDAO();
		int sabun = Integer.parseInt(req.getParameter("sabun"));
		mav.addObject("bean", dao.selectOne(sabun));
		
		String path = req.getRequestURI();
		path = path.replace(req.getContextPath(), "");
		
		if(path.equals("/detail.do")) mav.setViewName("detail");
		else if(path.equals("/edit.do")) mav.setViewName("edit");
		
		return mav;
	}
	
}

