package com.hacker.focus.configurer.security;

import com.hacker.focus.dao.user.IUser;
import com.hacker.focus.entity.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {

  @Autowired
  private IUser userDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    org.springframework.security.core.userdetails.User userInfo = authentication == null ? null
//        : (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
    org.springframework.security.core.userdetails.User userInfo = null;
    if (userInfo == null) {
      User user = userDao.getByName(username);
      Optional.ofNullable(user).orElseThrow(() -> new UsernameNotFoundException(username));
      userInfo = new org.springframework.security.core.userdetails.User(user.getName(),
          passwordEncoder().encode(user.getPassword()),
          AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
    return userInfo;
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
