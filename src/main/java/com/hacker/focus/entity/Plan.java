package com.hacker.focus.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * todo记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Plan extends BaseEntity {
  private String subject;
  private String userId;
  private Date finish;
  private PlanStatu statue;
}
