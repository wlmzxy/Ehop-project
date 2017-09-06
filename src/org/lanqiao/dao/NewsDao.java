package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.News;

public interface NewsDao {
	public List<News> newList();
	public News getNews(String tid);
}
