package org.lanqiao.entity;

import java.util.ArrayList;
import java.util.List;

//封装当前页的全部数据
public class PageInfo<T> {
	private int pageSize;//每页的记录数
	private int pageIndex;//页码
	private int totalNumber;//总记录数
	private List<T> datas=new ArrayList<T>();
	//判断是否为首页
	public boolean isFirstPage(){
		return this.pageIndex==1;
	}
	//判断是否为尾页
	public boolean isLastPage(){
		int totalPages=(this.totalNumber % this.pageSize)==0? (this.totalNumber / this.pageSize): (this.totalNumber / this.pageSize+1);
		return this.pageIndex==totalPages;
	}
	//总页数
	public  int getTotalPages(){
		int totalPages=(this.totalNumber % this.pageSize)==0? (this.totalNumber / this.pageSize): (this.totalNumber / this.pageSize+1);
		
		return totalPages;
		
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
	
}
