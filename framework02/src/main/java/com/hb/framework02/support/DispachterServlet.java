package com.hb.framework02.support;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispachterServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		HandlerMapping.setMap("/framework02/*.do", "com.hb.framework02.controller.ListController");
		HandlerMapping.setMap("/framework02/list.do", "com.hb.framework02.controller.ListController");
		HandlerMapping.setMap("/framework02/add.do", "com.hb.framework02.controller.AddController");
		HandlerMapping.setMap("/framework02/insert.do", "com.hb.framework02.controller.InsertController");
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/********************************************************
			Servlet			method		view					return String
		 	/list.do		get		→ list.jsp					→ list					
		 	/detail.do		get		→ detail.jsp				→ detail
		 	/add.do			get		→ form.jsp					→ form
		 	/insert.do		post	→ redirect : list.do		→ redirect:list.do
		 	/edit.do		get		→ form.jsp 재사용			→ form
		 	/update.do		post	→ redirect : detail.do		→ redirect:detail.do
		 	/delete.do		post	→ redirect : detail.do		→ redirect:detail.do
		********************************************************/
		
		// Controller 선택
		String uri = req.getRequestURI();
		System.out.println(uri);
		MyController con = HandlerMapping.mapping(uri);
		String pname = con.execute(req, resp);
		
		// View 처리
		String url = null;
		if(pname.startsWith("redirect:")) {
			url = pname.replace("redirect:", "");
			resp.sendRedirect(url);
			return;
		} 
		
		String prifix = "/page/";
		String sufix = ".jsp";
		url = prifix + pname + sufix;
		req.getRequestDispatcher(url).forward(req, resp);
	}

}
