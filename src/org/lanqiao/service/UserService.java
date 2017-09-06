package org.lanqiao.service;

import org.lanqiao.entity.User;

public interface UserService {
public void addUser(User user);
public User getUserByLoginid(String loginid);
public User getUserByUserid(String userid);
public void updateUser(String userid,String ustateid);
public void updateUser(User user);
public User getUserByEmail(String email);
}
