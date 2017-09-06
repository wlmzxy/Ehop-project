package org.lanqiao.entity;

public class Che {
	private String gid;
	private int number;
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Che(String gid, int number) {
		super();
		this.gid = gid;
		this.number = number;
	}
	@Override
	public String toString() {
		return "Che [gid=" + gid + ", number=" + number + "]";
	}
	
}
