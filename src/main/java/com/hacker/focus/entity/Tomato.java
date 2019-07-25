package com.hacker.focus.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * 番茄时钟记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Tomato extends BaseEntity{

  public Tomato() {
    super();
  }

  private Date start;
  private Date end;
  private String userId;
  private int timeLength;
  private String statue;
}
