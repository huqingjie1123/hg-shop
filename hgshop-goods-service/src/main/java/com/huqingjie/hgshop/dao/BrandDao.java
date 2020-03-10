package com.huqingjie.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.huqingjie.hgshop.pojo.Brand;

public interface BrandDao {

	List<Brand> list(String name);

	int deleteBrand(Integer id);

	void delBatchs(int[] ids);

	int addBrand(Brand brand);

	Brand findById(int id);

	int updateBrand(Brand brand);
	
	@Select("SELECT id,name,first_char as firstChar "
			+ " FROM hg_brand "
			+ "where deleted_flag=0"
			+ " ORDER BY name ")
	List<Brand> listAll();
	
}
