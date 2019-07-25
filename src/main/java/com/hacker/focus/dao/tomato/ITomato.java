package com.hacker.focus.dao.tomato;

import com.hacker.focus.entity.Tomato;

public interface ITomato {

  String GETSQL = "select * from tomato where id = ?";
  String DELETESQL = "delete from tomato where id = ?";
  String INSERTSQL = "insert into tomato (id, end, start, statue, timeLength, userId , createTime, lastModify) values(?,?,?,?,?,?,?,?)";
  String UPDATESQL = "update tomato set statue = ?, lastModify = ? where id = ?";
  String UPDATELASTMODIFY = "update tomato set lastModify = ? where id = ?";

  Tomato get(String id);

  boolean add(Tomato tomato);

  boolean delete(String id);

  boolean update(Tomato tomato);
}
