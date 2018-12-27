package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Category;
import com.baizhi.util.PageBean;

/**
 * @author wyq
 * @description 商品分类Service接口
 * @日期：
 */
public interface CategoryService {
	/**
	 * @description 查询所有类别
	 * @param id  一级分类id
	 * @return List<Category>
	 */
	public List<Category> primaryClassification(Integer id);

	/**
	 * @description 分类后的图书
	 * @param id  一级分类id
	 * @param idd   二级分类id
	 * @param pageBean  分页工具类
	 * @return Category
	 */
	public Category secondaryClassification(Integer id, Integer idd, PageBean pageBean);

	/**
	 * @description 数据的总条数
	 * @return Integer
	 */
	public Integer totalRecord(Integer id, Integer sid);
}
