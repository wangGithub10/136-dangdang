package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wyq
 * @description 用户表实体类
 * @日期：
 */
public class User implements Serializable {
	/**
	 * 表id
	 */
	private Integer id;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 盐
	 */
	private String salt;
	/**
	 * 状态：注册未激活状态和注册已激活状态
	 */
	private Integer status;
	/**
	 * 注册时间
	 */
	private Date create_time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", nickname="
				+ nickname + ", password=" + password + ", salt="
				+ salt + ", status=" + status + ", create_time="
				+ create_time + "]";
	}
}
