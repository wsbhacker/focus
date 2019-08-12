package com.hacker.focus.entity;


import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class User extends BaseEntity {

  public User() {
    super();
  }

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  private String name;
  private String password;
  private BigDecimal score;
  private BigDecimal level;
}
