package com.hacker.focus.dao.user;

import com.hacker.focus.entity.User;

public interface IUser {

  String GETSQL = "select * from user where id = ?";
  String DELETESQL = "delete from user where id = ?";
  String INSERTSQL = "insert into user (id,name,password,create,lastModify) values(?,?,?,?,?)";
  String UPDATESQL = "update user set name = ?, password = ? , lastModify = ? where id = ?";
  String UPDATELASTMODIFY = "update user set lastModify = ? where id = ?";

  User get(String id);

  boolean add(User user);

  boolean delete(String id);

  boolean update(User user);
}