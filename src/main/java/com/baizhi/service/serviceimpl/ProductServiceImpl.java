package com.baizhi.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.ProductDao;
import com.baizhi.entity.Product;
import com.baizhi.service.ProductService;

/**
 * @author wyq
 * @description 首页书籍展示Service接口实现
 * @日期：
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Product> recommend() {
		// 编辑推荐
		List<Product> recommend = productDao.recommend();
		return recommend;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Product> hotBook() {
		// 热销图书
		List<Product> hotBook = productDao.hotBook();
		return hotBook;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Product> newBook() {
		// 新书上架
		List<Product> newBook = productDao.newBook();
		return newBook;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Product> newHotBook() {
		// 新书热卖
		List<Product> newHotBook = productDao.newHotBook();
		return newHotBook;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Product queryProduct(Integer id) {
		// 查询一本图书
		Product product = productDao.queryProduct(id);
		return product;
	}

	@Override
	public void update(Integer id, Integer sales_volumn) {
		// 修改商品的销量
		productDao.update(id, sales_volumn);
	}
}
