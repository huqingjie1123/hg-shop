package com.huqingjie.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.huqingjie.hgshop.pojo.Sku;
import com.huqingjie.hgshop.pojo.SpecOption;

/**
 * 
 * @ClassName: SkuDao 
 * @Description: TODO
 * @author: lenovo
 * @date: 2020年3月10日 下午6:52:08
 */
public interface SkuDao {
	
	
	List<Sku> list(Sku sku);
	
	Sku get(int id);
	
	int addSku(Sku sku);
	
	int addSkuSpec(@Param("skuId") int skuId,@Param("so") SpecOption so);
	
}
