package com.hacker.focus.entity;


import lombok.Data;

/**
 * 用户实体类
 */
@Data
public class User extends BaseEntity {

  private String name;
  private String password;
}
