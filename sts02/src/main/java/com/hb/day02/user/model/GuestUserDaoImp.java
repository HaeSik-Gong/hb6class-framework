package com.hb.day02.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class GuestUserDaoImp implements GuestUserDao<GuestUserVo> {
	@Autowired
	private DataSource ds;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
//	public GuestUserDaoImp(DataSource ds) {
//		this.ds = ds;
//	}
	
	public void closeAll() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
	
	@Override
	public List<GuestUserVo> selectAll() throws SQLException {
		String sql = "select * from guest_user order by num";
		List<GuestUserVo> list = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<GuestUserVo>();
			while(rs.next()) {
				list.add(new GuestUserVo(rs.getInt("num"),
									rs.getInt("sabun"),
									rs.getString("name"),
									rs.getDate("nalja")));
			}
		} finally {
			closeAll();
		}
		return list;
	}

	@Override
	public GuestUserVo selectOne(int idx) throws SQLException {
		String sql = "select * from guest_user where num=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new GuestUserVo(rs.getInt("num"),
						rs.getInt("sabun"),
						rs.getString("name"),
						rs.getDate("nalja"));
			}
		} finally {
			closeAll();
		}
		return null;
	}

	@Override
	public int insertOne(GuestUserVo bean) throws SQLException {
		String sql = "insert into guest_user values ("
				+ "(select max(num)+1 from guest_user), ?, ?, sysdate)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			return pstmt.executeUpdate();
		} finally {
			closeAll();
		}
	}

	@Override
	public int updateOne(GuestUserVo bean) throws SQLException {
		String sql = "update guest_user set sabun=?, name=? where num=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getNum());
			return pstmt.executeUpdate();
		} finally {
			closeAll();
		}
	}

	@Override
	public int deleteOne(int idx) throws SQLException {
		String sql = "delete from guest_user where num=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			return pstmt.executeUpdate();
		} finally {
			closeAll();
		}
	}
	
}
