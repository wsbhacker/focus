package com.hacker.focus.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
  private String id;
  private Date createTime;
  private Date lastModify;
}
