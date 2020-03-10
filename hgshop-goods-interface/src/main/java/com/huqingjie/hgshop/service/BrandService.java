package com.huqingjie.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.huqingjie.hgshop.pojo.Brand;

public interface BrandService {
	
	PageInfo<Brand> list(String name,int page);
	
	int add(Brand brand);
	
	int update(Brand brand);
	
	int delete(int id);
	
	Brand findById(int id);
	
	int deleteBatch(int[] ids);
	
	/**
	 * 
	 * @param firstChar Ê××ÖÄ¸
	 * @param page Ò³Âë
	 * @return
	 */
	PageInfo<Brand> listBrand( String firstChar,int page); 
	
	List<Brand> getAllBrands(); 
	
}
