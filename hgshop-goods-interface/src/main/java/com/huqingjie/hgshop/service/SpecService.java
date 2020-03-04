package com.huqingjie.hgshop.service;

import com.huqingjie.hgshop.pojo.Spec;
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
	
	int add(Spec spec);
	
	int update(Spec spec);
	
	int delete(int id);
	
	Spec findById(int id);
	
	int deleteBatch(int[] id);

}
