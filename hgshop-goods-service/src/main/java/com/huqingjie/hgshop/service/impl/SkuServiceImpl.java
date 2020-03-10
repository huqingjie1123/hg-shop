package com.huqingjie.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huqingjie.hgshop.dao.SkuDao;
import com.huqingjie.hgshop.pojo.Sku;
import com.huqingjie.hgshop.pojo.SpecOption;
import com.huqingjie.hgshop.service.SkuService;
import com.huqingjie.hgshop.service.SpecService;
@Service(interfaceClass=SkuService.class)
public class SkuServiceImpl implements SkuService {

	@Autowired
	SkuDao skuDao;
	
	@Override
	public PageInfo<Sku> listSku(int page, Sku sku) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		return new PageInfo<Sku>(skuDao.list(sku));
	}

	@Override
	public int addSku(Sku sku) {
		// TODO Auto-generated method stub
		//先加主表
		int cnt = skuDao.addSku(sku);
		List<SpecOption> specs = sku.getSpecs();
		for (SpecOption specOption : specs) {
			cnt += skuDao.addSkuSpec(sku.getId(),specOption);
		}
		
		return cnt;
	}

	@Override
	public Sku getSku(int id) {
		// TODO Auto-generated method stub
		return skuDao.get(id);
	}

	@Override
	public int updateSku(Sku sku) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSku(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSkuBatch(int[] id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
