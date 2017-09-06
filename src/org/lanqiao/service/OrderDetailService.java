package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.OrderDetail;

public interface OrderDetailService {
	public void addDates(OrderDetail orderDetail);
	public  List<OrderDetail> getOrderDetailByOrderId(String orderid);
}
