package com.huqingjie.hgshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huqingjie.hgshop.pojo.Spec;
import com.huqingjie.hgshop.service.SpecService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("spec")
public class SpecController {
	
	@Reference
	SpecService specService;
	
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,
			@RequestParam(defaultValue="1") int page,
			@RequestParam(defaultValue="") String name) {
		
		 PageInfo<Spec> pageInfo = specService.list(name, page);
		 request.setAttribute("pageInfo", pageInfo);
		 
		return "spec/list";
	}
	
	@RequestMapping("add")
	@ResponseBody
	public String add(HttpServletRequest request,Spec spec) {
		
		spec.getOptions().removeIf(x->{return x.getOptionName()==null;});
		
		int add = specService.add(spec);
		
		return add>0?"success":"false";
	}

}
