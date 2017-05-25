package com.hb.engine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.controller.AddController;
import com.hb.controller.DetailController;
import com.hb.controller.InsertController;
import com.hb.controller.ListController;

public class FrontController extends HttpServlet {

	protected void doDo(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String url = "/";
		String path = req.getRequestURI();
		
		FrontInter conn = null;
		if(path.equals("/day01/list.do")) conn = new ListController();
		else if(path.equals("/day01/detail.do")) conn = new DetailController();
		else if(path.equals("/day01/add.do")) conn = new AddController();
		else if(path.equals("/day01/insert.do")) conn = new InsertController();
		
		if(conn != null) url = conn.execute(req);
		else url = "/index.jsp";
		
		req.getRequestDispatcher(url).forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doDo(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doDo(req, resp);
	}
	
}
