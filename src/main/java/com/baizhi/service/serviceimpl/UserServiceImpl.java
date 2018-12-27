package com.baizhi.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;

/**
 * @author wyq
 * @description 用户功能Service接口实现
 * @日期：
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public void register(User user) {
		// 用户的注册
		userDao.insert(user);
	}

	@Override
	public void update(Integer id, Integer status) {
		// 修改用户的状态
		userDao.update(id, status);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public User queryUser(String email) {
		// 用作避免用户注册重复
		User user = userDao.queryUser(email);
		return user;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public User login(String email, String password) {
		// 用户登陆
		User user = userDao.queryUser2(email, password);
		return user;
	}
}
