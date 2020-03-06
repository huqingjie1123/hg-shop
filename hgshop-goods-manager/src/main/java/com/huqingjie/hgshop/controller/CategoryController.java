package com.huqingjie.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huqingjie.hgshop.pojo.Category;
import com.huqingjie.hgshop.service.GoodsService;

@Controller
@RequestMapping("cat")
public class CategoryController {
	
	@Reference
	GoodsService goodsService;
	
	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		return "cat/list";
	}
	
	@RequestMapping("treeData")
	@ResponseBody
	public List<Category> treeData(HttpServletRequest request) {
		return goodsService.treeCategory();
	}
	
	@ResponseBody
	@RequestMapping("add")
	public String add(HttpServletRequest request,@RequestParam(defaultValue="0") int parentId,String name ) {
		Category category = new Category();
		category.setParentId(parentId);
		category.setName(name);
		
		return goodsService.addCategory(category)>0?"success":"failed";
	}
	
	
	@ResponseBody
	@RequestMapping("del")
	public String del(HttpServletRequest request,@RequestParam(defaultValue="0") int id) {
		
		return goodsService.deleteCategory(id)>0 ?"success":"failed";
		
	}
	
	
	@ResponseBody
	@RequestMapping("update")
	public String update(HttpServletRequest request,Category cat) {
		
		return goodsService.updateCategory(cat)>0 ?"success":"failed";

	}
	

}
