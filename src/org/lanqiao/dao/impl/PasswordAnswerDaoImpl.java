package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lanqiao.dao.PasswordAnswerDao;
import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.util.DBUtil;

public class PasswordAnswerDaoImpl implements PasswordAnswerDao {

	@Override
	public void addPasswordAnswer(PasswordAnswer passwordAnswer) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into t_passwordanswer values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, passwordAnswer.getAnswerid());
			ps.setString(2, passwordAnswer.getAquestion());
			ps.setString(3, passwordAnswer.getAnswer());
			ps.setString(4, passwordAnswer.getEmail());
			ps.setString(5, passwordAnswer.getUserid());
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
	public PasswordAnswer getPasswordAnswerByUserid(String userid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		PasswordAnswer passwordAnswer=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from t_passwordanswer where userid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs=ps.executeQuery();
			if(rs.next()){
				passwordAnswer=new PasswordAnswer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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
		return passwordAnswer;
	}

	@Override
	public void updatePasswordAnswer(PasswordAnswer passwordAnswer) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtil.getConnection();
			String sql="update t_passwordanswer set answerid=?,aquestion=?,answer=?,email=?,userid=?  where userid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, passwordAnswer.getAnswerid());
			ps.setString(2, passwordAnswer.getAquestion());
			ps.setString(3, passwordAnswer.getAnswer());
			ps.setString(4, passwordAnswer.getEmail());
			ps.setString(5, passwordAnswer.getUserid());
			ps.setString(6, passwordAnswer.getUserid());
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

}
