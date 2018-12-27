package com.baizhi.test;

import com.baizhi.dao.AddressDao;
import com.baizhi.entity.Address;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressDaoTest extends BaseTest {
    @Autowired
    private AddressDao dao;

    @Test
    public void allAddresses() {
        // 查询用户的所有地址
        List<Address> allAddresses = dao.allAddresses(1);
        for (Address address : allAddresses) {
            System.out.println(address);
        }
    }

    @Test
    public void insert() {
        // 添加地址
        Address address = new Address();
        address.setReceive_name("小黑");
        address.setFull_address("北京七号地铁站");
        address.setZipcode("100000");
        address.setReceive_tel("13645347485");
        address.setReceive_phone(null);
        address.setUser_id(1);
        dao.insert(address);
    }

    @Test
    public void queryAddress() {
        // 查询一个地址
        Address address = dao.queryAddress("北京海淀");
        System.out.println(address);
    }

    @Test
    public void update() {
        // 修改地址
        Address address = dao.queryAddress("北京海淀");
        address.setReceive_name("小黑");
        address.setZipcode("111111");
        address.setReceive_tel(null);
        address.setReceive_phone(null);
        dao.update(address);
    }
}
