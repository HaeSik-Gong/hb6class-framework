package com.hb.controller;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorld extends ActionSupport {

	@Override
	public String execute() throws Exception {
		
		/* struts.xml �� result name �Ӽ��� ��ȯ
		 * 		1. "success"�� ��ȯ�Ѵٸ� hello.jsp �������� �̵�
		 * 		2. "failurs"�� ��ȯ�Ѵٸ� err.jsp �������� �̵�		 * 
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
