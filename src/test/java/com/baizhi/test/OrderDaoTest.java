package com.baizhi.test;

import com.baizhi.dao.OrderDao;
import com.baizhi.entity.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDaoTest extends BaseTest {
    @Autowired
    private OrderDao dao;

    @Test
    public void insert() {
        // 生成订单
        Order order = new Order();
        dao.insert(order);
        System.out.println("插入后的主键=" + order.getId());
        // 查询订单
        Order queryOrder = dao.queryOrder(order.getId());
        // 完善订单
        queryOrder.setTotal_price(200.0);
        queryOrder.setUser_id(2);
        queryOrder.setAddress_id(2);
        dao.update(queryOrder);
    }
}
