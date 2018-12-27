package com.baizhi.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;

@Controller
@RequestMapping("/verificationCode")
public class VerificationCode {

	@RequestMapping("/createCaptcha.do")
	public void createCaptcha(HttpServletResponse response, HttpSession session) throws IOException {
		// 获取验证码随机数
		String securityCode = SecurityCode.getSecurityCode();
		// 把随机数存入 session 作用域
		session.setAttribute("securityCode", securityCode);
		// 生成图片
		BufferedImage image = SecurityImage.createImage(securityCode);
		// 响应到客户端
		ServletOutputStream out = response.getOutputStream();
		
		ImageIO.write(image, "png", out);
	}
}
