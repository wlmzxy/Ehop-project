package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lanqiao.dao.PublisherDao;
import org.lanqiao.entity.Publisher;
import org.lanqiao.util.DBUtil;

import com.sun.org.apache.regexp.internal.recompile;

public class PublisherDaoImpl implements PublisherDao {

	@Override
	public Publisher getPublisher(String pid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Publisher publisher=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from t_publisher where pid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, pid);
			rs=ps.executeQuery();
			if(rs.next()){
				publisher=new Publisher(rs.getString(1), rs.getString(2));
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
		return publisher;
	}

}
