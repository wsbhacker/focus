package com.hacker.focus.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDao {

  @Autowired
  protected JdbcTemplate jdbcTemplate;

  protected <T> T get(Class<T> t, String sql, Object... args) {
    return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(t), args);
  }

  protected int delete(String sql, Object... args) {
    return update(sql, args);
  }

  protected int update(String sql, Object... args) {
    return jdbcTemplate.update(sql, args);
  }

  protected int insert(String sql, Object... args) {
    return update(sql, args);
  }

}
