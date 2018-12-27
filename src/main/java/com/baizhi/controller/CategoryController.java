package com.baizhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.util.PageBean;

/**
 * @author Helpless boy
 * @description 商品分类展示控制器
 * @日期：
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/primaryClassification.do")
	public String primaryClassification(ModelMap modelMap) {
		// 查询所有类别
		List<Category> primaryClassification = categoryService.primaryClassification(0);
		modelMap.addAttribute("primaryClassification", primaryClassification);
		return "forward:/main/category.jsp";
	}

	@RequestMapping("/secondaryClassification.do")
	public String secondaryClassification(ModelMap modelMap, Integer id, @RequestParam(required=false, defaultValue = "0")Integer sid, @RequestParam(required = false, defaultValue = "1") Integer pageNum) {
		// 分类后的图书
		Integer totalRecord = categoryService.totalRecord(id, sid);
		// 根据收的参数进行分页
		PageBean pageBean = new PageBean(pageNum, 5, totalRecord);
		// 查询到的图书分类的信息
		List<Category> primaryClassification = categoryService.primaryClassification(id);
		// 分类后的图书
		Category secondaryClassification = categoryService .secondaryClassification(id, sid, pageBean);
		// 把需要的值传入request作用域
		modelMap.addAttribute("pageBean", pageBean);
		modelMap.addAttribute("primaryClassification", primaryClassification);
		modelMap.addAttribute("secondaryClassification", secondaryClassification);
		modelMap.addAttribute("id", id);
		modelMap.addAttribute("sid", sid);
		return "forward:/main/book_list.jsp";
	}
}
