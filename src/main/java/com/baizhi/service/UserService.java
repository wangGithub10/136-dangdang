package com.baizhi.service;

import com.baizhi.entity.User;

/**
 * @author wyq
 * @description 用户功能Service接口
 * @日期：
 */
public interface UserService {
	/**
	 * @description 用户的注册
	 * @param user  User实体类
	 */
	public void register(User user);

	/**
	 * @description 修改用户的状态
	 * @param id  用户表的主键字段
	 * @param status  用户表的状态字段
	 */
	public void update(Integer id, Integer status);

	/**
	 * @description 用作避免用户注册重复
	 * @param email  用户表邮箱字段
	 * @return User
	 */
	public User queryUser(String email);

	/**
	 * @description 用户登陆
	 * @param email  邮箱
	 * @param password  密码
	 * @return User
	 */
	public User login(String email, String password);
}
