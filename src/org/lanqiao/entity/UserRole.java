package org.lanqiao.entity;

public class UserRole {
private String uroleid;
private String urolename;
public String getUroleid() {
	return uroleid;
}
public void setUroleid(String uroleid) {
	this.uroleid = uroleid;
}
public String getUrolename() {
	return urolename;
}
public void setUrolename(String urolename) {
	this.urolename = urolename;
}
public UserRole(String uroleid, String urolename) {
	super();
	this.uroleid = uroleid;
	this.urolename = urolename;
}
@Override
public String toString() {
	return "UserRole [uroleid=" + uroleid + ", urolename=" + urolename + "]";
}

}
