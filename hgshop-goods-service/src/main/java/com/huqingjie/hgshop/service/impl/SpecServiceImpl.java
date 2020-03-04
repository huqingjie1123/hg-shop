package com.huqingjie.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.huqingjie.hgshop.dao.SpecDao;
import com.huqingjie.hgshop.pojo.Spec;
import com.huqingjie.hgshop.pojo.SpecOption;
import com.huqingjie.hgshop.service.SpecService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @ClassName: SpecServiceImpl 
 * @Description: TODO
 * @author: lenovo
 * @date: 2020年3月4日 下午3:45:11
 */
@Service(interfaceClass=SpecService.class)
public class SpecServiceImpl implements SpecService{
	
	@Autowired
	SpecDao specDao;

	@Override
	public PageInfo<Spec> list(String name, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 3);
		return new PageInfo<Spec>(specDao.list(name));
		
	}

	@Override
	public int add(Spec spec) {
		// TODO Auto-generated method stub
		specDao.addSpec(spec);
		List<SpecOption> options = spec.getOptions();
		//
		int n=1;
		for (SpecOption specOption : options) {
			specOption.setSpecId(spec.getId());
			specDao.addOption(specOption);
			n++;
		}
		
		return n;
	}

	
	@Override
	public int update(Spec spec) {
		// TODO Auto-generated method stub
		return specDao.updateSpec(spec);
	}
	

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		specDao.deleteSpecOtions(id);
		specDao.deleteSpec(id);
		return 1;
	}

	@Override
	public Spec findById(int id) {
		// TODO Auto-generated method stub
		
		return specDao.get(id);
	}

	@Override
	public int deleteBatch(int[] ids) {
		// TODO Auto-generated method stub
		specDao.deleteSpecOtionsBatch(ids);
		specDao.deleteSpecBatch(ids);
		return 1;
	}
	
	

}
