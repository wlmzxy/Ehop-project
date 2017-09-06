package org.lanqiao.entity;

import java.sql.Date;

public class Order {
private String orderid;
private String gid;
private String userid;
private int totalprice;
private Date orderdate;

public Order(String orderid, String gid, String userid, int totalprice,
		Date orderdate) {
	super();
	this.orderid = orderid;
	this.gid = gid;
	this.userid = userid;
	this.totalprice = totalprice;
	this.orderdate = orderdate;
}

public String getOrderid() {
	return orderid;
}

public void setOrderid(String orderid) {
	this.orderid = orderid;
}

public String getGid() {
	return gid;
}

public void setGid(String gid) {
	this.gid = gid;
}

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}

public int getTotalprice() {
	return totalprice;
}

public void setTotalprice(int totalprice) {
	this.totalprice = totalprice;
}

public Date getOrderdate() {
	return orderdate;
}

public void setOrderdate(Date orderdate) {
	this.orderdate = orderdate;
}

@Override
public String toString() {
	return "Order [orderid=" + orderid + ", gid=" + gid + ", userid=" + userid
			+ ", totalprice=" + totalprice + ", orderdate=" + orderdate + "]";
}

}
