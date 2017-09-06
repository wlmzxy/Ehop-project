package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.dao.GoodsDao;
import org.lanqiao.dao.impl.GoodsDaoImpl;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
	private GoodsDao dao=new GoodsDaoImpl();
	@Override
	public PageInfo<Goods> list(String cid, int pageSize, int pageIndex) {
		// TODO Auto-generated method stub
		return dao.list(cid, pageSize, pageIndex);
	}

	@Override
	public int getTotalNumber(String cid) {
		// TODO Auto-generated method stub
		return dao.getTotalNumber(cid);
	}

	@Override
	public Goods getGoods(String gid) {
		// TODO Auto-generated method stub
		return dao.getGoods(gid);
	}

	@Override
	public List<Goods> getGoodsByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return dao.getGoodsByKeyword(keyword);
	}

	@Override
	public List<String> getListByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return dao.getListByKeyword(keyword);
	}

}
