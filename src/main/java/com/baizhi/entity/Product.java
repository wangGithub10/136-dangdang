package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wyq
 * @description 商品信息表实体类
 * @日期：
 */
public class Product implements Serializable {
	/**
	 * 表id
	 */
	private Integer id;
	/**
	 * 书名
	 */
	private String book_name;
	/**
	 * 图片名
	 */
	private String img_name;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 出版社
	 */
	private String publishing;
	/**
	 * 出版时间
	 */
	private Date publish_time;
	/**
	 * 版次
	 */
	private Integer which_edtion;
	/**
	 * 印刷时间
	 */
	private Date print_time;
	/**
	 * 印次
	 */
	private Integer print_number;
	/**
	 * ISBN
	 */
	private String isbn;
	/**
	 * 字数
	 */
	private Integer word_number;
	/**
	 * 页数
	 */
	private Integer total_page;
	/**
	 * 开本
	 */
	private String format;
	/**
	 * 纸张
	 */
	private String paper;
	/**
	 * 包装
	 */
	private String packing;
	/**
	 * 定价
	 */
	private Double price;
	/**
	 * 当当价
	 */
	private Double dang_price;
	/**
	 * 编辑推荐
	 */
	private String recommend;
	/**
	 * 内容简介
	 */
	private String content_introduct;
	/**
	 * 作者简介
	 */
	private String author_summary;
	/**
	 * 目录
	 */
	private String catalog;
	/**
	 * 媒体评论
	 */
	private String media_comment;
	/**
	 * 书摘插图
	 */
	private String excerpt;
	/**
	 * 点击量
	 */
	private Integer click_rate;
	/**
	 * 销量
	 */
	private Integer sales_volumn;
	/**
	 * 上架时间
	 */
	private Date shelf_time;
	/**
	 * 分类编号
	 */
	private Integer category_id;
	/**
	 * 购物车数量
	 */
	private Integer quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	public Date getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}

	public Integer getWhich_edtion() {
		return which_edtion;
	}

	public void setWhich_edtion(Integer which_edtion) {
		this.which_edtion = which_edtion;
	}

	public Date getPrint_time() {
		return print_time;
	}

	public void setPrint_time(Date print_time) {
		this.print_time = print_time;
	}

	public Integer getPrint_number() {
		return print_number;
	}

	public void setPrint_number(Integer print_number) {
		this.print_number = print_number;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getWord_number() {
		return word_number;
	}

	public void setWord_number(Integer word_number) {
		this.word_number = word_number;
	}

	public Integer getTotal_page() {
		return total_page;
	}

	public void setTotal_page(Integer total_page) {
		this.total_page = total_page;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getPaper() {
		return paper;
	}

	public void setPaper(String paper) {
		this.paper = paper;
	}

	public String getPacking() {
		return packing;
	}

	public void setPacking(String packing) {
		this.packing = packing;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDang_price() {
		return dang_price;
	}

	public void setDang_price(Double dang_price) {
		this.dang_price = dang_price;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getContent_introduct() {
		return content_introduct;
	}

	public void setContent_introduct(String content_introduct) {
		this.content_introduct = content_introduct;
	}

	public String getAuthor_summary() {
		return author_summary;
	}

	public void setAuthor_summary(String author_summary) {
		this.author_summary = author_summary;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getMedia_comment() {
		return media_comment;
	}

	public void setMedia_comment(String media_comment) {
		this.media_comment = media_comment;
	}

	public String getExcerpt() {
		return excerpt;
	}

	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}

	public Integer getClick_rate() {
		return click_rate;
	}

	public void setClick_rate(Integer click_rate) {
		this.click_rate = click_rate;
	}

	public Integer getSales_volumn() {
		return sales_volumn;
	}

	public void setSales_volumn(Integer sales_volumn) {
		this.sales_volumn = sales_volumn;
	}

	public Date getShelf_time() {
		return shelf_time;
	}

	public void setShelf_time(Date shelf_time) {
		this.shelf_time = shelf_time;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", book_name=" + book_name
				+ ", img_name=" + img_name + ", author=" + author
				+ ", publishing=" + publishing + ", publish_time="
				+ publish_time + ", which_edtion=" + which_edtion
				+ ", print_time=" + print_time + ", print_number="
				+ print_number + ", isbn=" + isbn
				+ ", word_number=" + word_number + ", total_page="
				+ total_page + ", format=" + format + ", paper="
				+ paper + ", packing=" + packing + ", price="
				+ price + ", dang_price=" + dang_price
				+ ", recommend=" + recommend
				+ ", content_introduct=" + content_introduct
				+ ", author_summary=" + author_summary
				+ ", catalog=" + catalog + ", media_comment="
				+ media_comment + ", excerpt=" + excerpt
				+ ", click_rate=" + click_rate + ", sales_volumn="
				+ sales_volumn + ", shelf_time=" + shelf_time
				+ ", category_id=" + category_id + ", quantity="
				+ quantity + "]";
	}
}
