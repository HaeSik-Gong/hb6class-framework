package com.hb.framework03.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.framework03.support.MyController;

public class AddForm implements MyController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("title", "ют╥б");
		req.setAttribute("nxtURI", "insert.do");
		return "form";
	}
	
}
