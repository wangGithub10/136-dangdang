package com.baizhi.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.OrderDao;
import com.baizhi.entity.Order;
import com.baizhi.service.OrderService;

/**
 * @author wyq
 * @description 订单功能Service接口实现
 * @日期：
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;

	@Override
	public void insert(Order order) {
		// 生成订单
		orderDao.insert(order);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Order queryOrder(Integer id) {
		// 查询一个订单
		Order queryOrder = orderDao.queryOrder(id);
		return queryOrder;
	}

	@Override
	public void update(Order order) {
		// 完善订单
		orderDao.update(order);
	}
}
