package com.baizhi.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.MD5Utils;

/**
 * @author wyq
 * @description 用户功能控制器
 * @日期：
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/queryUser.do")
	@ResponseBody
	public Boolean queryUser(String email) {
		// 查询注册用户是否存在
		User user = userService.queryUser(email);
		if (user==null) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping("/verify.do")
	@ResponseBody
	public Boolean verify(HttpSession session, String code) {
		// 验证码
		String securityCode = (String) session.getAttribute("securityCode");
		// 比较验证码是否一致
		if (securityCode.equalsIgnoreCase(code)) {
			return true;
		}else {
			return false;
		}
	}

	@RequestMapping("/register.do")
	public String register(User user, HttpSession session) {
		// 获取私盐
		String salt = MD5Utils.getSalt();
		// 进行加密
		String password = MD5Utils.getPassword(salt+user.getPassword());
		// 把私盐和加密后的密码存入user对象
		user.setSalt(salt);
		user.setPassword(password);
		// 注册业务
		userService.register(user);
		// 注册完成自动登陆
		User login = userService.login(user.getEmail(), user.getPassword());
		// 向页面发送邮件
		String uuid = UUID.randomUUID().toString().replace("-", "");
		
		// 把需要的数据存session作用域
		session.setAttribute("login", login);
		session.setAttribute("uuid", uuid);
		// redirect跳转
		return "redirect:/user/verify_form.jsp";
	}

	@RequestMapping("/update.do")
	public String update(HttpSession session) {
		// 获取当前用户对象
		User user = (User) session.getAttribute("login");
		// 修改用户状态
		userService.update(user.getId(), 1);
		
		// redirect跳转
		return "redirect:/user/register_ok.jsp";
	}

	@RequestMapping("/login.do")
	public String login(ModelMap modelMap, String email, String password, HttpSession session) {
		// 根据邮箱获取用户信息
		User queryUser = userService.queryUser(email);
		// 判断输入的邮箱是否存在
		if (queryUser!=null) {
			// 获取私盐,把密码加密后进行比较
			String password2 = MD5Utils.getPassword(queryUser.getSalt()+password);
			// 查询用户
			User login = userService.login(email, password2);
			// 判断用密码是否正确
			if (login!=null) {
				// 登陆成功，用户信息存session作用域
				session.setAttribute("login", login);
				return "redirect:/main/main.jsp";
			} else {
				modelMap.addAttribute("error", "Email或者密码输入错误，请重新登录");
				// 登陆失败跳转登陆页面
				return "forward:/user/login_form.jsp";
			}
		} else {
			modelMap.addAttribute("error", "Email或者密码输入错误，请重新登录");
			// 如果查不到用户信息跳转登陆页面
			return "forward:/user/login_form.jsp";
		}
	}

	@RequestMapping("/withdrawFrom.do")
	public String withdrawFrom(HttpSession session) {
		// 安全退出
		session.removeAttribute("login");
		// redirect跳转
		return "redirect:/main/main.jsp";
	}
}
