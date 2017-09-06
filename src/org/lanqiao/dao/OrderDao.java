package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Order;

public interface OrderDao {
public  void addOrder(Order order);
public List<Order> getOrderByUserid(String userid);
public List<Order> getOrderByOrderid(String orderid);
}
