package com.huqingjie.hgshop.service;

import com.github.pagehelper.PageInfo;
import com.huqingjie.hgshop.pojo.Sku;

public interface SkuService {

	PageInfo<Sku> listSku(int page, Sku sku);

	int addSku(Sku sku);

	Sku getSku(int id);

	int updateSku(Sku sku);

	int deleteSku(int id);

	int deleteSkuBatch(int[] id);
}
