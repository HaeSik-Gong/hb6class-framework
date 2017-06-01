package com.hb.struts.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

public class UserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pw = "tiger";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void closeAll() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
	
	public int insertOne(int sabun, String name, int pay) throws SQLException {
		String sql = "insert into user03(sabun, name, pay) values(?, ? ,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			pstmt.setString(2, name);
			pstmt.setInt(3, pay);
			return pstmt.executeUpdate();
		} finally {
			closeAll();
		}
	}
	
	public int insertOne(UserVo bean) throws SQLException {
		String sql = "insert into user03(sabun, name, pay) values(?, ? ,?)";
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
	
}
