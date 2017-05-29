package com.hb.framework03.support;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {

	private static Map<String, String> map = new HashMap<>();
	
	public static void setMap(String key, String value) {
		map.put(key, value);
	}
	
	public static MyController mapping(String uri) {
		MyController con = null;
		
		try {
			Class cl = Class.forName(map.get(uri));
			con = (MyController) cl.newInstance();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

}
