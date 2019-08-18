package com.hacker.focus.manager.login;

import com.hacker.focus.dao.user.IUser;
import com.hacker.focus.entity.User;
import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class LoginManager implements ILoginManager {

  @Autowired
  private IUser userDao;

  @Override
  public User queryByNameAndKey(User user) throws Exception {
    User byNameUser = userDao.getByName(user.getName());
    Assert.notNull(byNameUser, "user not exist.");
    String password = byNameUser.getPassword();
    String passport = user.getPassword();
    if (!passwordEncoder().matches(passport, password)) {
      throw new Exception("user or password not right.");
    }
    return byNameUser;
  }

  @Override
  public User addUser(User user) throws Exception {
    Assert.hasLength(user.getName(), "user name can not null.");
    Assert.hasLength(user.getEmail(), "user email can not null.");
    Assert.hasLength(user.getPassword(), "user email can not null.");
    boolean exist = userDao.exist(user);
    if (exist) {
      throw new Exception("user has exist.");
    }
    user.setLevel(BigDecimal.ONE);
    user.setScore(BigDecimal.ZERO);
    user.setId(UUID.randomUUID().toString());
    user.setPassword(passwordEncoder().encode(user.getPassword()));
    userDao.add(user);
    return userDao.getByName(user.getName());
  }

  @Bean
  private BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
