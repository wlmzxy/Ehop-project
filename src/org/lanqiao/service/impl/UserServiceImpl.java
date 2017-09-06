package org.lanqiao.service.impl;

import org.lanqiao.dao.UserDao;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;

public class UserServiceImpl implements UserService {
private UserDao dao =new UserDaoImpl();

@Override
public void addUser(User user) {
	// TODO Auto-generated method stub
	dao.addUser(user);
}

@Override
public User getUserByLoginid(String loginid) {
	// TODO Auto-generated method stub
	return dao.getUserByLoginid(loginid);
}

@Override
public void updateUser(String userid, String ustateid) {
	// TODO Auto-generated method stub
	dao.updateUser(userid, ustateid);
}

@Override
public void updateUser(User user) {
	// TODO Auto-generated method stub
	dao.updateUser(user);
}

@Override
public User getUserByUserid(String userid) {
	// TODO Auto-generated method stub
	return dao.getUserByUserid(userid);
}

@Override
public User getUserByEmail(String email) {
	// TODO Auto-generated method stub
	return dao.getUserByEmail(email);
}
}
