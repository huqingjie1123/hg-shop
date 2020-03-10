package com.huqingjie.hgshop.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huqingjie.hgshop.dao.SpuDao;
import com.huqingjie.hgshop.pojo.Spu;
import com.huqingjie.hgshop.pojo.SpuVo;
import com.huqingjie.hgshop.service.SpecService;
import com.huqingjie.hgshop.service.SpuService;
@Service(interfaceClass=SpuService.class)
public class SpuServiceImpl implements SpuService {

	@Autowired
	SpuDao spuDao;

	// spuµÄÁÐ±í
	@Override
	public PageInfo<Spu> listSpu(int page, SpuVo vo) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);

		return new PageInfo<Spu>(spuDao.list(vo));
	}

	@Override
	public int addSpu(Spu spu) {

		int cnt = spuDao.add(spu);
		return cnt;

	}

	@Override
	public int updateSpu(Spu spu) {
		// TODO Auto-generated method stub
		return spuDao.update(spu);
	}

	@Override
	public int deleteSpu(int id) {
		// TODO Auto-generated method stub
		return spuDao.delete(id);
	}

	@Override
	public Spu getSpu(int id) {
		// TODO Auto-generated method stub
		return spuDao.findById(id);
	}

	@Override
	public int deleteSpuBatch(int[] ids) {
		// TODO Auto-generated method stub
		return spuDao.deleteSpuBatch(ids);
	}

}
