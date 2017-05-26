package com.hb.framework02.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void closeAll() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
	
	public int insertOne(UserVo vo) throws SQLException {
		String sql = "insert into user02(name, nalja, pay) values(?, ?, ?)";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getNalja());
			pstmt.setInt(3, vo.getPay());
			result = pstmt.executeUpdate();
		} finally {
			closeAll();
		}
		return result;
	}
	
	public List<UserVo> selectAll() throws SQLException {
		String sql = "select * from user02";
		List<UserVo> list = new ArrayList<UserVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVo vo = new UserVo();
				vo.setSabun(rs.getInt("sabun"));
				vo.setName(rs.getString("name"));
				vo.setNalja(rs.getString("nalja"));
				vo.setPay(rs.getInt("pay"));
				list.add(vo);
			}
		} finally {
			closeAll();
		}
		return list;
	}
	
}
