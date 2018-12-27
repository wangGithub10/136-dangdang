package com.baizhi.test;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService service;

    @Test
    public void register() {
        // 用户的注册
        User user = new User();
        user.setEmail("xiaobai@qq.com");
        user.setNickname("小白");
        user.setPassword("123456");
        user.setSalt("sadwdas");
        user.setStatus(1);
        user.setCreate_time(new java.sql.Date(0));
        service.register(user);
    }

    @Test
    public void update() {
        // 修改用户的状态
        service.update(1, 1);
    }

    @Test
    public void queryUser() {
        // 用作避免用户注册重复
        User user = service.queryUser("xiaohie@qq.com");
        System.out.println(user);
    }

    @Test
    public void login() {
        // 用户登陆
        User user = service.login("xiaohie@qq.com", "123456");
        System.out.println(user);
    }
}
