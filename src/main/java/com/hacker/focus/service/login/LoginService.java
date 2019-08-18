package com.hacker.focus.service.login;

import com.hacker.focus.entity.User;
import com.hacker.focus.manager.login.ILoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {

  @Autowired
  private ILoginManager loginManager;

  @Override
  public User signIn(User user) throws Exception {
    return loginManager.queryByNameAndKey(user);
  }
}
