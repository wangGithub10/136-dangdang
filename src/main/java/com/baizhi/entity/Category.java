package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author wyq
 * @description 商品分类表实体类
 * @日期：
 */
public class Category implements Serializable {
	/**
	 * 表id
	 */
	private Integer id;
	/**
	 * 类型名称
	 */
	private String name;
	/**
	 * 分类级别
	 */
	private String category_level;
	/**
	 * 分类数量
	 */
	private Integer goods_count;
	/**
	 * 父级id
	 */
	private Integer parentId;
	/**
	 * 存储二级分类
	 */
	public List<Category> categorys;
	/**
	 * 存储二级分类查到的图书
	 */
	private List<Product> product;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory_level() {
		return category_level;
	}

	public void setCategory_level(String category_level) {
		this.category_level = category_level;
	}

	public Integer getGoods_count() {
		return goods_count;
	}

	public void setGoods_count(Integer goods_count) {
		this.goods_count = goods_count;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name
				+ ", category_level=" + category_level
				+ ", goods_count=" + goods_count + ", parentId="
				+ parentId + ", categorys=" + categorys
				+ ", product=" + product + "]";
	}
}
