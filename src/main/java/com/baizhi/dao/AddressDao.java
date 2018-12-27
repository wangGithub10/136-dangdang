package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Address;

/**
 * @author wyq
 * @description 地址功能Dao接口
 * @日期：
 */
public interface AddressDao {
	/**
	 * @description 查询用户的所有地址
	 * @param user_id  用户id
	 * @return List<Address>
	 */
	public List<Address> allAddresses(Integer user_id);

	/**
	 * @description 添加地址
	 * @param address  Address实体类
	 * @return void
	 */
	public void insert(Address address);

	/**
	 * @description 查询一个地址
	 * @param full_address  详细地址
	 * @return Address
	 */
	public Address queryAddress(String full_address);

	/**
	 * @description 修改地址
	 * @param address  Address实体类
	 * @return void
	 */
	public void update(Address address);
}
