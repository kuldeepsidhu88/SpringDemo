package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.demo.constants.SpitterConstants;
import com.demo.model.Spitter;
import com.demo.model.Spittle;
import com.demo.util.SpitterUtil;

@Component
public class SpitterDaoImpl implements SpitterDao {
	
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	public SpitterDaoImpl(){
		
	}

	@Override
	public List<Spittle> getRecentSpittles(int noOfSpittles) {
		jdbcTemplate = new JdbcTemplate(this.dataSource);
		List<Spittle> spittleList = null;
		try{
			String sql = SpitterConstants.RECENT_SPITTLE_LIST;
			List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql, new Object[]{noOfSpittles});
			spittleList = SpitterUtil.getSpittleList(rows);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return spittleList;
	}

	@Override
	public Spitter getSpitter(String username) {

		jdbcTemplate = new JdbcTemplate(this.dataSource);
		Spitter spitter = null;
		try{
			String sql = SpitterConstants.GET_SPITTER;
			spitter = (Spitter)jdbcTemplate.queryForObject(sql, new Object[]{username}, new RowMapper(){
				@Override
				public Object mapRow(ResultSet rs, int arg1) throws SQLException {
					Spitter spitter = new Spitter();
					spitter.setUsername(rs.getString("username"));
					spitter.setEmail(rs.getString("email_id"));
					spitter.setFullName(rs.getString("full_name"));
					return spitter;
				}
				
			});
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return spitter;
	}

	@Override
	public List<Spittle> getSpittlesForSpitter(String username) {
		jdbcTemplate = new JdbcTemplate(this.dataSource);
		List<Spittle> spittleList = null;
		try{
			String sql = SpitterConstants.SPITTLE_LIST;
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[]{username});
			spittleList = SpitterUtil.getSpittleList(rows);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return spittleList;
	}

	@Override
	public int saveSpitter(Spitter spitter) {
		int success = 0;
		jdbcTemplate = new JdbcTemplate(this.dataSource);
		try{
			String sql = SpitterConstants.INSERT_SPITTER;
			jdbcTemplate.update(sql, new Object[]{
				spitter.getUsername(),
				spitter.getPassword(),
				spitter.getEmail(),
				spitter.getFullName()
			});
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			success = -1;
		}
		return success;
	}

}
