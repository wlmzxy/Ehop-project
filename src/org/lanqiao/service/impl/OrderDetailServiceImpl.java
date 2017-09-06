package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.dao.OrderDetailDao;
import org.lanqiao.dao.impl.OrderDetailDaoImpl;
import org.lanqiao.entity.OrderDetail;
import org.lanqiao.service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {
private OrderDetailDao dao=new OrderDetailDaoImpl();

@Override
public void addDates(OrderDetail orderDetail) {
	// TODO Auto-generated method stub
	dao.addDates(orderDetail);
}

@Override
public List<OrderDetail> getOrderDetailByOrderId(String orderid) {
	// TODO Auto-generated method stub
	return dao.getOrderDetailByOrderId(orderid);
}
}
