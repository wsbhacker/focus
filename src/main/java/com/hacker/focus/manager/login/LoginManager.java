package com.hacker.focus.manager.login;

import com.hacker.focus.dao.user.IUser;
import com.hacker.focus.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class LoginManager implements ILoginManager {

  @Autowired
  private IUser userDao;

  @Override
  public User signInByNameAndKey(User user) {
    User byNameUser = userDao.getByName(user.getName());
    Assert.notNull(byNameUser, "user not exist.");
    String password = byNameUser.getPassword();
    String passport = user.getPassword();
    // TODO: 2019/7/26 密码比对
    return byNameUser;
  }
}
