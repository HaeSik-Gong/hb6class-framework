package com.hb.day01.model;

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
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeAll() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
	
	public List<UserVo> selectAll() throws SQLException {
		String sql = "select * from user03 order by sabun";
		List<UserVo> list = new ArrayList<UserVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new UserVo(rs.getInt("sabun"),
							rs.getString("name"),
							rs.getDate("nalja"),
							rs.getInt("pay")));
			}
		} finally {
			closeAll();
		}
		return list;
	}

	public int insertOne(UserVo bean) throws SQLException {
		String sql = "insert into user03 values(?, ?, sysdate, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPay());
			return pstmt.executeUpdate();
		} finally {
			closeAll();
		}
	}

	public UserVo selectOne(int sabun) throws SQLException {
		String sql = "select * from user03 where sabun=?";
		UserVo bean = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean = new UserVo(rs.getInt("sabun"),
							rs.getString("name"), 
							rs.getDate("nalja"), 
							rs.getInt("pay"));
			}
		} finally {
			closeAll();
		}
		return bean;
	}

	public int updateOne(UserVo bean) throws SQLException {
		String sql = "update user03 set name=?, pay=? where sabun=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.setInt(3, bean.getSabun());
			return pstmt.executeUpdate();
		} finally {
			closeAll();
		}
	}

	public int deleteOne(int sabun) throws SQLException {
		String sql = "delete from user03 where sabun=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			return pstmt.executeUpdate();
		} finally {
			closeAll();
		}
	}
	
}
