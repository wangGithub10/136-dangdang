package com.baizhi.test;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest extends BaseTest {
    @Autowired
    private UserDao dao;

    @Test
    public void insert() {
        // 用户的注册
        User user = new User();
        user.setEmail("123");
        user.setNickname("123");
        user.setPassword("123");
        user.setSalt("dadaigy");
        user.setStatus(1);
        user.setCreate_time(new java.sql.Date(0));
        dao.insert(user);
    }

    @Test
    public void update() {
        // 修改用户的状态
        dao.update(1, 0);
    }

    @Test
    public void queryUser() {
        // 用作避免用户注册重复
        User user = dao.queryUser("xiaohie@qq.com");
        System.out.println(user);
    }

    @Test
    public void queryUser2() {
        // 用户登陆
        User user = dao.queryUser2("xiaohie@qq.com", "123456");
        System.out.println(user);
    }
}
