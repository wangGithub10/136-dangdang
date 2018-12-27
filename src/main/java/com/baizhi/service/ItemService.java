package com.baizhi.service;

import com.baizhi.entity.Item;

/**
 * @author wyq
 * @description 订单项功能Service接口
 * @日期：
 */
public interface ItemService {
	/**
	 * @description 添加订单项
	 * @param item  Item实体类
	 * @return void
	 */
	public void insert(Item item);
}
