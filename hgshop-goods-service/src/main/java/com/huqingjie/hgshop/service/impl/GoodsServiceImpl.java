package com.huqingjie.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.huqingjie.hgshop.dao.CategoryDao;
import com.huqingjie.hgshop.pojo.Brand;
import com.huqingjie.hgshop.pojo.Category;
import com.huqingjie.hgshop.service.GoodsService;
/**
 * 
 * @ClassName: GoodsServiceImpl 
 * @Description: TODO
 * @author: huqingjie
 * @date: 2020年3月3日 上午9:40:03
 */
@Service(interfaceClass=GoodsService.class)
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	CategoryDao catDao;
	
	@Override
	public int addBrand(Brand brand) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBrand(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<Brand> listBrand(String firstChar, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addCategory(Category category) {
		// TODO Auto-generated method stub
		return catDao.add(category);
	}
 
	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return catDao.update(category);
	}

	@Override
	public int deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		return catDao.delete(id);
	}

	@Override
	public PageInfo<Category> listCategory(String firstChar, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> treeCategory() {
		// TODO Auto-generated method stub
		return catDao.tree();
	}

}
