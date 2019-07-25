package com.hacker.focus;

import com.hacker.focus.dao.plan.IPlan;
import com.hacker.focus.dao.tomato.ITomato;
import com.hacker.focus.dao.user.IUser;
import com.hacker.focus.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FocusApplicationTests {

  @Autowired
  private IUser userDao;
  @Autowired
  private IPlan planDao;
  @Autowired
  private ITomato tomatoDao;

  @Test
  public void testUserInsert() {
    User user = new User();
    user.setName("hacker" + System.currentTimeMillis());
    user.setPassword("hacker" + System.currentTimeMillis());
    user.setId(UUID.randomUUID().toString());
    user.setCreateTime(new Date());
    user.setLastModify(new Date());
    System.out.println(userDao.add(user));
  }

  @Test
  public void testTomatoInsert() {
    Tomato tomato = new Tomato();
    Date date = new Date();
    tomato.setStart(date);
    tomato.setCreateTime(date);
    tomato.setEnd(date);
    tomato.setLastModify(date);
    tomato.setTimeLength(30);
    tomato.setUserId(UUID.randomUUID().toString());
    tomato.setStatue(TomatoStatue.RUNING.name());
    System.out.println(tomatoDao.add(tomato));
  }

  @Test
  public void testPlanInsert() {
    Plan plan = new Plan();
    Date date = new Date();
    plan.setFinish(date);
    plan.setStatue(PlanStatu.TODO.name());
    plan.setSubject("测试");
    plan.setUserId(UUID.randomUUID().toString());
    plan.setCreateTime(date);
    plan.setLastModify(date);
    System.out.println(planDao.add(plan));
  }

  @Test
  public void testQueryUser() {
    User user = new User();
    user = userDao.get("343a1cbe-7bb2-46cc-95c2-125a33b6a9fd");
    System.out.println(user.toString());
  }


}
