package com.huqingjie.hgshop.dao;

import java.util.List;

import com.huqingjie.hgshop.pojo.Category;

/**
 * 
 * @ClassName: CategoryDao 
 * @Description: TODO
 * @author: lenovo
 * @date: 2020��3��6�� ����10:17:11
 */
public interface CategoryDao {
	 // ��
	 List<Category> tree();
	 
	 int add(Category category);

	 int delete(Integer id);

	 int update(Category category);
	 
	 
	 
}
