package com.baizhi.dao;

import com.baizhi.entity.Category;
import com.baizhi.util.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wyq
 * @description 商品分类Dao接口
 * @日期：
 */
public interface CategoryDao {
	/**
	 * @description 查询所有类别
	 * @param id  一级分类id
	 * @return List<Category>
	 */
	public List<Category> primaryClassification(@Param("id") Integer id);

	/**
	 * @description 分类后的图书
	 * @param id  一级分类id
	 * @param sid   二级分类id
	 * @param pageBean  分页工具类
	 * @return Category
	 */
	public Category secondaryClassification(@Param("id") Integer id, @Param("sid") Integer sid, @Param("pageBean") PageBean pageBean);

	/**
	 * @description 数据的总条数
	 * @return Integer
	 */
	public Integer totalRecord(@Param("id") Integer id, @Param("sid") Integer sid);
}
