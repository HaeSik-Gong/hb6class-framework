package com.hb.day01.test01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test03Controller {

	@RequestMapping("/ex03.do")
	public String myPage02(HttpServletRequest req) throws Exception {
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("msg", "메세지다 ㅋㅋ");
		return "ex01";
	}
	
}
