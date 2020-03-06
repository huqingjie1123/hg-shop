package com.huqingjie.hgshop.dao;

import java.util.List;

import com.huqingjie.hgshop.pojo.Category;

/**
 * 
 * @ClassName: CategoryDao 
 * @Description: TODO
 * @author: lenovo
 * @date: 2020年3月6日 上午10:17:11
 */
public interface CategoryDao {
	 // 树
	 List<Category> tree();
	 
	 int add(Category category);

	 int delete(Integer id);

	 int update(Category category);
	 
	 
	 
}
