package com.hacker.focus;

import com.hacker.focus.dao.plan.IPlan;
import com.hacker.focus.dao.tomato.ITomato;
import com.hacker.focus.entity.Plan;
import com.hacker.focus.entity.PlanStatu;
import com.hacker.focus.entity.Tomato;
import com.hacker.focus.entity.TomatoStatue;
import com.hacker.focus.entity.User;
import com.hacker.focus.manager.login.ILoginManager;
import java.util.Date;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FocusApplicationTests {

  @Autowired
  private ILoginManager loginManager;
  @Autowired
  private IPlan planDao;
  @Autowired
  private ITomato tomatoDao;

  @Test
  public void testUserInsert() throws Exception {
    User user = new User();
    user.setEmail("w776a889n347g@163.com");
    user.setName("hacker");
    user.setPassword("hacker");
    user.setCreateTime(new Date());
    user.setLastModify(new Date());
    loginManager.addUser(user);
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
    System.out.println(user.toString());
  }


}
