package com.huqingjie.hgshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @ClassName: BrandController 
 * @Description: TODO
 * @author: lenovo
 * @date: 2020��3��4�� ����3:49:07
 */
@Controller
@RequestMapping("brand")
public class BrandController {
	
	@RequestMapping("list")
	public String list(@RequestParam(defaultValue="1") int page) {
		return "brand/list";
	}

}
