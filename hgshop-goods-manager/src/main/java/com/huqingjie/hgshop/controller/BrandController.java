package com.huqingjie.hgshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.huqingjie.hgshop.pojo.Brand;
import com.huqingjie.hgshop.pojo.Spec;
import com.huqingjie.hgshop.service.BrandService;

/**
 * 
 * @ClassName: BrandController 
 * @Description: TODO
 * @author: lenovo
 * @date: 2020年3月4日 下午3:49:07
 */
@Controller
@RequestMapping("brand")
public class BrandController {
	
	@Reference
	BrandService brandService; 
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="") String name) {
		
		PageInfo<Brand> pageInfo = brandService.list(name, page);
		request.setAttribute("pageInfo", pageInfo);
		 
		return "brand/list";
	}
	@RequestMapping("delBrand")
	@ResponseBody
	public String delBrand(HttpServletRequest request,int id) {
		//调用服务
		int delNum = brandService.delete(id);
		return delNum>0?"true":"false";
	}
	
	@RequestMapping("delBatchs")
	@ResponseBody
	public String delSpecBatch(HttpServletRequest request,@RequestParam(name="ids[]") int[] ids) {
		int delNum = brandService.deleteBatch(ids);
		return delNum>0?"true":"false";
	}
	
	@ResponseBody
	@RequestMapping("add")
	public Object add(HttpServletRequest request,Brand brand) {
		//调用服务
		int add = brandService.add(brand);
		return add>0?"true":"false";
	}
	
	@RequestMapping("getBrand")
	@ResponseBody
	public Brand getBrand(HttpServletRequest request, int id){
		return brandService.findById(id);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public String update(HttpServletRequest request,Brand brand) {
		int result = brandService.update(brand);  
		return result >0 ?"success":"false";
	}
	
	

}
