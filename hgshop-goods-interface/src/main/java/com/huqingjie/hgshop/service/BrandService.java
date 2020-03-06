package com.huqingjie.hgshop.service;

import com.github.pagehelper.PageInfo;
import com.huqingjie.hgshop.pojo.Brand;

public interface BrandService {
	
	PageInfo<Brand> list(String name,int page);
	
	int add(Brand brand);
	
	int update(Brand brand);
	
	int delete(int id);
	
	Brand findById(int id);
	
	int deleteBatch(int[] ids);
	
}
