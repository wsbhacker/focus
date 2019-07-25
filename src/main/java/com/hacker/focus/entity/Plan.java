package com.hacker.focus.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * todo记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Plan extends BaseEntity {

  public Plan() {
    super();
  }

  private String subject;
  private String userId;
  private Date finish;
  private String statue;
}
