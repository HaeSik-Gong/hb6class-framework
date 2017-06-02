package com.hb.day01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.day01.model.UserDAO;
import com.hb.day01.model.UserVo;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		if(req.getMethod().equals("POST")) {
			req.setCharacterEncoding("UTF-8");
			UserDAO dao = new UserDAO();
			UserVo bean = new UserVo(Integer.parseInt(req.getParameter("sabun")),
									req.getParameter("name"),
									null,
									Integer.parseInt(req.getParameter("pay")));
			if(dao.updateOne(bean) > 0) mav.setViewName("redirect:detail.do?sabun=" + req.getParameter("sabun"));
			else mav.setViewName("redirect:edit.do?sabun=" + req.getParameter("sabun"));
		} else {
			mav.setViewName("redirect:edit.do?sabun=" + req.getParameter("sabun"));
		}		
		return mav;
	}
	
}
