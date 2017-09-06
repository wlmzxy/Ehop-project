package org.lanqiao.service.impl;

import org.lanqiao.dao.PublisherDao;
import org.lanqiao.dao.impl.PublisherDaoImpl;
import org.lanqiao.entity.Publisher;
import org.lanqiao.service.PublisherService;

public class PublisherServiceImpl implements PublisherService {
private PublisherDao dao=new PublisherDaoImpl();
	@Override
	public Publisher getPublisher(String pid) {
		// TODO Auto-generated method stub
		return dao.getPublisher(pid);
	}

}
