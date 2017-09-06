package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao.OrderDetailDao;
import org.lanqiao.entity.OrderDetail;
import org.lanqiao.util.DBUtil;

public class OrderDetailDaoImpl implements OrderDetailDao {

	@Override
	public void addDates(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into t_orderdetail values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, orderDetail.getOrderdetailid());
			ps.setString(2, orderDetail.getGtitle());
			ps.setInt(3, orderDetail.getGsalprice());
			ps.setInt(4, orderDetail.getGnumber());
			ps.setString(5,orderDetail.getOrderid());
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
	public List<OrderDetail> getOrderDetailByOrderId(String orderid) {
		// TODO Auto-generated method stub
		OrderDetail orderDetail=null;
		List<OrderDetail> list=new ArrayList<OrderDetail>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from t_orderdetail where orderid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, orderid);
			rs=ps.executeQuery();
			while(rs.next()){
			orderDetail=new OrderDetail(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			list.add(orderDetail);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					ps.close();
					}
				if(rs!=null){
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
