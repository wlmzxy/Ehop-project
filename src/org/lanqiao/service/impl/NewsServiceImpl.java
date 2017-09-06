package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.dao.NewsDao;
import org.lanqiao.dao.impl.NewsDaoImpl;
import org.lanqiao.entity.News;
import org.lanqiao.service.NewsService;

public class NewsServiceImpl implements NewsService {
	private NewsDao dao=new NewsDaoImpl();
	@Override
	public List<News> newList() {
		// TODO Auto-generated method stub
		return dao.newList();
	}
	@Override
	public News getNews(String tid) {
		// TODO Auto-generated method stub
		return dao.getNews(tid);
	}

}
