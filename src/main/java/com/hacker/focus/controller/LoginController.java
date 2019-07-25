package com.hacker.focus.controller;

import com.hacker.focus.entity.User;
import com.hacker.focus.service.login.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

  @Autowired
  private ILoginService loginService;

  @GetMapping(value = {"/login", "/"})
  public String login() {
    return "login";
  }

  @PostMapping(value = "/signIn")
  public String doLogin(@RequestParam String name, @RequestParam String passWord, HttpSession session) {
    // TODO: 2019/7/26
    Assert.hasLength(name, "user name can not be empty.");
    User user = new User(name, passWord);
    user = loginService.signIn(user);
    return "menu";
  }
}
