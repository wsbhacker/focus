package com.hacker.focus.dao.plan;

import com.hacker.focus.entity.Plan;

public interface IPlan {
  String GETSQL = "select * from plan where id = ?";
  String DELETESQL = "delete from plan where id = ?";
  String INSERTSQL = "insert into plan (id, finish, statue, subject, userId , createTime, lastModify) values(?,?,?,?,?,?,?)";
  String UPDATESQL = "update plan set statue = ?, lastModify = ? where id = ?";
  String UPDATELASTMODIFY = "update plan set lastModify = ? where id = ?";

  Plan get(String id);

  boolean add(Plan plan);

  boolean delete(String id);

  boolean update(Plan plan);
}
