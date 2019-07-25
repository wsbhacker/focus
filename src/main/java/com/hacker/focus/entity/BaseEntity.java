package com.hacker.focus.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
public class BaseEntity implements Serializable {

  public BaseEntity() {
    setId(UUID.randomUUID().toString());
  }

  private String id;
  private Date createTime;
  private Date lastModify;
}
