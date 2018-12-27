package com.baizhi.test;

import com.baizhi.entity.Order;
import com.baizhi.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderSerivceTest extends BaseTest {
    @Autowired
    private OrderService service;

    @Test
    public void insert() {
        // 生成订单
        Order order = new Order();
        service.insert(order);
        System.out.println("插入后的主键=" + order.getId());
        // 查询订单
        Order queryOrder = service.queryOrder(order.getId());
        // 完善订单
        queryOrder.setTotal_price(200.0);
        queryOrder.setUser_id(2);
        queryOrder.setAddress_id(2);
        service.update(queryOrder);
    }
}
