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
	/**
	 * 列表展示
	 * @Title: list 
	 * @Description: TODO
	 * @param request
	 * @param page
	 * @param name
	 * @return
	 * @return: String
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request,
			@RequestParam(defaultValue="1") int page,
			@RequestParam(defaultValue="") String name) {
		
		 PageInfo<Spec> pageInfo = specService.list(name, page);
		 request.setAttribute("pageInfo", pageInfo);
		 
		return "spec/list";
	}
	/**
	 * 添加
	 * @Title: add 
	 * @Description: TODO
	 * @param request
	 * @param spec
	 * @return
	 * @return: String
	 */
	@ResponseBody
	@RequestMapping("add")
	public String add(HttpServletRequest request,Spec spec) {
		
		spec.getOptions().removeIf(x->{return x.getOptionName()==null;});
		
		int add = specService.add(spec);
		
		return add>0?"success":"false";
	}
	
	@ResponseBody
	@RequestMapping("update")
	public String update(HttpServletRequest request,Spec spec) {

		spec.getOptions().removeIf(x->{return x.getOptionName()==null;});
		
		int result = specService.update(spec);  
		
		return result >0 ?"success":"false";
	}
	
	/**
	 * 回显
	 * @Title: getSpec 
	 * @Description: TODO
	 * @param request
	 * @param id
	 * @return
	 * @return: Spec
	 */
	@ResponseBody
	@RequestMapping("getSpec")
	public Spec getSpec(HttpServletRequest request, int id){
		
		return specService.findById(id);
		
	}
	/**
	 * 删除规格
	 * @Title: delSpec 
	 * @Description: TODO
	 * @param request
	 * @param id
	 * @return
	 * @return: String
	 */
	@ResponseBody
	@RequestMapping("delSpec")
	public String delSpec(HttpServletRequest request,int id) {
		
		int delNum = specService.delete(id);
		
		return delNum>0?"success":"false";
	}
	
	/**
	 * 删除规格
	 * @Title: delSpecBatch 
	 * @Description: TODO
	 * @param request
	 * @param ids
	 * @return
	 * @return: String
	 */
	@ResponseBody
	@RequestMapping("delSpecBatch")
	public String delSpecBatch(HttpServletRequest request,@RequestParam(name="ids[]") int[] ids) {

		
		int delNum = specService.deleteBatch(ids);
		
		return delNum>0?"success":"false";
	}

}
