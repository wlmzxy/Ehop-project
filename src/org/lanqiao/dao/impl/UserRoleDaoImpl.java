package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lanqiao.dao.UserRoleDao;
import org.lanqiao.entity.UserRole;
import org.lanqiao.util.DBUtil;

public class UserRoleDaoImpl implements UserRoleDao {

	@Override
	public UserRole getUserRoleByRoleId(String roleid) {
		// TODO Auto-generated method stub
		UserRole userRole=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from t_userrole where uroleid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,roleid);
			rs=ps.executeQuery();
			if(rs.next()){
				userRole=new UserRole(rs.getString(1), rs.getString(2));
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
		
		return userRole;
	}

}
