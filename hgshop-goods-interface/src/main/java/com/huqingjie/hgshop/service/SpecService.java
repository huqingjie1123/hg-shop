package com.huqingjie.hgshop.service;

import com.huqingjie.hgshop.pojo.Spec;

import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * 
 * @ClassName: SpecService 
 * @Description: TODO
 * @author: lenovo
 * @date: 2020年3月4日 下午3:42:42
 */
public interface SpecService {
	
	PageInfo<Spec> list(String name,int page);
	
	/**
	 * 获取所有的规格名称
	 * @param name
	 * @param page
	 * @return
	 */
	List<Spec> listAll();
	
	int add(Spec spec);
	
	int update(Spec spec);
	
	int delete(int id);
	
	Spec findById(int id);
	
	int deleteBatch(int[] id);

}
