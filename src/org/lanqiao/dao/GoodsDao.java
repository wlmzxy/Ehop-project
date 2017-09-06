package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;

public interface GoodsDao {
	public PageInfo<Goods> list(String cid,int pageSize,int pageIndex);
	public int getTotalNumber(String cid);
	public Goods getGoods(String gid);
	public Goods getGoodsByGtitle(String gtitle);
	public List<Goods> getGoodsByKeyword(String keyword);
	public List<String> getListByKeyword(String keyword);
	
}
