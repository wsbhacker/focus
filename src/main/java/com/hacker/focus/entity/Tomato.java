package com.hacker.focus.entity;


import lombok.Data;

import java.util.Date;

/**
 * 番茄时钟记录
 */
@Data
public class Tomato extends BaseEntity{
  private Date start;
  private Date end;
  private String userId;
  private int timeLength;
}
