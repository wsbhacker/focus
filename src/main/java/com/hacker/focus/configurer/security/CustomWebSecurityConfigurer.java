package com.hacker.focus.configurer.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class CustomWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

  // TODO: 2019/7/24 需要设置验证

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.formLogin().loginPage("/login").permitAll().and()
            .authorizeRequests().antMatchers("/").permitAll()
            .anyRequest().authenticated();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // TODO: 2019/7/24  
    super.configure(auth);
  }
}
