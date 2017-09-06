package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.dao.OrderDao;
import org.lanqiao.dao.impl.OrderDaoImpl;
import org.lanqiao.entity.Order;
import org.lanqiao.service.OrderService;

public class OrderServiceImpl implements OrderService {
private OrderDao dao =new OrderDaoImpl();

@Override
public void addOrder(Order order) {
	// TODO Auto-generated method stub
	dao.addOrder(order);;
}

@Override
public List<Order> getOrderByUserid(String userid) {
	// TODO Auto-generated method stub
	return dao.getOrderByUserid(userid);
}
}
