package com.hb.day01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.day01.model.UserDAO;

public class ListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		UserDAO dao = new UserDAO();
		req.setCharacterEncoding("UTF-8");
		
		if(req.getParameter("display")!=null) {
			mav.addObject("display", req.getParameter("display"));
			mav.addObject("msg", req.getParameter("msg"));
		} else {
			mav.addObject("display", "none");
		}
		
		mav.addObject("list", dao.selectAll());
		mav.setViewName("list");
		return mav;
	}
	
}
