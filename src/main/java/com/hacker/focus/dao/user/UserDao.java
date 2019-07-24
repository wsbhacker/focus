package com.hacker.focus.dao.user;

import com.hacker.focus.dao.BaseDao;
import com.hacker.focus.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao implements IUser {

  @Override
  public User get(String id) {
    return get(User.class, GETSQL, id);
  }

  @Override
  public boolean add(User user) {
    int affected = insert(INSERTSQL, user.getId(), user.getName(), user.getPassword(), user.getCreateTime(), user.getLastModify());
    return affected == 1;
  }

  @Override
  public boolean delete(String id) {
    int affected = delete(DELETESQL, id);
    return affected == 1;
  }

  @Override
  public boolean update(User user) {
    int update = update(UPDATESQL, user.getName(), user.getPassword(), user.getLastModify(), user.getId());
    return update == 1;
  }
}
