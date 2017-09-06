package org.lanqiao.service.impl;

import org.lanqiao.dao.PasswordAnswerDao;
import org.lanqiao.dao.impl.PasswordAnswerDaoImpl;
import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.service.PasswordAnswerService;

public class PasswordAnswerServiceImpl implements PasswordAnswerService {
private PasswordAnswerDao dao =new PasswordAnswerDaoImpl();

@Override
public void addPasswordAnswer(PasswordAnswer passwordAnswer) {
	// TODO Auto-generated method stub
	dao.addPasswordAnswer(passwordAnswer);
}

@Override
public PasswordAnswer getPasswordAnswerByUserid(String userid) {
	// TODO Auto-generated method stub
	return dao.getPasswordAnswerByUserid(userid);
}

@Override
public void updatePasswordAnswer(PasswordAnswer passwordAnswer) {
	// TODO Auto-generated method stub
	dao.updatePasswordAnswer(passwordAnswer);
}
}
