package com.hb.struts2.model;

import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SimpleDAO {

	private static SqlMapClient smc;
	
	public SimpleDAO() {
		String path = "./SqlMapConfig.xml";
		try {
			Reader rd = Resources.getResourceAsReader(path);
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<SimpleVo> selectAll() throws SQLException {
		List<SimpleVo> list = smc.queryForList("selectAll");
		return list;
	}

	public SimpleVo selectOne(int sabun) throws SQLException {
		return (SimpleVo) smc.queryForObject("selectOne", sabun);
	}

	public int updateOne(SimpleVo bean) throws SQLException {
		return smc.update("updateOne", bean);
	}

	public void insertOne(SimpleVo bean) throws SQLException {
		smc.insert("insertOne", bean);
	}

	public int deleteOne(int sabun) throws SQLException {
		return smc.delete("deleteOne", sabun);
		
	}
	
}
