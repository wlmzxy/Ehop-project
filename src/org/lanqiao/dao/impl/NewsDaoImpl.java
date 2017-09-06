package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao.NewsDao;
import org.lanqiao.entity.News;
import org.lanqiao.util.DBUtil;

public class NewsDaoImpl implements NewsDao {

	@Override
	public List<News> newList() {
		// TODO Auto-generated method stub
		List<News> list =new ArrayList<News>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		News news=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from t_news";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				news= new News(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4));
				list.add(news);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
	public News getNews(String tid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		News news=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from t_news where tid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,tid);
			rs=ps.executeQuery();
			while(rs.next()){
				news= new News(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
		return news;
	}

}
