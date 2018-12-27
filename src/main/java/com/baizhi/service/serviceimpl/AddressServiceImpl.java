package com.baizhi.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.AddressDao;
import com.baizhi.entity.Address;
import com.baizhi.service.AddressService;

/**
 * @author wyq
 * @description 地址功能Service接口实现
 * @日期：
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Address> allAddresses(Integer user_id) {
		// 查询用户的所有地址
		List<Address> allAddresses = addressDao.allAddresses(user_id);
		return allAddresses;
	}

	@Override
	public void insert(Address address) {
		// 添加地址
		addressDao.insert(address);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Address queryAddress(String full_address) {
		// 查询一个地址
		Address address = addressDao.queryAddress(full_address);
		return address;
	}

	@Override
	public void update(Address address) {
		// 修改地址
		addressDao.update(address);
	}
}
