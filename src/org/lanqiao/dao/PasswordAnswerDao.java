package org.lanqiao.dao;

import org.lanqiao.entity.PasswordAnswer;

public interface PasswordAnswerDao {
public void addPasswordAnswer( PasswordAnswer passwordAnswer);
public PasswordAnswer getPasswordAnswerByUserid(String userid);
public void updatePasswordAnswer(PasswordAnswer passwordAnswer);
}
