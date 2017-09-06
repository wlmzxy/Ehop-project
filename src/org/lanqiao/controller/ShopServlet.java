package org.lanqiao.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.dao.OrderDao;
import org.lanqiao.dao.OrderDetailDao;
import org.lanqiao.dao.impl.OrderDaoImpl;
import org.lanqiao.dao.impl.OrderDetailDaoImpl;
import org.lanqiao.entity.Order;
import org.lanqiao.entity.OrderDetail;

import com.google.gson.Gson;
@WebServlet("/shopservlet")
public class ShopServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	req.setCharacterEncoding("utf-8");
	resp.setCharacterEncoding("utf-8");
	resp.setContentType("text/html;charset=utf-8");
	
	String orderid=req.getParameter("orderid");
	if(orderid!=null){
	OrderDetailDao orderDetailDao=new OrderDetailDaoImpl();
	List<OrderDetail> list=orderDetailDao.getOrderDetailByOrderId(orderid);
	Gson gson=new Gson();
	req.getSession().setAttribute("orderlist", gson.toJson(list));
	req.getRequestDispatcher("/WEB-INF/shop.jsp").forward(req, resp);
	}
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
