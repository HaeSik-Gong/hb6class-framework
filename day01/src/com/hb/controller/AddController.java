package com.hb.controller;

import javax.servlet.http.HttpServletRequest;

import com.hb.engine.FrontInter;

public class AddController implements FrontInter {
	
	@Override
	public String execute(HttpServletRequest req) {
		return "/add.jsp";
	}
}
