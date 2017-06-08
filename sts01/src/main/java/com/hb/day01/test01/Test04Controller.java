package com.hb.day01.test01;

import javax.servlet.http.HttpServletRequest;

import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.runner.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Test04Controller {

	@RequestMapping("/ex04.do")
	public String myPage03(Model model) {
		model.addAttribute("msg", "�𵨷� �����ϴ°Ŵ�");
		return "ex02";
	}
	
	@RequestMapping("/ex05.do")
	public String myPage04(Model model) {
		model.addAttribute("msg", "myPage04()�� �����ϴ°Ŵ�");
		return "ex02";
	}

	@RequestMapping("/ex06")
	public void myPage05() {
		// ��ȯŸ���� void�� ��쿡�� ���� �̸��� �ּҸ� ���󰡰� �ȴ�.
	}
	
	@RequestMapping("/ex07")
	public String myPage06(HttpServletRequest req) {
		req.setAttribute("msg", req.getParameter("msg"));
		return "ex07";
	}
	
	@RequestMapping("/ex08")
//	public String myPage07(String msg) {
	public String myPage07(@RequestParam("msg") String msg2) {
		System.out.println(msg2);
		return "ex08";
	}
	
//	@RequestMapping("/{a}/{b}")
//	public String myPage08(@PathVariable String a, @PathVariable String b) {
//		System.out.println("a : " + a);
//		System.out.println("b : " + b);
//		return "ex01";
//	}
	
	@RequestMapping("/ex09")
	public String myPage09() {
		return "ex02";
	}
	
	@RequestMapping(value = "/ex10", method = RequestMethod.POST)
	public String myPage10(String id, String pw) {
		System.out.println("ID : " + id + " PW : " + pw);
		return "ex03";
	}
	
}
