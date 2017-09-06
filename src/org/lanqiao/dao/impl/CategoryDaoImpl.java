package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao.CategoryDao;
import org.lanqiao.entity.Category;
import org.lanqiao.entity.News;
import org.lanqiao.util.DBUtil;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		List<Category> list =new ArrayList<Category>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Category category=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from t_category order by orderid";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				category= new Category(rs.getString(1),rs.getString(2));
				list.add(category);
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
	public Category getCategory(String cid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Category category=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from t_category where cid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, cid);
			rs=ps.executeQuery();
			if(rs.next()){
				category= new Category(rs.getString(1),rs.getString(2));
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
		return category;
	}

}
