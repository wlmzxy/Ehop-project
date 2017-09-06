package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.OrderDetail;

public interface OrderDetailDao {
	public void addDates(OrderDetail orderDetail);
	public List<OrderDetail> getOrderDetailByOrderId(String orderid);
}
