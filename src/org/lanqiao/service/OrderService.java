package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Order;

public interface OrderService {
	public  void addOrder(Order order);
	public List<Order> getOrderByUserid(String userid);
}
