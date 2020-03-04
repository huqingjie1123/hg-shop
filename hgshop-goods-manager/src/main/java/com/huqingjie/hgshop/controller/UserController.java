package com.huqingjie.hgshop.controller;


import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huqingjie.hgshop.service.UserService;

/**
 * .
 * @ClassName: UserController 
 * @Description: TODO
 * @author: lenovo
 * @date: 2020年3月4日 下午3:46:11
 */
@Controller 
public class UserController {
	
	 
	
	@Reference(timeout=2000,version="1.0.0")
	UserService userService;
	
	
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("login")
	public String login(String name,String password ) {
		
		System.out.println("name " + name + " password " + password);
		
		if(userService.login(name, password))
			return "redirect:/";
		else {
			return "login";
		}
	}

}
