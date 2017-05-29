package com.hb.framework03.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hb.framework03.support.JdbcTemplate;
import com.hb.framework03.support.RowMapper;

public class UserDAO {

	public UserDAO() {
	
	}
	
	public List selectAll() throws SQLException {
		String sql = "select * from user02";
		JdbcTemplate jdbc = new JdbcTemplate();
		return jdbc.queryList(sql, new Object[]{}, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs) throws SQLException {
				while(rs.next()) {
					UserVo vo = new UserVo();
					vo.setSabun(rs.getInt("sabun"));
					vo.setName(rs.getString("name"));
					vo.setNalja(rs.getString("nalja"));
					vo.setPay(rs.getInt("pay"));
					list.add(vo);
				}
				return list;
			}
		});
	}

	public UserVo selectOne(int sabun) throws SQLException {
		String sql = "select * from user02 where sabun=?";
		JdbcTemplate jdbc = new JdbcTemplate();
		return (UserVo) jdbc.execcuteQuery(sql, new Object[]{sabun}, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs) throws SQLException {
				UserVo vo = new UserVo();
				if(rs.next()) {
					vo.setSabun(rs.getInt("sabun"));
					vo.setName(rs.getString("name"));
					vo.setNalja(rs.getString("nalja"));
					vo.setPay(rs.getInt("pay"));
				}
				return vo;
			}
		});
	}
	
	public int insertOne(String name, String nalja, int pay) throws SQLException {
		String sql = "insert into user02(name, nalja, pay) values(?, ?, ?)";
		JdbcTemplate jdbc = new JdbcTemplate();
		return jdbc.executeUpdate(sql, new Object[]{name, nalja, pay});
	}

	public int updateOne(int sabun, String name, String nalja, int pay) throws SQLException {
		String sql = "update user02 set name=?, nalja=?, pay=? where sabun=?";
		JdbcTemplate jdbc = new JdbcTemplate();
		return jdbc.executeUpdate(sql, new Object[]{name, nalja, pay, sabun});
	}

	public int deleteOne(int sabun) throws SQLException {
		String sql = "delete from user02 where sabun=?";
		JdbcTemplate jdbc = new JdbcTemplate();
		return jdbc.executeUpdate(sql, new Object[]{sabun});
	}
	
}
