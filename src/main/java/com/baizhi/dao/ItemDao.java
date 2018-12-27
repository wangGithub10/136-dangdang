package com.baizhi.dao;

import com.baizhi.entity.Item;

/**
 * @author wyq
 * @description 订单项功能Dao接口
 * @日期：
 */
public interface ItemDao {
	/**
	 * @description 添加订单项
	 * @param item  Item实体类
	 * @return void
	 */
	public void insert(Item item);
}
