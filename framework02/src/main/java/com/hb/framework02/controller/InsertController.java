package com.hb.framework02.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.framework02.model.UserDAO;
import com.hb.framework02.model.UserVo;
import com.hb.framework02.support.MyController;

public class InsertController implements MyController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(!"POST".equals(request.getMethod())){
			request.setAttribute("msg", "잘못된 접근입니다");
			return "form";
		}
		Map<String, String> errs = new HashMap<>();
		String param1=request.getParameter("name");
		String param2=request.getParameter("nalja");
		String param3=request.getParameter("pay");
		
		UserVo vo = new UserVo();
		vo.setName(param1);
		vo.setNalja(param2);
		
		try{
			vo.setPay(Integer.parseInt(param3));
		}catch (Exception e) {
			errs.put("pay", "금액입력");
		}
		if(param1.equals("")){
			errs.put("name", "이름입력");
		}
		if(param2.equals("")){
			errs.put("nalja", "날짜입력");
		}
		
		if(!errs.isEmpty()){
			request.setAttribute("bean", vo);
			request.setAttribute("err", errs);
			return "form";
		}
		
		UserDAO dao = new UserDAO();
		int result = 0;
		try {
			result = dao.insertOne(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result > 0) {
			return "redirect:list.do";
		}
		else return "add";
	}
	
}
