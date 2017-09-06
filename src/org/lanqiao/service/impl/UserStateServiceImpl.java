package org.lanqiao.service.impl;

import org.lanqiao.dao.UserStateDao;
import org.lanqiao.dao.impl.UserStateDaoImpl;
import org.lanqiao.entity.UserState;
import org.lanqiao.service.UserStateService;

public class UserStateServiceImpl implements UserStateService {
private UserStateDao dao =new UserStateDaoImpl();

@Override
public UserState getUserStateByUstateid(String ustateid) {
	// TODO Auto-generated method stub
	return dao.getUserStateByUstateid(ustateid);
}
}
