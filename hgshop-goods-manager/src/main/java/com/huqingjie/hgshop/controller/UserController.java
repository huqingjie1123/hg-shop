package com.huqingjie.hgshop.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huqingjie.hgshop.service.UserService;

@Controller
public class UserController {
	
	@Reference(timeout = 2000,version = "1.0.0")
	UserService userServcie;

	@RequestMapping("tologin")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("login")
	public String login(String name,String password) {
	
		System.out.println("name "+name+"password "+password);

		if (userServcie.login(name, password)) {
			return "redirect:/";
		}else {
			return "login";
		}
	}
	
	
	
}
