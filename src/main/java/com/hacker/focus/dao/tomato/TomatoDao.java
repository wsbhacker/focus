package com.hacker.focus.dao.tomato;

import com.hacker.focus.dao.BaseDao;
import com.hacker.focus.entity.Tomato;
import org.springframework.stereotype.Repository;

@Repository
public class TomatoDao extends BaseDao implements ITomato {

  @Override
  public Tomato get(String id) {
    return get(Tomato.class, GETSQL, id);
  }

  @Override
  public boolean add(Tomato tomato) {
    int affect = insert(INSERTSQL, tomato.getId(), tomato.getEnd(), tomato.getStart(), tomato.getStatue(), tomato.getTimeLength(), tomato.getUserId(), tomato.getCreateTime(), tomato.getLastModify());
    return affect == 1;

  }

  @Override
  public boolean delete(String id) {
    int affected = delete(DELETESQL, id);
    return affected == 1;
  }

  @Override
  public boolean update(Tomato tomato) {
    int affect = update(UPDATESQL, tomato.getStatue(), tomato.getLastModify(), tomato.getId());
    return affect == 1;
  }
}
