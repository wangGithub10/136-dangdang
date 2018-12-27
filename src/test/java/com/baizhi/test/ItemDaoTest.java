package com.baizhi.test;

import com.baizhi.dao.ItemDao;
import com.baizhi.entity.Item;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemDaoTest extends BaseTest {
    @Autowired
    private ItemDao dao;

    @Test
    public void Insert() {
        // 添加订单项
        Item item = new Item();
        item.setOrder_id(1);
        item.setProduct_id(16);
        item.setProduct_name("一个陌生女人的来信");
        item.setDang_price(180.0);
        item.setProduct_num(10);
        item.setAmount(1800.0);
        dao.insert(item);
    }
}
