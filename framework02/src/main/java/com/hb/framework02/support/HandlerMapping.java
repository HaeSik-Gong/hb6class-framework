package com.hb.framework02.support;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {

	private static Map<String, String> map = new HashMap<String, String>();
	
	public static void setMap(String key, String value) {
		map.put(key, value);
	}
	
	public static MyController mapping(String uri) {
		MyController con = null;
		System.out.println("MyController : " + map.get(uri));
		try {
			Class clazz = Class.forName(map.get(uri));
			con = (MyController) clazz.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
