package com.hacker.focus.manager.login;

import com.hacker.focus.entity.User;

public interface ILoginManager {
  User signInByNameAndKey(User user);
}
