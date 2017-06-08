package com.hb.day01.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyOracle {

	private static Connection conn;
	
	private MyOracle() {
		
	}
	
	public static Connection getConnection() {
		try {
			if(conn==null || conn.isClosed()) {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
