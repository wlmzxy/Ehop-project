package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao.CategoryDao;
import org.lanqiao.dao.GoodsDao;
import org.lanqiao.dao.PublisherDao;
import org.lanqiao.entity.Category;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.entity.Publisher;
import org.lanqiao.util.DBUtil;

public class GoodsDaoImpl implements GoodsDao {

	@Override
	public PageInfo<Goods> list(String cid, int pageSize, int pageIndex) {
		// TODO Auto-generated method stub
		int startIndex=(pageIndex-1)*pageSize+1;
		int endIndex=pageIndex*pageSize;
		PageInfo<Goods> pageInfo=new PageInfo<Goods>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Goods> list=new ArrayList<Goods>();
			try {
				conn = DBUtil.getConnection();
				String sql="select * from (select e.*,rownum num from (select * from t_goods where cid=? order by gid ) e ) d where num between ? and ? ";
				ps=conn.prepareStatement(sql);
				ps.setString(1, cid);
				ps.setInt(2, startIndex);
				ps.setInt(3, endIndex);
				rs=ps.executeQuery();
				Goods goods=null;
				while(rs.next()){
					goods=new Goods(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10));
					list.add(goods);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if(rs!=null){
						rs.close();
					}
					if (ps!=null) {
						ps.close();
					}
					if (conn!=null) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pageInfo.setDatas(list);
				pageInfo.setPageIndex(pageIndex);
				pageInfo.setPageSize(pageSize);
				pageInfo.setTotalNumber(this.getTotalNumber(cid));
			}
		
		return pageInfo;
	}

	@Override
	public int getTotalNumber(String cid) {
		// TODO Auto-generated method stub
		int total=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select count(*) from t_goods where cid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, cid);
			rs=ps.executeQuery();
			while(rs.next()){
					total=rs.getInt(1);
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
		return total;
	}

	@Override
	public Goods getGoods(String gid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Goods goods=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from t_goods where gid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, gid);
			rs=ps.executeQuery();
			if(rs.next()){
					goods=new Goods(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10));
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
		return goods;
	}

	@Override
	public List<Goods> getGoodsByKeyword(String keyword) {
		// TODO Auto-generated method stub
		List<Goods> list=new ArrayList<Goods>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Goods goods=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from t_goods ";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				CategoryDao categoryDao=new CategoryDaoImpl();
				Category category=categoryDao.getCategory(rs.getString(9));
				PublisherDao publisherDao=new PublisherDaoImpl();
				Publisher publisher=publisherDao.getPublisher(rs.getString(10));
				if(rs.getString(2).contains(keyword)
				|| rs.getString(3).contains(keyword)
				|| rs.getString(6).contains(keyword)
				||category.getCname().contains(keyword)
				||publisher.getPname().contains(keyword)){
				goods=new Goods(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10));
				list.add(goods);	
			}
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
	public List<String> getListByKeyword(String keyword) {
		// TODO Auto-generated method stub
		List<String > list=new ArrayList<String>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String string=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from t_goods ";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				CategoryDao categoryDao=new CategoryDaoImpl();
				Category category=categoryDao.getCategory(rs.getString(9));
				PublisherDao publisherDao=new PublisherDaoImpl();
				Publisher publisher=publisherDao.getPublisher(rs.getString(10));
				if(rs.getString(2).contains(keyword)){
					string=rs.getString(2);
					list.add(string);
				}
				if(rs.getString(3).contains(keyword)){
					string=rs.getString(3);
					list.add(string);
				}
				if(rs.getString(6).contains(keyword)){
					string=rs.getString(6);
					list.add(string);
				}
				if(category!=null&&category.getCname().contains(keyword)){
					string=category.getCname();
					list.add(string);
				}
				if(publisher!=null&&publisher.getPname().contains(keyword)){
					string=publisher.getPname();
					list.add(string);
				}
					
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
	public Goods getGoodsByGtitle(String gtitle) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Goods goods=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from t_goods where gtitle=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, gtitle);
			rs=ps.executeQuery();
			if(rs.next()){
					goods=new Goods(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10));
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
		return goods;
	}
}