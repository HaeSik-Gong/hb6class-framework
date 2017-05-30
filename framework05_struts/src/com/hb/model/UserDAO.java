package com.hb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hb.util.MyOracle;

public class UserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void closeAll() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
	
	public List<Map<String, Object>> selectAll() throws SQLException {
		String sql = "select * from user02 order by sabun";
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("sabun", rs.getInt("sabun"));
				map.put("name", rs.getString("name"));
				map.put("nalja", rs.getString("nalja"));
				map.put("pay", rs.getInt("pay"));
				list.add(map);
			}
		} finally {
			closeAll();
		}
		return list;
	}
	
	public Map<String, Object> selectOne(int sabun) throws SQLException {
		String sql = "select * from user02 where sabun=?";
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				map.put("sabun", rs.getInt("sabun"));
				map.put("name", rs.getString("name"));
				map.put("nalja", rs.getString("nalja"));
				map.put("pay", rs.getInt("pay"));
			}
		} finally {
			closeAll();
		}
		
		return map;
	}

	public int insertOne(String name, String nalja, int pay) throws SQLException {
		String sql = "insert into user02(name, nalja, pay) values(?, ?, ?)";
		int result = 0;
		try {
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, nalja);
			pstmt.setInt(3, pay);
			result = pstmt.executeUpdate();
		} finally {
			closeAll();
		}		
		return result;
	}

	public int updateOne(int sabun, String name, String nalja, int pay) throws SQLException {
		String sql = "update user02 set name=?, nalja=?, pay=? where sabun=?";
		int result = 0;
		try {
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, nalja);
			pstmt.setInt(3, pay);
			pstmt.setInt(4, sabun);
			result = pstmt.executeUpdate();
		} finally {
			closeAll();
		}
		return result;
	}
	
	public int deleteOne(int sabun) throws SQLException {
		String sql = "delete from user02 where sabun=?";
		int result = 0;
		try {
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			result = pstmt.executeUpdate();
		} finally {
			closeAll();
		}
		return result;
	}
	
}
