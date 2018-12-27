package com.baizhi.service;

import com.baizhi.entity.Order;

/**
 * @author wyq
 * @description 订单功能Service接口
 * @日期：
 */
public interface OrderService {
	/**
	 * @description 生成订单
	 * @param order  Order实体类
	 * @return void
	 */
	public void insert(Order order);

	/**
	 * @description 查询一个订单
	 * @param id  订单表主键
	 * @return Order
	 */
	public Order queryOrder(Integer id);

	/**
	 * @description 完善订单
	 * @param order  Order实体类
	 * @return void
	 */
	public void update(Order order);
}
