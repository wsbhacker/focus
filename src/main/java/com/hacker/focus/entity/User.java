package com.hacker.focus.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

  public User() {
    super();
  }

  private String name;
  private String password;
}
