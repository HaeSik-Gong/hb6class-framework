package com.hb.day01.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.day01.util.MyOracle;

public class UserDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDao() {
		// TODO Auto-generated constructor stub
	}
	
	public void closeAll() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
	
	public List<UserVo> selectAll() throws SQLException {
		String sql = "select * from user03 order by sabun";
		List<UserVo> list = null;
		try {
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<UserVo>();
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

	public int insertOne(int sabun, String name, int pay) throws SQLException {
		String sql = "insert into user03 values(?, ?, sysdate, ?)";
		try {
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			pstmt.setString(2, name);
			pstmt.setInt(3, pay);
			return pstmt.executeUpdate();
		} finally {
			closeAll();
		}
	}

	public UserVo selectOne(int sabun) throws SQLException {
		String sql = "select * from user03 where sabun=?";
		try {
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new UserVo(rs.getInt("sabun"),
								rs.getString("name"),
								rs.getDate("nalja"),
								rs.getInt("pay"));
			}
		} finally {
			closeAll();
		}
		return null;
	}
	
	public int updateOne(int sabun, String name, int pay) throws SQLException {
		String sql = "update user03 set name=?, pay=? where sabun=?";
		try {
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, pay);
			pstmt.setInt(3, sabun);
			return pstmt.executeUpdate();
		} finally {
			closeAll();
		}
	}
	
	public int deleteOne(int sabun) throws SQLException {
		String sql = "delete from user03 where sabun=?";
		try {
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			return pstmt.executeUpdate();
		} finally {
			closeAll();
		}
	}
	
}
