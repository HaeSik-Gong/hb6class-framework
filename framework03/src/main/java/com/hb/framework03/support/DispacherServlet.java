package com.hb.framework03.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispacherServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();
		
		Properties prop = new Properties();
		InputStream is = getClass().getClassLoader().getResourceAsStream("bean.properties");
		
		if(is != null) {
			try {
				prop.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Set<Object> obj = prop.keySet();
		Iterator<Object> ite = obj.iterator();
		while(ite.hasNext()) {
			String key = (String) ite.next();
			String value = prop.getProperty(key);
			HandlerMapping.setMap(key, value);
		}
		
//		HandlerMapping.setMap("/list.do", "com.hb.framework03.controller.SelectAll");
//		HandlerMapping.setMap("/detail.do", "com.hb.framework03.controller.SelectOne");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		/*
		<!-- Fundtion		URL				Method  -->
		<!-- -------------------------------------  -->
		<!-- list			list.do			get		-->
		<!-- detail			detail.do		get 	-->
		<!-- inse\rt			update.do		post 	-->
		<!-- update			update.do		put		-->
		<!-- delete			update.do		delete	-->
		*/
		
		// Controller º±≈√
		String uri = req.getRequestURI();
		MyController con = HandlerMapping.mapping(uri);
		String path = con.execute(req, resp);
		
		// View Mapping
		if(path.startsWith("redirect:")) {
			path = path.replace("redirect:", "");
			resp.sendRedirect(path);
			return;
		}
				
		String prfix = "/WEB-INF/page/";
		String sufix = ".jsp";
		req.getRequestDispatcher(prfix + path + sufix).forward(req, resp);
				
	}
	
}
