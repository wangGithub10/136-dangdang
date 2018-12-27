package com.baizhi.test;

import com.baizhi.entity.Address;
import com.baizhi.service.AddressService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressServiceTest extends BaseTest {
    @Autowired
    private AddressService service;

    @Test
    public void allAddresses() {
        // 查询用户的所有地址
        List<Address> allAddresses = service.allAddresses(1);
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
        service.insert(address);
    }

    @Test
    public void queryAddress() {
        // 查询一个地址
        Address address = service.queryAddress("北京昌平");
        System.out.println(address);
    }

    @Test
    public void update() {
        // 修改地址
        Address address = service.queryAddress("北京海淀");
        address.setReceive_name("小黑");
        address.setZipcode("111111");
        address.setReceive_tel(null);
        address.setReceive_phone(null);
        service.update(address);
    }
}
