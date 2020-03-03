package com.huqingjie.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.huqingjie.hgshop.pojo.Brand;
import com.huqingjie.hgshop.pojo.Category;

/**
 * dubbo �ķ���ӿں�������Ҫ�� ��void����
 * @ClassName: GoodsService 
 * @Description: TODO
 * @author: huqingjie
 * @date: 2020��3��3�� ����9:27:34
 */
public interface GoodsService {
	
	 int addBrand(Brand brand);
	 
	 int updateBrand(Brand brand);
	 
	 int deleteBrand(Integer id);
	 /**
	  * 
	  * @Title: list 
	  * @Description: TODO
	  * @param firstChar ����ĸ
	  * @param page ��ҳ
	  * @return
	  * @return: PageInfo<Brand>
	  */
	 PageInfo<Brand> listBrand(String firstChar,int page);
	 
	 int addCategory(Category category);
	 
	 int updateCategory(Category category);
	 
	 int deleteCategory(Integer id);
	 
	 PageInfo<Category> listCategory(String firstChar,int page);
	 
	 List<Category> treeCategory();
}
