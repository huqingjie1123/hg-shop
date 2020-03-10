package com.huqingjie.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huqingjie.hgshop.dao.BrandDao;
import com.huqingjie.hgshop.pojo.Brand;
import com.huqingjie.hgshop.service.BrandService;
import com.huqingjie.hgshop.service.GoodsService;
@Service(interfaceClass=BrandService.class)
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	BrandDao brandDao;
	
	@Override
	public PageInfo<Brand> list(String name, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		List<Brand> list = brandDao.list(name);
		PageInfo<Brand> info = new PageInfo<Brand>(list);
		return info;
	}

	@Override
	public int add(Brand brand) {
		// TODO Auto-generated method stub
		return brandDao.addBrand(brand);
	}

	@Override
	public int update(Brand brand) {
		// TODO Auto-generated method stub
		return brandDao.updateBrand(brand);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return brandDao.deleteBrand(id);
	}

	@Override
	public Brand findById(int id) {
		// TODO Auto-generated method stub
		return brandDao.findById(id);
	}

	@Override
	public int deleteBatch(int[] ids) {
		// TODO Auto-generated method stub
		brandDao.delBatchs(ids);
		return 1;
	}

	@Override
	public PageInfo<Brand> listBrand(String firstChar, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Brand> getAllBrands() {
		// TODO Auto-generated method stub
		return brandDao.listAll();
	}

}
