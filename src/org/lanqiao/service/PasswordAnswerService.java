package org.lanqiao.service;

import org.lanqiao.entity.PasswordAnswer;

public interface PasswordAnswerService {
public void addPasswordAnswer(PasswordAnswer passwordAnswer);
public PasswordAnswer getPasswordAnswerByUserid(String userid);
public void updatePasswordAnswer(PasswordAnswer passwordAnswer);
}
