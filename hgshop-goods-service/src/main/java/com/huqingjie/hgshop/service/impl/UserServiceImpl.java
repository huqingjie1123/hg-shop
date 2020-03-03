package com.huqingjie.hgshop.service.impl;

import org.apache.dubbo.config.annotation.Service;

import com.huqingjie.hgshop.service.UserService;
@Service(interfaceClass = UserService.class,version = "1.0.0")
public class UserServiceImpl implements UserService {

	@Override
	public boolean login(String userName, String password) {
		return "admin".equals(userName) && "123456".equals(password);
	}

}
