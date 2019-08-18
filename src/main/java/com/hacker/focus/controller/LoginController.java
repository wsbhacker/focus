package com.hacker.focus.controller;

import com.hacker.focus.entity.User;
import com.hacker.focus.service.login.ILoginService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

  @Autowired
  private ILoginService loginService;

  @GetMapping(value = {"/", "/login"})
  public String login(HttpSession session) {
    User user = (User) session.getAttribute("user");
    if (user != null) {
      try {
        user = loginService.signIn(user);
        session.setAttribute("user", user);
      } catch (Exception e) {
        session.setAttribute("error", e.getMessage());
      }
      return "menu";
    } else {
      return "login";
    }
  }

  @GetMapping(value = {"/menu"})
  public String doLogin(HttpServletRequest request, HttpSession session) {
    // TODO: 2019/7/26
//    Assert.hasLength(name, "user name can not be empty.");
//    User user = new User(name, passWord);
    return "menu";
  }
}
