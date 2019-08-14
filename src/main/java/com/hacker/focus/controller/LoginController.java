package com.hacker.focus.controller;

import com.hacker.focus.entity.User;
import com.hacker.focus.service.login.ILoginService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

  @Autowired
  private ILoginService loginService;

  @GetMapping(value = {"/", "/login"})
  public String login(HttpSession session) {
    User user = (User) session.getAttribute("user");
    if (user != null) {
      User user1 = loginService.signIn(user);
      return "menu";
    } else {
      return "login";
    }
  }

  @PostMapping(value = {"/menu"})
  public String doLogin(@RequestParam("username") String name,
      @RequestParam("password") String passWord, HttpSession session) {
    // TODO: 2019/7/26
    Assert.hasLength(name, "user name can not be empty.");
    User user = new User(name, passWord);
    user = loginService.signIn(user);
    session.setAttribute("user", user);
    return "menu";
  }

  @GetMapping(value = {"/test"})
  public String test() {
    return "test";
  }
}
