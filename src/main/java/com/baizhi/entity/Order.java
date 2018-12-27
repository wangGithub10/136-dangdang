package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wyq
 * @description 订单表实体类
 * @日期：
 */
public class Order implements Serializable {
	/**
	 * 表id
	 */
	private Integer id;
	/**
	 * 总额
	 */
	private Double total_price;
	/**
	 * 状态：已付款与未付款
	 */
	private Integer status;
	/**
	 * 创建日期
	 */
	private Date create_time;
	/**
	 * 用户id
	 */
	private Integer user_id;
	/**
	 * 地址id
	 */
	private Integer address_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
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

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", total_price=" + total_price
				+ ", status=" + status + ", create_time="
				+ create_time + ", user_id=" + user_id
				+ ", address_id=" + address_id + "]";
	}
}
