package org.lanqiao.entity;

public class Publisher {
	private String pid;
	private String pname;
	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Publisher(String pid, String pname) {
		super();
		this.pid = pid;
		this.pname = pname;
	}

	@Override
	public String toString() {
		return "Publisher [pid=" + pid + ", pname=" + pname + "]";
	}
	
}
