package com.huqingjie.hgshop.dao;

import java.util.List;

import com.huqingjie.hgshop.pojo.Spec;
import com.huqingjie.hgshop.pojo.SpecOption;

/**
 * 
 * @ClassName: SpecDao 
 * @Description: TODO
 * @author: lenovo
 * @date: 2020年3月4日 下午3:44:00
 */
public interface SpecDao {

	List<Spec> list(String name);

	int addSpec(Spec spec);

	int addOption(SpecOption specOption);

	int updateSpec(Spec spec);

	int deleteSpecOtions(int id);

	int deleteSpec(int id);

	Spec get(int id);

	int deleteSpecOtionsBatch(int[] ids);

	int deleteSpecBatch(int[] ids);
	
	List<Spec> listAll();
	
	
}
