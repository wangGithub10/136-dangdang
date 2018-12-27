package com.baizhi.test;

import com.baizhi.entity.Item;
import com.baizhi.service.ItemService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemServiceTest extends BaseTest {
    @Autowired
    private ItemService service;

    @Test
    public void Insert() {
        // 添加订单项
        Item item = new Item();
        item.setOrder_id(1);
        item.setProduct_id(1);
        item.setProduct_name("床边的小豆豆");
        item.setDang_price(180.0);
        item.setProduct_num(100);
        item.setAmount(18000.0);
        service.insert(item);
    }
}
