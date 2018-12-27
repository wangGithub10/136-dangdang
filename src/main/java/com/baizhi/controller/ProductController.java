package com.baizhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baizhi.entity.Product;
import com.baizhi.service.ProductService;

/**
 * @author wyq
 * @description 首页商品展示控制器
 * @日期：
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping("/recommend.do")
	public String recommend(ModelMap modelMap) {
		// 编辑推荐
		List<Product> recommend = productService.recommend();
		modelMap.addAttribute("recommend", recommend);
		return "forward:/main/recommend.jsp";
	}

	@RequestMapping("/hotBook.do")
	public String hotBook(ModelMap modelMap) {
		// 热销图书
		List<Product> hotBook = productService.hotBook();
		modelMap.addAttribute("hotBook", hotBook);
		return "forward:/main/hot.jsp";
	}

	@RequestMapping("/newBook.do")
	public String newBook(ModelMap modelMap) {
		// 新书上架
		List<Product> newBook = productService.newBook();
		modelMap.addAttribute("newBook", newBook);
		return "forward:/main/new.jsp";
	}

	@RequestMapping("/newHotBook.do")
	public String newHotBook(ModelMap modelMap) {
		// 新书热卖
		List<Product> newHotBook = productService.newHotBook();
		modelMap.addAttribute("newHotBook", newHotBook);
		return "forward:/main/hotBoard.jsp";
	}

	@RequestMapping("/queryProduct.do")
	public String queryProduct(ModelMap modelMap, Integer id) {
		// 查询一本图书
		Product product = productService.queryProduct(id);
		modelMap.addAttribute("product", product);
		return "forward:/main/product.jsp";
	}
}
