package com.hb.engine;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DefaultEditorKit.InsertContentAction;

import com.hb.controller.AddController;
import com.hb.controller.DetailController;
import com.hb.controller.InsertController;
import com.hb.controller.ListController;
import com.hb.model.SampleDAO;

public class FrontController extends HttpServlet {

	protected void doDo(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String url = "/";
		String path = req.getRequestURI();
		SampleDAO dao;
		try {
			dao = new SampleDAO();
			if(path.equals("/day01/list.do")) {
				ListController conn = new ListController();
				url = conn.execute(req);
			} else if(path.equals("/day01/detail.do")) {
				DetailController conn = new DetailController();
				url = conn.execute(req);
			} else if(path.equals("/day01/add.do")) {
				AddController conn = new AddController();
				url = conn.execute(req);
			} else if(path.equals("/day01/insert.do")) {
				InsertController conn = new InsertController();
				url = conn.execute(req);
		 	} else {
				url += "index.jsp";
			}
			dao.closeAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
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
