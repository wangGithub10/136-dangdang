package com.baizhi.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.ItemDao;
import com.baizhi.entity.Item;
import com.baizhi.service.ItemService;

/**
 * @author wyq
 * @description 订单项功能Service接口实现
 * @日期
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao itemDao;

	@Override
	public void insert(Item item) {
		// 添加订单项
		itemDao.insert(item);
	}
}
