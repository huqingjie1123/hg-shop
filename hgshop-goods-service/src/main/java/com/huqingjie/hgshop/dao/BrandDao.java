package com.huqingjie.hgshop.dao;

import java.util.List;

import com.huqingjie.hgshop.pojo.Brand;

public interface BrandDao {

	List<Brand> list(String name);

	int deleteBrand(Integer id);

	void delBatchs(int[] ids);

	int addBrand(Brand brand);

	Brand findById(int id);

	int updateBrand(Brand brand);

}
