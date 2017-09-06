package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao.OrderDao;
import org.lanqiao.entity.Order;
import org.lanqiao.util.DBUtil;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into t_order values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, order.getOrderid());
			ps.setString(2, order.getGid());
			ps.setString(3, order.getUserid());
			ps.setInt(4, order.getTotalprice());
			ps.setDate(5,order.getOrderdate());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null){
					ps.close();
					}
				if(conn!=null){
					conn.close();
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Order> getOrderByUserid(String userid) {
		// TODO Auto-generated method stub
		List<Order> list=new ArrayList<Order>();
		Order order=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from t_order where userid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs=ps.executeQuery();
			while (rs.next()) {
				order=new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5));
				list.add(order);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
					}
				if(ps!=null){
					ps.close();
					}
				if(conn!=null){
					conn.close();
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public List<Order> getOrderByOrderid(String orderid) {
		// TODO Auto-generated method stub
		List<Order> list=new ArrayList<Order>();
		Order order=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from t_order where orderid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, orderid);
			rs=ps.executeQuery();
			while (rs.next()) {
				order=new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5));
				list.add(order);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
					}
				if(ps!=null){
					ps.close();
					}
				if(conn!=null){
					conn.close();
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
