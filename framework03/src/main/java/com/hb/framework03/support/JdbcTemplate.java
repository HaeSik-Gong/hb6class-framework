package com.hb.framework03.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplate {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public JdbcTemplate() {
		String url = "jdbc:h2:tcp://localhost/~/test";
		String user = "sa";
		String pw = "";
		
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(url, user, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeAll() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
	
	public int executeUpdate(String sql, Object[] objs) throws SQLException {
		pstmt = conn.prepareStatement(sql);
		
		for(int i=0; i<objs.length; i++) {
			pstmt.setObject((i+1), objs[i]);
		}
		
		int result = pstmt.executeUpdate();
		closeAll();
		return result;
	}
	
	public Object execcuteQuery(String sql, RowMapper mapper) throws SQLException {
		return execcuteQuery(sql, new Object[]{}, mapper);
	}
	
	public Object execcuteQuery(String sql, Object[] objs, RowMapper mapper) throws SQLException {
		pstmt = conn.prepareStatement(sql);
		
		for(int i=0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		rs = pstmt.executeQuery();
		Object obj = mapper.mapRow(rs);
		closeAll();
		return obj;
	}
	
	public List queryList(String sql, RowMapper mapper) throws SQLException {
		return queryList(sql, new Object[]{}, mapper);
	}

	public List queryList(String sql, Object[] objs, RowMapper mapper) throws SQLException {
		List list = mapper.list;
		pstmt = conn.prepareStatement(sql);
		
		for(int i=0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		rs = pstmt.executeQuery();
		Object obj = mapper.mapRow(rs);
		closeAll();
		return list;
	}
	
//	public abstract Object mapper(ResultSet rs) throws SQLException;
}
