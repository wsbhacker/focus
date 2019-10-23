package com.hacker.focus.configurer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class CustomWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

  @Autowired
  private CustomUserDetailService userService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests().antMatchers("/", "/login").permitAll()
        .anyRequest().hasRole("admin").anyRequest().authenticated() //任何请求,登录后可以访问
        // 配置登录URI、登录失败跳转URI与登录成功后默认跳转URI
        .and().formLogin().loginPage("/login").loginProcessingUrl("/signIn")
        .defaultSuccessUrl("/menu").failureUrl("/login")
        // 注销行为任意访问
        .and().logout().permitAll().logoutSuccessUrl("/login")
        // 设置拒绝访问的提示URI
        .and().exceptionHandling().accessDeniedPage("/login").and().csrf().disable();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    super.configure(web);
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
