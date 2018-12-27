package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Product;

/**
 * @author wyq
 * @description 首页书籍的展示Dao接口
 * @日期：
 */
public interface ProductDao {
	/**
	 * @description 编辑推荐
	 * @return List<Product>
	 */
	public List<Product> recommend();

	/**
	 * @description 热销图书
	 * @return List<Product>
	 */
	public List<Product> hotBook();

	/**
	 * @description 新书上架
	 * @return List<Product>
	 */
	public List<Product> newBook();

	/**
	 * @description 新书热卖
	 * @return List<Product>
	 */
	public List<Product> newHotBook();

	/**
	 * @description 查询一本图书
	 * @param id 商品表id
	 * @return Product
	 */
	public Product queryProduct(Integer id);

	/**
	 * @description 修改商品的销量
	 * @param id  商品表编号
	 * @param sales_volumn  商品销量
	 * @return void
	 */
	public void update(@Param("id") Integer id, @Param("sales_volumn") Integer sales_volumn);
}
