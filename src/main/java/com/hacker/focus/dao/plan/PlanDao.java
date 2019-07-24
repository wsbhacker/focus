package com.hacker.focus.dao.plan;

import com.hacker.focus.dao.BaseDao;
import com.hacker.focus.entity.Plan;
import org.springframework.stereotype.Repository;

@Repository
public class PlanDao extends BaseDao implements IPlan {

  @Override
  public Plan get(String id) {
    return get(Plan.class, GETSQL, id);
  }

  @Override
  public boolean add(Plan plan) {
    int affect = insert(INSERTSQL, plan.getId(), plan.getFinish(), plan.getStatue(), plan.getSubject(), plan.getUserId(), plan.getCreateTime(), plan.getLastModify());
    return affect == 1;
  }

  @Override
  public boolean delete(String id) {
    int affected = delete(DELETESQL, id);
    return affected == 1;
  }

  @Override
  public boolean update(Plan plan) {
    int affect = update(UPDATESQL, plan.getStatue(), plan.getLastModify(), plan.getId());
    return affect == 1;
  }
}
