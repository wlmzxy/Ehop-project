package org.lanqiao.entity;

public class UserState {
private String ustateid;
private String usatename;
public String getUstateid() {
	return ustateid;
}
public void setUstateid(String ustateid) {
	this.ustateid = ustateid;
}
public String getUsatename() {
	return usatename;
}
public void setUsatename(String usatename) {
	this.usatename = usatename;
}
public UserState(String ustateid, String usatename) {
	super();
	this.ustateid = ustateid;
	this.usatename = usatename;
}
@Override
public String toString() {
	return "UserState [ustateid=" + ustateid + ", usatename=" + usatename + "]";
}

}
