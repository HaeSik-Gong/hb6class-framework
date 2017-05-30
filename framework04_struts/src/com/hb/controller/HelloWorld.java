package com.hb.controller;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorld extends ActionSupport {

	@Override
	public String execute() throws Exception {
		
		/* struts.xml 의 result name 속성을 반환
		 * 		1. "success"를 반환한다면 hello.jsp 페이지로 이동
		 * 		2. "failurs"를 반환한다면 err.jsp 페이지로 이동		 * 
		 * 
		 * <package name="hello" extends="struts-default">
		 * 		<action name="step01" class="com.hb.controller.HelloWorld">
		 * 			<result name="success">/hello.jsp</result>
		 * 			<result name="failurs">/err.jsp</result>
		 * 		</action>
		 * </package>   
		 *  
		 * */
		
		return "success";
	}
	
}
