package org.lanqiao.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Che;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.Order;
import org.lanqiao.entity.OrderDetail;
import org.lanqiao.entity.User;
import org.lanqiao.service.GoodsService;
import org.lanqiao.service.OrderDetailService;
import org.lanqiao.service.OrderService;
import org.lanqiao.service.impl.GoodsServiceImpl;
import org.lanqiao.service.impl.OrderDetailServiceImpl;
import org.lanqiao.service.impl.OrderServiceImpl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
@WebServlet("/ordersuccessservlet")
public class OrderSuccessServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		User user=(User)req.getSession().getAttribute("user");
		String sum=req.getParameter("sum");
		TypeToken<List<Che>> listType = new TypeToken<List<Che>>() { };
    	Gson gson=new Gson();
		Cookie[] cookies=req.getCookies();
		Cookie cookie=null;
		for(Cookie c:cookies){
			if(c.getName().equals("che")){
				cookie=c;
			}
		}
		GoodsService gs=new GoodsServiceImpl();
		OrderService os=new OrderServiceImpl();
		OrderDetailService od=new OrderDetailServiceImpl();
		Order order=null;
		OrderDetail orderDetail=null;
		
		String orderid=UUID.randomUUID().toString();
		String userid=user.getUserid();
		java.util.Date udate=new java.util.Date();
		Date sqlDate =new Date(udate.getTime());
		
		List<Che> list=gson.fromJson(cookie.getValue(), listType.getType());
		for(int i=0;i<list.size();i++){
			Che che=list.get(i);
			String gid=che.getGid();
			Goods goods=gs.getGoods(gid);
			order=new Order(orderid, gid, userid,che.getNumber()*goods.getGinprice(), sqlDate);
			os.addOrder(order);
				
			String orderdetailid=UUID.randomUUID().toString();
			String gtitle=goods.getGtitle();
			int gsalprice=goods.getGinprice();
			int gnumber=che.getNumber();
			orderDetail=new OrderDetail(orderdetailid, gtitle, gsalprice, gnumber, orderid);
			od.addDates(orderDetail);
		}
		//删除cookie，清空购物车
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		req.getRequestDispatcher("/WEB-INF/ordersuccess.jsp").forward(req, resp);
		
	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(req, resp);
		}
}
