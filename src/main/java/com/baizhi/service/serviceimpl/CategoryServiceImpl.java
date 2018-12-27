package com.baizhi.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.util.PageBean;

/**
 * @author wyq
 * @description 商品分类Service接口实现
 * @日期：
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Category> primaryClassification(Integer id) {
		// 查询所有类别
		List<Category> primaryClassification = categoryDao.primaryClassification(id);
		return primaryClassification;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Category secondaryClassification(Integer id, Integer idd, PageBean pageBean) {
		// 分类后的图书
		Category secondaryClassification = categoryDao.secondaryClassification(id, idd, pageBean);
		return secondaryClassification;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Integer totalRecord(Integer id, Integer sid) {
		// 数据的总条数
		Integer totalRecord = categoryDao.totalRecord(id, sid);
		return totalRecord;
	}
}
