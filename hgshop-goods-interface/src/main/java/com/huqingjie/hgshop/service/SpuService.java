package com.huqingjie.hgshop.service;

import com.github.pagehelper.PageInfo;
import com.huqingjie.hgshop.pojo.Spu;
import com.huqingjie.hgshop.pojo.SpuVo;

public interface SpuService {

	PageInfo<Spu> listSpu(int page, SpuVo vo);

	int addSpu(Spu spu);

	int updateSpu(Spu spu);

	int deleteSpu(int id);

	Spu getSpu(int id);

	int deleteSpuBatch(int[] id);

}
