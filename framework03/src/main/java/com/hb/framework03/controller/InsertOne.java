package com.hb.framework03.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.framework03.model.UserDAO;
import com.hb.framework03.support.MyController;

public class InsertOne implements MyController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(!"POST".equals(req.getMethod())) {
			return "err";
		}
		req.setCharacterEncoding("UTF-8");
		UserDAO dao = new UserDAO();
		try {
			String name = req.getParameter("name");
			String nalja = req.getParameter("nalja");
			int pay = Integer.parseInt(req.getParameter("pay"));
			
			int result = dao.insertOne(name, nalja, pay);
			System.out.println("insert result : " + result);
			if(result > 0) {
				System.out.println("insert success");
				return "redirect:list.do";
			} else {
				System.out.println("insert fail");
				return "form";
			}
		} catch (Exception e) {
			System.out.println("insert exception");
			e.printStackTrace();
			return "form";
		}

	}
	
}
