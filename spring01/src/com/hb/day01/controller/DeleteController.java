package com.hb.day01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.day01.model.UserDAO;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		UserDAO dao = new UserDAO();
		
		String msg = null;
		String display = null;
		
		if(dao.deleteOne(Integer.parseInt(req.getParameter("sabun"))) >0) {
			msg = "success";
			display = "block";
			mav.setViewName("redirect:list.do?display="+display+"&msg="+msg);
		}
		else mav.setViewName("redirect:detail.do?sabun=" + req.getParameter("sabun"));
		return mav;
	}
	
}
