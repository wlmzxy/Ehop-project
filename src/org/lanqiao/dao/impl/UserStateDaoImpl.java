package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lanqiao.dao.UserStateDao;
import org.lanqiao.entity.UserState;
import org.lanqiao.util.DBUtil;

public class UserStateDaoImpl implements UserStateDao {

	@Override
	public UserState getUserStateByUstateid(String ustateid) {
		// TODO Auto-generated method stub
		UserState uState=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from t_userstate where ustateid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,ustateid);
			rs=ps.executeQuery();
			if(rs.next()){
				uState=new UserState(rs.getString(1), rs.getString(2));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){rs.close();}
				if(ps!=null){ps.close();}
				if(conn!=null){conn.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return uState;
	}

}
