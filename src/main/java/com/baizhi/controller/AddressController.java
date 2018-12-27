package com.baizhi.controller;

import com.baizhi.entity.*;
import com.baizhi.service.AddressService;
import com.baizhi.service.ItemService;
import com.baizhi.service.OrderService;
import com.baizhi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wyq
 * @description 地址功能控制器
 * @日期：
 */
@Controller
@RequestMapping("/address")
public class AddressController {
	@Autowired
	public AddressService addressService;
	@Autowired
	public OrderService orderService;
	@Autowired
	public ItemService itemService;
	@Autowired
	public ProductService productService;

	@RequestMapping("/allAddresses.do")
	public String allAddresses(ModelMap modelMap, Integer user_id) {
		// 获取用户地址
		List<Address> allAddresses = addressService.allAddresses(user_id);
		// 存入request作用域
		modelMap.addAttribute("allAddresses", allAddresses);
		// forward跳转
		return "forward:/order/address_form.jsp";
	}

	@RequestMapping("/queryAddress.do")
	@ResponseBody
	public Address queryAddress(String full_address) {
		// 查询一个地址是否已存在
		Address address = addressService.queryAddress(full_address);
		// 返回地址
		return address;
	}

	@RequestMapping("/insert.do")
	public String insert(ModelMap modelMap,HttpSession session, Address address) {
		// 查询地址
		Address queryAddress = addressService.queryAddress(address.getFull_address());
		// 获取用户id
		User user = (User) session.getAttribute("login");
		// 判断数据库是否有这个地址
		if (queryAddress==null) {
			// 如果电话或手机号每填把值致null
			if(address.getReceive_tel()==""){address.setReceive_tel(null);}
			if(address.getReceive_phone()==""){address.setReceive_phone(null);}
			// 把用户id存入地址信息里
			address.setUser_id(user.getId());
			// 如果没有，调用创建新地址业务
			addressService.insert(address);
			// 查询地址
			Address queryAddress2 = addressService.queryAddress(address.getFull_address());
			// 把地址存入request作用域
			modelMap.addAttribute("address", queryAddress2);
			return "forward:/address/order.do";
		} else {
			// 如果电话或手机号每填把值致null
			if(address.getReceive_tel()==""){address.setReceive_tel(null);}
			if(address.getReceive_phone()==""){address.setReceive_phone(null);}
			// 更新地址信息
			queryAddress.setReceive_name(address.getReceive_name());
			queryAddress.setZipcode(address.getZipcode());
			queryAddress.setReceive_tel(address.getReceive_tel());
			queryAddress.setReceive_phone(address.getReceive_phone());
			// 如果有，调用修改业务
			addressService.update(queryAddress);
			// 查询地址
			Address queryAddress2 = addressService.queryAddress(address.getFull_address());
			// 把地址存入request作用域
			modelMap.addAttribute("address", queryAddress2);
			return "forward:/address/order.do";
		}
	}

	@RequestMapping("/order.do")
	public String order(HttpSession session, HttpServletRequest request, ModelMap modelMap) {
		/*
		 * 一、创建订单
		 * 	1.调用创建订单业务
		 * 	2.再把订单的信息查出来
		 * 二、把购买的商品存入数据库
		 * 	1.遍历map取出商品信息
		 * 	2.调用添加订单项业务，把商品添加进去
		 * 	3.调用商品修改业务，把商品的销量 修改
		 * 三、清空购物车
		 * 	1.把session作用域的购物车集合清除
		 * 	2.session的总价暂不删除
		 */
		
		// 创建订单
		Order order = new Order();
		orderService.insert(order);
		
		// 查询出购物车的商品
		Map<Integer, Product> map = (Map<Integer, Product>) session.getAttribute("map");
		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			Product product = map.get(key);
			Item item = new Item();
			// 订单id
			item.setOrder_id(order.getId());
			// 商品id
			item.setProduct_id(product.getId());
			// 商品名称
			item.setProduct_name(product.getBook_name());
			// 商品折扣价
			item.setDang_price(product.getDang_price());
			// 商品数量
			item.setProduct_num(product.getQuantity());
			// 商品小计
			item.setAmount(product.getDang_price()*product.getQuantity());
			// 添加订单项
			itemService.insert(item);
			// 查询商品信息
			Product queryProduct = productService.queryProduct(product.getId());
			// 修改商品的销量
			productService.update(product.getId(), queryProduct.getSales_volumn()+product.getQuantity());
		}
		
		// 获取完善订单需要的信息
		Double totalDangPrice = (Double) session.getAttribute("totalDangPrice");
		User user = (User) session.getAttribute("login");
		Address address = (Address) request.getAttribute("address");
		
		// 查询订单
		Order queryOrder = orderService.queryOrder(order.getId());
		// 完善订单
		queryOrder.setTotal_price(totalDangPrice);
		queryOrder.setUser_id(user.getId());
		queryOrder.setAddress_id(address.getId());
		orderService.update(queryOrder);
		
		// 清空购物车和总价
		session.removeAttribute("map");
		session.removeAttribute("totalDangPrice");
		
		// 查询完整订单信息，向后传递
		Order queryOrder2 = orderService.queryOrder(queryOrder.getId());
		modelMap.addAttribute("order", queryOrder2);
		
		return "forward:/order/order_ok.jsp";
	}
}
