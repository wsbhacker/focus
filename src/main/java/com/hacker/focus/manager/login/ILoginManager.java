package com.hacker.focus.manager.login;

import com.hacker.focus.entity.User;

public interface ILoginManager {

  User queryByNameAndKey(User user) throws Exception;

  User addUser(User user) throws Exception;
}
