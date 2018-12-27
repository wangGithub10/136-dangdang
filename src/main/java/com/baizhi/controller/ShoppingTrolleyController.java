package com.baizhi.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baizhi.entity.Product;
import com.baizhi.service.ProductService;

/**
 * @author wyq
 * @description 购物车功能控制器
 * @日期：
 */
@Controller
@RequestMapping("/shoppingTrolley")
public class ShoppingTrolleyController {
	@Autowired
	public ProductService productService; 

	@RequestMapping("/purchase.do")
	@ResponseBody
	public Integer purchase(HttpSession session, Integer id) {
		Product product = productService.queryProduct(id);
		
		// 购物车
		Map<Integer, Product> map = (Map<Integer, Product>) session.getAttribute("map");
		// 恢复区
		Map<Integer, Product> map2 = (Map<Integer, Product>) session.getAttribute("map2");
		
		// 判断恢复区是否存在
		if (map2 != null) {
			// 先查找恢复区是否有这本书
			if (map2.containsKey(id)) {
				// 判断购物车是否存在
				if (map != null) {
					// 如有在原有数量上加1
					Product product3 = map2.get(id);
					// 判断数量是否超越最大值
					if (product3.getQuantity()>=9999) {
						// 超越最大值不进行加1
						product3.setQuantity(9999);
					} else {
						// 没超最大值加1
						product3.setQuantity(product3.getQuantity()+1);
					}
					// 把书放回购物车
					map.put(id, product3);
					// 删除恢复区的图书
					map2.remove(id);
					// 判断恢复区还有没有图书，如没有清除恢复区
					if (map2.size()==0) {session.removeAttribute("map2");}
					// 存入session作用域
					session.setAttribute("map", map);
				} else {
					// 不存在创建购物车
					Map<Integer, Product> mapk = new HashMap<Integer, Product>();
					// 如有在原有数量上加1
					Product product3 = map2.get(id);
					// 判断数量是否超越最大值
					if (product3.getQuantity()>=9999) {
						// 超越最大值不进行加1
						product3.setQuantity(9999);
					} else {
						// 没超最大值加1
						product3.setQuantity(product3.getQuantity()+1);
					}
					// 把书放回购物车
					mapk.put(id, product3);
					// 删除恢复区的图书
					map2.remove(id);
					// 判断恢复区还有没有图书，如没有清除恢复区
					if (map2.size()==0) {session.removeAttribute("map2");}
					// 存入session作用域
					session.setAttribute("map", mapk);
				}
			}
		} else {
		
		// 如果恢复区没有则在购物车添加一本新的，如果购物车存在，则数量增加
		
		// 判断购物车是否存在
		if (map != null) {
			// 现判断购物车是否存在这本书
			if (map.containsKey(id)) {
				// 如果购物车存在，则数量增加
				Product product2 = map.get(id);
				// 判断数量是否超越最大值
				if (product2.getQuantity()>=9999) {
					// 超越最大值不进行加1
					product2.setQuantity(9999);
				} else {
					// 没超最大值加1
					product2.setQuantity(product2.getQuantity()+1);
				}
				map.put(id, product2);
				// 存入session作用域
				session.setAttribute("map", map);
			} else {
				// 如果没有添加一本新的
				product.setQuantity(1);
				map.put(id, product);
				// 存入session作用域
				session.setAttribute("map", map);
			}
		} else {
			// 不存在创建购物车
			Map<Integer, Product> mapk = new HashMap<Integer, Product>();
			// 把商品添加进去
			product.setQuantity(1);
			mapk.put(id, product);
			// 存入session作用域
			session.setAttribute("map", mapk);
		}
		
		
		}
		return 1;
	}
	
	@RequestMapping("/showAll.do")
	public String showAll(ModelMap modelMap, HttpSession session) {
		Map<Integer, Product> map = (Map<Integer, Product>) session.getAttribute("map");
		// 判断集合是否存在
		if (map != null) {
			// 定价总价
			Double totalPrice = 0D;
			// 当当价格总价
			Double totalDangPrice = 0D;
			// 获取map的key
			Set<Integer> keys = map.keySet();
			// 计算价格
			for (Integer key : keys) {
				Product product = map.get(key);
				totalPrice += product.getPrice()*product.getQuantity();
				totalDangPrice += product.getDang_price()*product.getQuantity();		
			}
			// 优惠多少
			Double fold = totalPrice-totalDangPrice;
			// 总价
			session.setAttribute("totalDangPrice", totalDangPrice);
			// 优惠多少
			modelMap.addAttribute("fold", fold);
		}
		
		return "forward:/cart/cart_list.jsp";
	}
	
	@RequestMapping("/updateQuantity.do")
	public String updateQuantity(HttpSession session, Integer id, String quantity) {
		// 购物车map
		Map<Integer, Product> map = (Map<Integer, Product>) session.getAttribute("map");
		
		// 如果值不为空
		if (quantity != "") {
			// 正则表达式
			String regex = "^[0-9]{1,4}$";
			// 判断输入的数量合法性
			if (quantity.matches(regex)) {
				// 取出图书
				Product product = map.get(id);
				// 修改数量
				product.setQuantity(Integer.parseInt(quantity));
				// 存入map
				map.put(id, product);
				// 存入session作用域
				session.setAttribute("map", map);
			} else {
				// 取出图书
				Product product = map.get(id);
				// 修改数量
				product.setQuantity(1);
				// 存入map
				map.put(id, product);
				// 存入session作用域
				session.setAttribute("map", map);
			}
		} else {
			// 取出图书
			Product product = map.get(id);
			// 修改数量
			product.setQuantity(1);
			// 存入map
			map.put(id, product);
			// 存入session作用域
			session.setAttribute("map", map);
		}
		
		return "redirect:/shoppingTrolley/showAll.do";
	}
	
	@RequestMapping("/delete.do")
	public String delete(HttpSession session, Integer id) {
		// 购物车map
		Map<Integer, Product> map = (Map<Integer, Product>) session.getAttribute("map");
		// 恢复区map
		Map<Integer, Product> map2 = (Map<Integer, Product>) session.getAttribute("map2");
		
		// 把要删除的对象取出来
		Product product = map.get(id);
		// 判断恢复区map是否存在
		if (map2 != null) {
			// 把值取出来存到恢复区，并在购物车删除
			map2.put(id, product);
			map.remove(id);
			// 判断购物车是否还有数据，没有删除购物车
			if (map.size()==0) {session.removeAttribute("map");}
			// 把恢复区map存入session作用域
			session.setAttribute("map2", map2);
		} else {
			// 如果没有创建恢复区map
			Map<Integer, Product> mapk = new HashMap<Integer, Product>();
			// 把要删除的值存入恢复区，并在购物车删除
			mapk.put(id, product);
			map.remove(id);
			// 判断购物车是否还有数据，没有删除购物车
			if (map.size()==0) {session.removeAttribute("map");}
			// 把恢复区map存入session作用域
			session.setAttribute("map2", mapk);
		}
		
		return "redirect:/shoppingTrolley/showAll.do";
	}
	
	@RequestMapping("/restore.do")
	public String restore(HttpSession session, Integer id) {
		// 购物车map
		Map<Integer, Product> map = (Map<Integer, Product>) session.getAttribute("map");
		// 恢复区map
		Map<Integer, Product> map2 = (Map<Integer, Product>) session.getAttribute("map2");
		
		if (map != null) {
			// 查询图书
			Product product3 = map2.get(id);
			// 把书放回购物车
			map.put(id, product3);
			// 删除恢复区的图书
			map2.remove(id);
			// 判断恢复区还有没有图书，如没有清除恢复区
			if (map2.size()==0) {session.removeAttribute("map2");}
			// 存入session作用域
			session.setAttribute("map", map);
		} else {
			// 不存在创建购物车
			Map<Integer, Product> mapk = new HashMap<Integer, Product>();
			//  查询图书
			Product product3 = map2.get(id);
			// 把书放回购物车
			mapk.put(id, product3);
			// 删除恢复区的图书
			map2.remove(id);
			// 判断恢复区还有没有图书，如没有清除恢复区
			if (map2.size()==0) {session.removeAttribute("map2");}
			// 存入session作用域
			session.setAttribute("map", mapk);
		}
		
		return "redirect:/shoppingTrolley/showAll.do";
	}
}
